package com.example.sad.tpharma.metier.entite;

public class Commande {
    private String nomGrossiste;
    private String numeroFactureCommande;
    private String dateCommande;
    private String statutCommande;

    public Commande(String nomGrossiste, String numeroFactureCommande, String dateCommande, String statutCommande) {
        this.nomGrossiste = nomGrossiste;
        this.numeroFactureCommande = numeroFactureCommande;
        this.dateCommande = dateCommande;
        this.statutCommande = statutCommande;
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
}
