package com.declaration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.declaration.models.Utilisateur;
import com.declaration.repositories.LoginRepository;

@Service
public class UtilisateurService {
    @Autowired
    private JavaMailSender mailSender;
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

    public Utilisateur getUserById(int id) {
        return loginRepository.findById(id);
    }
    public boolean sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return false;
        }
    }
    
}
