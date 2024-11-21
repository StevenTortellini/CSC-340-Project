package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        // Replace with your own logic to get the current user
        User user = userService.findByUsername("currentUsername");
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/edit";
    }

    @PostMapping("/delete")
    public String deleteUser() {
        // Replace with your own logic to get the current user
        User user = userService.findByUsername("currentUsername");
        userService.delete(user);
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
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
}