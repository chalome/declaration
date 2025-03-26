package com.declaration.services;

import com.declaration.models.ModePaiement;
import com.declaration.repositories.ModePaiementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModePaiementService {

    private final ModePaiementRepository modePaiementRepository;

    public ModePaiementService(ModePaiementRepository modePaiementRepository) {
        this.modePaiementRepository = modePaiementRepository;
    }

    // Get all payment modes
    public List<ModePaiement> getAllModePaiements() {
        return modePaiementRepository.findAll();
    }
}
