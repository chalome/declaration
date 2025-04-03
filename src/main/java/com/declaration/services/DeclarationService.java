package com.declaration.services;

import com.declaration.models.Declaration;
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
    // Get a declaration by ID
    public Declaration getDeclarationById(int id) {
        return declarationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Declaration not found with id: " + id));
    }

    

}
