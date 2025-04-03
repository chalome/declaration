package com.declaration.repositories;

import com.declaration.models.Declaration;
import com.declaration.models.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeclarationRepository extends JpaRepository<Declaration, Integer> {
    List<Declaration> findByUtilisateur(Utilisateur utilisateur);
    Declaration getDeclarationById(Integer id);
}
