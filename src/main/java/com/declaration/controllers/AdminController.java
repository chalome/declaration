package com.declaration.controllers;

import com.declaration.models.Utilisateur;
import com.declaration.models.Declaration;
import com.declaration.services.UtilisateurService;
import com.declaration.services.DeclarationService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
}
