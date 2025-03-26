package com.declaration.repositories;

import com.declaration.models.ModePaiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModePaiementRepository extends JpaRepository<ModePaiement, Integer> {
}
