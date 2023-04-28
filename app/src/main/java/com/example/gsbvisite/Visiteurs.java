package com.example.gsbvisite;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Visiteurs {

    @SerializedName("hydra:member")
    private ArrayList<Visiteur> visiteurs;

    public ArrayList<Visiteur>getVisiteurs() { return visiteurs; }





}
