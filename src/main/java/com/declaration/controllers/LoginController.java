package com.declaration.controllers;

import com.declaration.models.Utilisateur;
import com.declaration.services.UtilisateurService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    private final UtilisateurService utilisateurService;

    public LoginController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Return the login page view
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String phoneNumber, @RequestParam String password, Model model, HttpSession session) {
        System.out.println("Received phoneNumber: " + phoneNumber);
        
        // Look up the user by phone number
        Utilisateur utilisateur = utilisateurService.findByPhoneNumber(phoneNumber);
        
        if (utilisateur == null || !utilisateur.getMotDePasse().equals(password)) {
            model.addAttribute("error", "Invalid phone number or password.");
            return "login"; // Return to login page with an error message
        }
        
        // Store the logged-in user in the session
        session.setAttribute("utilisateur", utilisateur);
    
        // Redirect based on user category
        if ("admin".equalsIgnoreCase(utilisateur.getCategory().toString())) {
            return "redirect:/admin/users"; // Redirect to dashboard for admin
        } else if ("client".equalsIgnoreCase(utilisateur.getCategory().toString())) {
            return "redirect:/home"; // Redirect to home for client
        }
    
        // Default fallback (optional)
        model.addAttribute("error", "Unknown user category.");
        return "login";
    }
}