package com.declaration.services;

import org.springframework.stereotype.Service;
import com.declaration.models.Utilisateur;
import com.declaration.repositories.LoginRepository;

@Service
public class UtilisateurService {

    private final LoginRepository loginRepository;

    public UtilisateurService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Utilisateur findByPhoneNumber(String phoneNumber) {
        return loginRepository.findByNumeroTelephone(phoneNumber);
    }
    public Iterable<Utilisateur> getAllUsers() {
        return loginRepository.findAll();
    }
}
