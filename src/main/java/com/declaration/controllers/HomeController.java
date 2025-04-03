package com.declaration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("message", "Welcome to OBR!");
        return "home"; // This must match the name of your home.html file
    }
    @GetMapping("/about")
    public String showAboutPage(Model model) {
        model.addAttribute("message", "Welcome to OBR!");
        return "about"; // This must match the name of your about.html file
    }
    @GetMapping("/info")
    public String showInfoPage(Model model) {
        model.addAttribute("message", "Welcome to OBR!");
        return "info"; // This must match the name of your info.html file
    }
}
