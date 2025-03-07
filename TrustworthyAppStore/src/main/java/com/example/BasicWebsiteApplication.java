package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SpringBootApplication
public class BasicWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicWebsiteApplication.class, args);
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Trustworthy App Store");
        return "home";  // Return home.html
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Return login.html
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";  // Returns register.html
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if ("admin".equals(username) && "password".equals(password)) {
            model.addAttribute("message", "Welcome, " + username + "!");
            return "home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
