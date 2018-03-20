package com.example.sad.tpharma.metier.entite;

public class Commande {
    private String nomGrossiste;
    private String numeroFactureCommande;
    private String dateCommande;
    private String statutCommande;
    private int idCommande;
    private int nombreProduits;
    private  int montantCommande;

    public Commande(String nomGrossiste, String numeroFactureCommande, String dateCommande, String statutCommande) {
        this.nomGrossiste = nomGrossiste;
        this.numeroFactureCommande = numeroFactureCommande;
        this.dateCommande = dateCommande;
        this.statutCommande = statutCommande;
    }

    public Commande(int idCommande, String dateCommande, String statutCommande,String nomGrossiste, int nombreProduits, int montantCommande) {
        this.nomGrossiste = nomGrossiste;
        this.dateCommande = dateCommande;
        this.statutCommande = statutCommande;
        this.idCommande = idCommande;
        this.nombreProduits = nombreProduits;
        this.montantCommande = montantCommande;
    }

    public String getNomGrossiste() {
        return nomGrossiste;
    }

    public void setNomGrossiste(String nomGrossiste) {
        this.nomGrossiste = nomGrossiste;
    }

    public String getNumeroFactureCommande() {
        return numeroFactureCommande;
    }

    public void setNumeroFactureCommande(String numeroFactureCommande) {
        this.numeroFactureCommande = numeroFactureCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(String statutCommande) {
        this.statutCommande = statutCommande;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getNombreProduits() {
        return nombreProduits;
    }

    public void setNombreProduits(int nombreProduits) {
        this.nombreProduits = nombreProduits;
    }

    public int getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(int montantCommande) {
        this.montantCommande = montantCommande;
    }
}
