package com.declaration.controllers;

import com.declaration.models.Declaration;
import com.declaration.models.Utilisateur;
import com.declaration.services.DeclarationService;
import com.declaration.services.TypeDeclarationService;

import jakarta.servlet.http.HttpSession;

import com.declaration.services.ModePaiementService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

@Controller
@RequestMapping("/declarations")
public class DeclarationController {

    private final DeclarationService declarationService;
    private final TypeDeclarationService typeDeclarationService;
    private final ModePaiementService modePaiementService;

    public DeclarationController(DeclarationService declarationService, TypeDeclarationService typeDeclarationService, ModePaiementService modePaiementService) {
        this.declarationService = declarationService;
        this.typeDeclarationService = typeDeclarationService;
        this.modePaiementService = modePaiementService;
    }

    @GetMapping("/create")
    public String showDeclarationForm(Model model, HttpSession session) {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        
        if (utilisateur != null) {
            model.addAttribute("declaration", new Declaration());
            model.addAttribute("types", typeDeclarationService.getAllTypeDeclarations());
            model.addAttribute("modes", modePaiementService.getAllModePaiements());
            model.addAttribute("utilisateur", utilisateur);  // Add the logged-in user to the model
            return "declaration_form";
        }
        return "redirect:/login";  // If no user is logged in, redirect to the login page
    }

    @PostMapping("/save")
    public String saveDeclaration(@ModelAttribute Declaration declaration, HttpSession session) {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        
        if (utilisateur != null) {
            declaration.setUtilisateur(utilisateur);
            declaration.setDateDeclaration(new Date()); // Set current date
            declarationService.saveDeclaration(declaration);
            return "redirect:/declarations/list"; // Redirect to the list page after saving
        }
        return "redirect:/login";  // If no user is logged in, redirect to the login page
    }

    @GetMapping("/list")
    public String listDeclarations(Model model) {
        model.addAttribute("declarations", declarationService.getAllDeclarations());
        return "declarations";  // Return to the page that lists the declarations
    }
}
