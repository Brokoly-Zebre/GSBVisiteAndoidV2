package com.example.gsbvisite;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Visiteur implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("nom")
    private String nom;

    @SerializedName("prenom")
    private String prenom;

    @SerializedName("email")
    private String email;

    @SerializedName("practiciens")
    private ArrayList<String> practiciens;

    @SerializedName("visites")
    private  ArrayList<String> visites;

    public Visiteur(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getPracticiens() {
        return practiciens;
    }

    public ArrayList<String> getVisites() {
        return visites;
    }
}



