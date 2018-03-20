package com.example.sad.tpharma.metier;

import com.example.sad.tpharma.metier.entite.Grossiste;
import com.example.sad.tpharma.metier.entite.Produit;

import java.util.ArrayList;
import java.util.List;

public class Partager {

    public static String username;
    public static String password;
    public static int idCommande;
    public static List<Produit> produitsList;
    public static ArrayList<Grossiste> listeGrossite;

    public static int getIdCommande() {
        return idCommande;
    }

    public static void setIdCommande(int idCommande) {
        Partager.idCommande = idCommande;
    }

    public static ArrayList<Grossiste> getListeGrossite() {
        return listeGrossite;
    }

    public static void setListeGrossite(ArrayList<Grossiste> listeGrossite) {
        Partager.listeGrossite = listeGrossite;
    }

    public static String getUsername() {
        return username;
    }

    public static ArrayList<Produit> listeProuits;

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Partager.password = password;
    }

    public static ArrayList<Produit> getListeProuits() {
        return listeProuits;
    }

    public static void setListeProuits(ArrayList<Produit> listeProuits) {
        Partager.listeProuits = listeProuits;
    }

    public static void setUsername(String username) {
        Partager.username = username;
    }

    public static List<Produit> getProduitsList() {
        return produitsList;
    }

    public static void setProduitsList(List<Produit> produitsList) {
        Partager.produitsList = produitsList;
    }
}
