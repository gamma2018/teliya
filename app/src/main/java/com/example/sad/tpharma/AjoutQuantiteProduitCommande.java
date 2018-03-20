package com.example.sad.tpharma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.sad.tpharma.adapter.CommandeQuantiteAdapter;
import com.example.sad.tpharma.entite.InventaireItem;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.entite.Produit;

import java.util.ArrayList;
import java.util.List;

public class AjoutQuantiteProduitCommande extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_quantite_produit_commande);

        Button btnSuivant = (Button) findViewById(R.id.commandeSuivant);
        ListView lvProduit = (ListView) findViewById(R.id.listeProduitCommande);
        final CommandeQuantiteAdapter adapter = new CommandeQuantiteAdapter(AjoutQuantiteProduitCommande.this, R.layout.custom_adding_quantite, getData(Partager.getListeProuits()));
        lvProduit.setAdapter(adapter);

        btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Partager.setProduitsList(adapter.getProduits());
                Intent intent = new Intent(AjoutQuantiteProduitCommande.this, ResumeActivity.class);
                startActivity(intent);
            }
        });

    }

    private List<InventaireItem> getData(List<Produit> produitsList) {

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
