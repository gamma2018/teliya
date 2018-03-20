package com.example.sad.tpharma.entite;

public class CommandeItem {

    private int montant;
    private String libelleProduit;
    private String dateProduit;


    public CommandeItem() {
    }

    public CommandeItem(int montant, String libelleProduit, String dateProduit) {
        this.montant = montant;
        this.libelleProduit = libelleProduit;
        this.dateProduit = dateProduit;
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

    public String getDateProduit() {
        return dateProduit;
    }

    public void setDateProduit(String dateProduit) {
        this.dateProduit = dateProduit;
    }
}
