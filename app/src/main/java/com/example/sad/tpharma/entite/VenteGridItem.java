package com.example.sad.tpharma.entite;

public class VenteGridItem {

    private int montant;
    private String libelleProduit;
    private int qtProduit;


    public VenteGridItem() {
    }

    public VenteGridItem(int montant, String libelleProduit, int qtProduit) {
        this.montant = montant;
        this.libelleProduit = libelleProduit;
        this.qtProduit = qtProduit;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public int getQtProduit() {
        return qtProduit;
    }

    public void setQtProduit(int qtProduit) {
        this.qtProduit = qtProduit;
    }
}
