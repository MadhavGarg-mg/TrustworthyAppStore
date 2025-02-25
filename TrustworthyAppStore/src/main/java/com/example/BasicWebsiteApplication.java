package com.example;  // Declare package

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class BasicWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicWebsiteApplication.class, args);
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Spring Boot Website!");
        return "home";  // Return the name of the Thymeleaf template (home.html)
    }
}
