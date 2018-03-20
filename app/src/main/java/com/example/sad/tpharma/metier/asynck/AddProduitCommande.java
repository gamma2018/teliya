package com.example.sad.tpharma.metier.asynck;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.sad.tpharma.MainActivity;
import com.example.sad.tpharma.ResumeActivity;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.entite.ProduitCommande;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.List;


public class AddProduitCommande extends AsyncTask<Void, Void, Boolean> {

    private ProduitCommande pCommande;
    private List<Produit> produitList;
    private ProgressDialog pD;
    private Context c;
    private int idCommande = 0;

    public AddProduitCommande(List<Produit> produitList, ProgressDialog pD, Context c) {
        this.produitList = produitList;
        this.pD = pD;
        this.c = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       // pD.setTitle("Traitement ...");
       // pD.setMessage("Veillez patienter le traitement est en cours.");
       // pD.show();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if (aBoolean){
//            pD.dismiss();
            Toast.makeText(c, "Le traitement a été effectué avec succès.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(c, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.getApplicationContext().startActivity(intent);
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        idCommande = new Model().addCommande();

        for (int i=0; i<produitList.size();i++)
        {
            pCommande = new ProduitCommande(
                    idCommande,
                    Partager.getListeGrossite().get(0).getLibelle(),
                    produitList.get(i).getLibelleProduit(),
                    produitList.get(i).getPu(),
                    produitList.get(i).getQuantite());
            new Model().addProduitCommande(pCommande);
        }
        return true;
    }
}
