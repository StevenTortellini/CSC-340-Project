package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping ("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "register";
    }

    @PostMapping("/register")
    public String registerAdmin(@ModelAttribute Admin admin) {
        adminService.save(admin);
        return "redirect:/admin/login";
    }

    @GetMapping("/index")
    public String showHomePage(HttpSession session, Model model) {
        String loggedInUsername = (String) session.getAttribute("loggedInUsername");
        if (loggedInUsername != null) {
            model.addAttribute("username", loggedInUsername);
        }
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "adminLogin";
    }

    @PostMapping("/login")
    public String loginAdmin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        Admin admin = adminService.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            // Store username in session
            session.setAttribute("loggedInUsername", admin.getUsername());
            return "redirect:/admin/index";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "adminLogin";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        // Invalidate the session and redirect to the login page
        return "redirect:/admin/login";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        Admin admin = adminService.findByUsername("currentUsername");
        if (admin == null) {
            throw new RuntimeException("Admin not found");
        }
        model.addAttribute("admin", admin);
        return "edit";
    }

    @PostMapping("/delete")
    public String deleteAdmin(HttpSession session) {
        // Get the username of the currently logged-in admin from the session
        String loggedInUsername = (String) session.getAttribute("loggedInUsername");

        if (loggedInUsername != null) {
            // Fetch the admin from the database
            Admin admin = adminService.findByUsername(loggedInUsername);

            if (admin != null) {
                // Delete the admin account
                adminService.delete(admin);
            }
        }

        // Invalidate the session and redirect to login page
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/edit")
    public String editAdmin(@ModelAttribute Admin admin, HttpSession session) {
        // Get the logged-in admin's username from the session
        String loggedInUsername = (String) session.getAttribute("loggedInUsername");

        // Find the admin to be updated
        Admin existingAdmin = adminService.findByUsername(loggedInUsername);

        if (existingAdmin != null) {
            // Update admin details
            existingAdmin.setUsername(admin.getUsername());
            existingAdmin.setEmail(admin.getEmail());
            adminService.save(existingAdmin);  // Save updated admin

            // Update the session with the new username
            session.setAttribute("loggedInUsername", existingAdmin.getUsername());

            // Redirect to the home page
            return "redirect:/home";
        }

        // Handle the case where admin is not found
        return "errorPage";
    }

    @GetMapping("/adminProfile")
    public String adminProfile(Model model, HttpSession session) {
        String loggedInUsername = (String) session.getAttribute("loggedInUsername");

        if (loggedInUsername != null) {
            Admin admin = adminService.findByUsername(loggedInUsername);
            model.addAttribute("admin", admin);
            return "adminProfile";
        }

        // If there's no username in the session, redirect to login page
        return "redirect:/login";
    }
    @GetMapping("/stats")
    public String StatsPage(){
        return "adminStats";
    }




}
