package com.declaration.controllers;

import com.declaration.models.Utilisateur;
import com.declaration.models.Declaration;
import com.declaration.services.UtilisateurService;
import com.declaration.services.DeclarationService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UtilisateurService userService;
    private final DeclarationService declarationService;

    public AdminController(UtilisateurService userService, DeclarationService declarationService) {
        this.userService = userService;
        this.declarationService = declarationService;
    }

    @GetMapping("/users")
    public String usersPage(Model model) {
        List<Utilisateur> users = (List<Utilisateur>) userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("content", "users");
        return "dashboard";
    }

    @GetMapping("/declarations")
    public String declarationsPage(Model model) {
        List<Declaration> declarations = declarationService.getAllDeclarations();
        model.addAttribute("declarations", declarations);
        model.addAttribute("content", "declarations");
        return "dashboard";
    }
        @GetMapping("/user/details/{id}")
    public String userDetailsPage(@PathVariable int id, Model model) {
        Utilisateur user = userService.getUserById(id);
        if (user == null) {
            return "redirect:/admin/users"; // Redirect if user not found
        }
        model.addAttribute("user", user);
        return "user"; // Name of the Thymeleaf template
    }

    @GetMapping("/declaration/details/{id}")
    public String declarationDetailsPage(@PathVariable int id, Model model) {
        Declaration declaration = declarationService.getDeclarationById(id);
        if (declaration == null) {
            return "redirect:/admin/declarations"; // Redirect if declaration not found
        }
        model.addAttribute("declaration", declaration);
        return "declaration_details"; // Name of the Thymeleaf template
    }
    @PostMapping("/declaration/send-email")
public String sendEmail(@RequestParam String email, @RequestParam int declarationId, RedirectAttributes redirectAttributes) {
    Declaration declaration = declarationService.getDeclarationById(declarationId);
    if (declaration == null) {
        redirectAttributes.addFlashAttribute("error", "Declaration not found.");
        return "redirect:/admin/declarations";
    }

    String subject = "Details of Your Declaration";
    String body = "Dear " + declaration.getUtilisateur().getNom() + ",\n\n" +
                  "Here are the details of your declaration:\n" +
                  "Title: " + declaration.getTypeDeDeclaration().getNom() + "\n" +
                  "Description: " + declaration.getDescription() + "\n" +
                  "Date: " + declaration.getDateDeclaration() + "\n\n" +
                  "Mode: " + declaration.getModePaiement().getNom() + "\n\n" +
                  "Thank you for your submission.\n\n" +
                  "Best regards,\nAdmin Team";

    boolean emailSent = userService.sendEmail(email, subject, body);
    if (emailSent) {
        redirectAttributes.addFlashAttribute("success", "Email sent successfully.");
    } else {
        redirectAttributes.addFlashAttribute("error", "Failed to send email.");
    }

    return "redirect:/admin/declarations";
}
}
