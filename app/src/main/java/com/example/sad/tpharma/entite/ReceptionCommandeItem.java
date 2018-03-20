package com.example.sad.tpharma.entite;

public class HistoriqueCommandeItem {

    private int montant;
    private String statutCommande;
    private String dateProduit;
    private int nombreProd;


    public HistoriqueCommandeItem() {
    }

    public HistoriqueCommandeItem(int montant, int nombreProd,String libelleProduit, String dateProduit) {
        this.montant = montant;
        this.statutCommande = libelleProduit;
        this.dateProduit = dateProduit;
        this.nombreProd = nombreProd;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(String statutCommande) {
        this.statutCommande = statutCommande;
    }

    public String getDateProduit() {
        return dateProduit;
    }

    public void setDateProduit(String dateProduit) {
        this.dateProduit = dateProduit;
    }

    public int getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(int nombreProd) {
        this.nombreProd = nombreProd;
    }
}
