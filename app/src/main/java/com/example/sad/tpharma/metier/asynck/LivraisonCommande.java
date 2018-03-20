package com.example.sad.tpharma.metier.asynck;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.List;


public class LivraisonCommande extends AsyncTask<Void, Void, Boolean> {

    private Context c;
    private ProgressDialog pD;
    List<Produit> produitsList;

    public LivraisonCommande(Context c, ProgressDialog pD, List<Produit> produitsList) {
        this.c = c;
        this.pD = pD;
        this.produitsList = produitsList;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pD.setTitle("Traitemant");
        pD.setMessage("Veillez patienter");
        pD.show();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if (aBoolean)
            pD.dismiss();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        new Model().livraisonCommande(Partager.getIdCommande(), produitsList);

        return true;
    }
}
