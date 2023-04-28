package com.example.gsbvisite;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Practicien implements Serializable {

    @SerializedName("nom")
    String nom;

    @SerializedName("prenom")
    String prenom;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Practicien(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;


    }
}
