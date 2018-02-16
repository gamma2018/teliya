package com.example.sad.tpharma.metier.entite;

public class Paiement {
    private String datePaiement;
    private int montantPaeiment;

    public Paiement(String datePaiement, int montantPaeiment) {
        this.datePaiement = datePaiement;
        this.montantPaeiment = montantPaeiment;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement;
    }

    public int getMontantPaeiment() {
        return montantPaeiment;
    }

    public void setMontantPaeiment(int montantPaeiment) {
        this.montantPaeiment = montantPaeiment;
    }
}
