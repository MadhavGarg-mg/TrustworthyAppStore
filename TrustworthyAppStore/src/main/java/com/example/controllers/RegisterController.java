package com.example.controllers;

import com.example.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/myapp")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";  // Show register.html
    }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            userService.registerUser(email, password);
            model.addAttribute("message", "Account created successfully!");
            return "redirect:/myapp";  // Redirect to login page on success
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "register";  // Stay on registration page on error
        }
    }
}
