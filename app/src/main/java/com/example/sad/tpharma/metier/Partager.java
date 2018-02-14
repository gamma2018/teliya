package com.example.sad.tpharma.metier;

import com.example.sad.tpharma.metier.entite.Produit;

import java.util.ArrayList;

public class Partager {

    public static String username;

    public static String getUsername() {
        return username;
    }

    public static ArrayList<Produit> listeProuits;


    public static ArrayList<Produit> getListeProuits() {
        return listeProuits;
    }

    public static void setListeProuits(ArrayList<Produit> listeProuits) {
        Partager.listeProuits = listeProuits;
    }

    public static void setUsername(String username) {
        Partager.username = username;
    }
}
