package com.declaration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.declaration.models.Utilisateur;


public interface LoginRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByNumeroTelephone(String numeroTelephone);
    Utilisateur findById(int id);
}

