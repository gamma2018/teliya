package com.example.sad.tpharma.entite;

public class ReceptionCommandeItem {

    private int montant;
    private int idCommande;
    private String statutCommande;
    private String dateProduit;
    private int nombreProd;


    public ReceptionCommandeItem() {
    }

    public ReceptionCommandeItem(int idCommande, int montant, int nombreProd, String libelleProduit, String dateProduit) {
        this.idCommande = idCommande;
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

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
}
