package com.example.sad.tpharma.metier.entite;

public class Stock {
    private String nomProduit;
    private String datePeremption;
    private int quantiteReel;
    private int quantiteTheorique;

    public Stock(String nomProduit, String datePeremption, int quantiteReel, int quantiteTheorique) {
        this.nomProduit = nomProduit;
        this.datePeremption = datePeremption;
        this.quantiteReel = quantiteReel;
        this.quantiteTheorique = quantiteTheorique;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(String datePeremption) {
        this.datePeremption = datePeremption;
    }

    public int getQuantiteReel() {
        return quantiteReel;
    }

    public void setQuantiteReel(int quantiteReel) {
        this.quantiteReel = quantiteReel;
    }

    public int getQuantiteTheorique() {
        return quantiteTheorique;
    }

    public void setQuantiteTheorique(int quantiteTheorique) {
        this.quantiteTheorique = quantiteTheorique;
    }
}
