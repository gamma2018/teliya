package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sad.tpharma.adapter.ListProduitCommande;
import com.example.sad.tpharma.entite.ListeProduitItem;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.asynck.AddProduitCommande;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.entite.ProduitCommande;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;
import java.util.List;

public class ResumeActivity extends AppCompatActivity {
    TextView txtGrossiste, txtTelGrossiste, txtAdresseGrossiste, txtMontantTotal;
    ListView listCommandeProduit;
    Button btnValider;
    private int montant = 0;
    private ArrayList<ProduitCommande> pCommande;
    ProgressDialog pD;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        //bouton retour
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtGrossiste = (TextView) findViewById(R.id.grossiste);
        txtTelGrossiste = (TextView) findViewById(R.id.telGrossiste);
        txtAdresseGrossiste = (TextView) findViewById(R.id.adresseGrossiste);
        txtMontantTotal = (TextView) findViewById(R.id.montantTotal);
        btnValider = (Button) findViewById(R.id.validerCommande);
        pD = new ProgressDialog(ResumeActivity.this, ProgressDialog.STYLE_SPINNER);

        listCommandeProduit = (ListView) findViewById(R.id.listeProduitCommande);

        ListProduitCommande adpater = new ListProduitCommande(ResumeActivity.this, R.layout.item_list, getData(Partager.getProduitsList()));
        listCommandeProduit.setAdapter(adpater);

        txtMontantTotal.setText("Total: "+String.valueOf(this.montant)+" GNF");

        //Recuperation des infos du grossiste
        txtGrossiste.setText(Partager.getListeGrossite().get(0).getLibelle());
        txtTelGrossiste.setText(Partager.getListeGrossite().get(0).getTelephone());
        txtAdresseGrossiste.setText(Partager.getListeGrossite().get(0).getAdresse());

        //Validation du bon de commande
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AddProduitCommande(Partager.getProduitsList(),pD,ResumeActivity.this).execute((Void) null);
                finish();
            }
        });
    }

    private List<ListeProduitItem> getData(List<Produit> listeProuits) {

        List<ListeProduitItem> listeProduitItems = new ArrayList<ListeProduitItem>();
        ListeProduitItem item;

        for (int i =0; i<listeProuits.size(); i++)
        {
            item = new ListeProduitItem();
            item.setLibelleProduit(listeProuits.get(i).getLibelleProduit());
            item.setPrixUnitaireProduit(listeProuits.get(i).getPu());
            item.setQuantite(listeProuits.get(i).getQuantite());
            listeProduitItems.add(item);
            this.montant += listeProuits.get(i).getPu()*listeProuits.get(i).getQuantite();
        }

        return  listeProduitItems;

    }
}
