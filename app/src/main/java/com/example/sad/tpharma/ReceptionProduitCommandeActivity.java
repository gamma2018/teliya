package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.sad.tpharma.adapter.ReceptionCommandeListViewAdapter;
import com.example.sad.tpharma.entite.InventaireItem;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.asynck.LivraisonCommande;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;
import java.util.List;

public class ReceptionProduitCommandeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception_produit_commande);

        Button btnReception = (Button) findViewById(R.id.receptionner);
        ListView lvProduit = (ListView) findViewById(R.id.listeProduitReceptionner);
        final ProgressDialog pD = new ProgressDialog(ReceptionProduitCommandeActivity.this, ProgressDialog.STYLE_SPINNER);

        final ReceptionCommandeListViewAdapter adapter = new ReceptionCommandeListViewAdapter(ReceptionProduitCommandeActivity.this, R.layout.custom_adding_quantite,
                getData(new Model().getAllProduitCommandeFournisseur(Partager.getIdCommande())));
        lvProduit.setAdapter(adapter);

        btnReception.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LIVRAISON
                new LivraisonCommande(ReceptionProduitCommandeActivity.this, pD, adapter.getProduits()).
                    execute((Void) null);
                Intent intent = new Intent(ReceptionProduitCommandeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private List<InventaireItem> getData(ArrayList<Produit> produitsList) {

        List<InventaireItem> inventaireItems = new ArrayList<InventaireItem>();
        InventaireItem item;

        for (int i=0; i<produitsList.size(); i++)
        {
            item = new InventaireItem();
            item.setLibelle(produitsList.get(i).getLibelleProduit());
            item.setMontant(produitsList.get(i).getPu());
            item.setQuantite(produitsList.get(i).getQuantite());
            inventaireItems.add(item);
        }

        return inventaireItems;
    }
}