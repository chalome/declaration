package com.declaration.models;

import jakarta.persistence.*;


@Entity
public class Category {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id;
private String nom;
private String description;

public Category(){
    
}

public Category(String nom, String description) {
    this.nom = nom;
    this.description = description;
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

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}
@Override
public String toString() {
    // TODO Auto-generated method stub
    return nom;
}
}
