package com.declaration.services;

import com.declaration.models.TypeDeclaration;
import com.declaration.repositories.TypeDeclarationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeDeclarationService {

    private final TypeDeclarationRepository typeDeclarationRepository;

    public TypeDeclarationService(TypeDeclarationRepository typeDeclarationRepository) {
        this.typeDeclarationRepository = typeDeclarationRepository;
    }

    // Get all type declarations
    public List<TypeDeclaration> getAllTypeDeclarations() {
        return typeDeclarationRepository.findAll();
    }
}
