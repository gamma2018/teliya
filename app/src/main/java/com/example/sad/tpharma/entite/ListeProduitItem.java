package com.example.sad.tpharma.entite;

public class ListeProduitItem {

    private String libelleProduit;
    private int prixUnitaireProduit;
    private int quantite;

    public ListeProduitItem(String libelleProduit, int prixUnitaireProduit) {
        this.libelleProduit = libelleProduit;
        this.prixUnitaireProduit = prixUnitaireProduit;
    }

    public ListeProduitItem(String libelleProduit, int prixUnitaireProduit, int quantite) {
        this.libelleProduit = libelleProduit;
        this.prixUnitaireProduit = prixUnitaireProduit;
        this.quantite = quantite;
    }

    public ListeProduitItem() {
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public int getPrixUnitaireProduit() {
        return prixUnitaireProduit;
    }

    public void setPrixUnitaireProduit(int prixUnitaireProduit) {
        this.prixUnitaireProduit = prixUnitaireProduit;
    }
}
