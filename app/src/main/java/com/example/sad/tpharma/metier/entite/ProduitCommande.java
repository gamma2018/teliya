package com.example.sad.tpharma.metier.entite;

public class ProduitCommande {

    private int idCommande;
    private String grossiste;
    private String produit;
    private int prixUnitaire;
    private int quantite;

    public ProduitCommande(int idCommande, String grossiste, String produit, int prixUnitaire, int quantite) {
        this.idCommande = idCommande;
        this.grossiste = grossiste;
        this.produit = produit;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getGrossiste() {
        return grossiste;
    }

    public void setGrossiste(String grossiste) {
        this.grossiste = grossiste;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public int getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
