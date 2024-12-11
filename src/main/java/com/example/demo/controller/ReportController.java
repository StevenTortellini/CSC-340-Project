package com.example.demo.controller;


import com.example.demo.model.Report;
import com.example.demo.service.ReportService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public String showReportForm(HttpSession session, Model model) {
        // Check if user is logged in
        String username = (String) session.getAttribute("loggedInUsername");

        // If user is not logged in, redirect to login page or show an error
        if (username == null) {
            model.addAttribute("error", "You must be logged in to report an issue.");
            return "home"; // Redirect to home or another appropriate page
        }

        // Pass the username to the form if user is logged in
        model.addAttribute("username", username);
        return "reportForm"; // Return the report form view
    }

    @PostMapping("/report")
    public String submitReport(@RequestParam String title,
                               @RequestParam String description,
                               HttpSession session,
                               Model model) {
        // Get the logged-in username from the session
        String username = (String) session.getAttribute("loggedInUsername");

        // If there's no username in the session, handle the error
        if (username == null) {
            model.addAttribute("error", "You must be logged in to report an issue.");
            return "reportForm"; // Return to the form if no user is logged in
        }

        // Create the report using the service
        Report report = reportService.createReport(title, description, username);

        // Add the report to the model for display
        model.addAttribute("report", report);

        // Redirect to home or another page after successful submission
        return "redirect:/home"; // Return a view that displays success
    }
}
