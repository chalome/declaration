
package com.declaration.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Declaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "type_declaration_id")
    private TypeDeclaration typeDeDeclaration;
    private double montant;
    private Date dateDeclaration;

    @ManyToOne
    @JoinColumn(name = "mode_paiement_id")
    private ModePaiement modePaiement;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Declaration(){
        
    }

    public Declaration(TypeDeclaration typeDeDeclaration, double montant, Date dateDeclaration, ModePaiement modePaiement, Utilisateur utilisateur) {
        this.typeDeDeclaration = typeDeDeclaration;
        this.montant = montant;
        this.dateDeclaration = dateDeclaration;
        this.modePaiement = modePaiement;
        this.utilisateur = utilisateur;
    }

    public TypeDeclaration getTypeDeDeclaration() {
        return typeDeDeclaration;
    }

    public void setTypeDeDeclaration(TypeDeclaration typeDeDeclaration) {
        this.typeDeDeclaration = typeDeDeclaration;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateDeclaration() {
        return dateDeclaration;
    }

    public void setDateDeclaration(Date dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

}
