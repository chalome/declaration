package com.declaration.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String email;
    private String numeroTelephone;
    private String nif;
    private Date dateCreation;
    private String adresse;
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Utilisateur() {

    }

    public Utilisateur(String nom, String prenom, String email, String numeroTelephone, String nif, Date dateCreation, String adresse, String motDePasse, Category category) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.nif = nif;
        this.dateCreation = dateCreation;
        this.adresse = adresse;
        this.motDePasse = motDePasse;
        this.category = category;
    }
    public Utilisateur(String nom, String prenom, String email, String numeroTelephone, String nif, Date dateCreation, String adresse, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.nif = nif;
        this.dateCreation = dateCreation;
        this.adresse = adresse;
        this.motDePasse = motDePasse;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return  prenom;
    }
}
