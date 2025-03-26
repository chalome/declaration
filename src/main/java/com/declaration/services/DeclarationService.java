package com.declaration.services;

import com.declaration.models.Declaration;
import com.declaration.models.Utilisateur;
import com.declaration.repositories.DeclarationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService {

    private final DeclarationRepository declarationRepository;

    public DeclarationService(DeclarationRepository declarationRepository) {
        this.declarationRepository = declarationRepository;
    }

    // Save a new declaration
    public Declaration saveDeclaration(Declaration declaration) {
        return declarationRepository.save(declaration);
    }

    // Get all declarations
    public List<Declaration> getAllDeclarations() {
        return declarationRepository.findAll();
    }

    public List<Declaration> getDeclarationsForUser(Utilisateur utilisateur) {
        // Fetch declarations for the given user
        return declarationRepository.findByUtilisateur(utilisateur);
    }
}
