package com.declaration.controllers;

import com.declaration.models.Utilisateur;
import com.declaration.repositories.UtilisateurRepository;
import com.declaration.services.UtilisateurService;
import com.declaration.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class AuthController {

    private final UtilisateurService userService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private CategoryRepository categoryRepository; // Assuming you have a Category repository
    
   public AuthController(UtilisateurService userService) {
        this.userService = userService;
    }
    // Show registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll()); // Pass categories for dropdown
        return "register";  // Return register.html template
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String handleRegister(String nom, String prenom, String email, String numeroTelephone, String nif, String adresse, String motDePasse, Model model) {
        // Check if the email already exists
        if (utilisateurRepository.findByEmail(email) != null) {
            model.addAttribute("error", "Email already in use");
            return "register";  // Return register page if email is already in use
        }


        // Create new Utilisateur object
        Utilisateur utilisateur = new Utilisateur(nom, prenom, email, numeroTelephone, nif, new Date(), adresse, motDePasse);
        
        // Save the user to the database
        utilisateurRepository.save(utilisateur);
        
        return "redirect:/login";  // Redirect to login page after successful registration
    }

    @GetMapping("/user/details/{id}")
    public String userDetailsPage(@PathVariable int id, Model model) {
        Utilisateur user = userService.getUserById(id);
        if (user == null) {
            return "redirect:/home"; // Redirect if user not found
        }
        model.addAttribute("user", user);
        return "user"; // Name of the Thymeleaf template
    }
}
