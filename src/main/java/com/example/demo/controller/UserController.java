package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }



    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        String loggedInUsername = (String) session.getAttribute("loggedInUsername");
        if (loggedInUsername != null) {
            model.addAttribute("username", loggedInUsername);
        }
        return "home";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }


    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Store username in session
            session.setAttribute("loggedInUsername", user.getUsername());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
    @GetMapping("/logout")
    public String logout() {
        // Invalidate the session and redirect to the login page
        return "redirect:/login";
    }



    @GetMapping("/edit")
    public String showEditForm(Model model) {
        User user = userService.findByUsername("currentUsername");
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        model.addAttribute("user", user);
        return "edit";
    }



    @PostMapping("/delete")
    public String deleteUser(HttpSession session) {
        // Get the username of the currently logged-in user from the session
        String loggedInUsername = (String) session.getAttribute("loggedInUsername");

        if (loggedInUsername != null) {
            // Fetch the user from the database
            User user = userService.findByUsername(loggedInUsername);

            if (user != null) {
                // Delete the user account
                userService.delete(user);
            }
        }

        // Invalidate the session and redirect to login page
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user, HttpSession session) {
        // Get the logged-in user's username from the session
        String loggedInUsername = (String) session.getAttribute("loggedInUsername");

        // Find the user to be updated
        User existingUser = userService.findByUsername(loggedInUsername);

        if (existingUser != null) {
            // Update user details
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            userService.save(existingUser);  // Save updated user

            // Update the session with the new username
            session.setAttribute("loggedInUsername", existingUser.getUsername());

            // Redirect to the home page
            return "redirect:/home";
        }

        // Handle the case where user is not found
        return "errorPage";
    }


    @GetMapping("/userProfile")
    public String userProfile(Model model, HttpSession session) {
        String loggedInUsername = (String) session.getAttribute("loggedInUsername");

        if (loggedInUsername != null) {
            User user = userService.findByUsername(loggedInUsername);
            model.addAttribute("user", user);
            return "userProfile";
        }

        // If there's no username in the session, redirect to login page
        return "redirect:/login";
    }






}
