package com.example.sad.tpharma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sad.tpharma.adapter.NewCommandeGridAdapter;
import com.example.sad.tpharma.adapter.OnItemSelected;
import com.example.sad.tpharma.entite.CommandeItem;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.entite.Grossiste;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.traitement.Model;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

public class CreeCommandeActivity extends AppCompatActivity {
    String grossiste_ = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_commande);

        Button suivant = (Button) findViewById(R.id.commandeSuivant);
        GridView gridView = (GridView) findViewById(R.id.gridNewCommande);
        EditText edRecherche = (EditText) findViewById(R.id.rechercheProduitCommande);
        final MaterialBetterSpinner grossiste = (MaterialBetterSpinner) findViewById(R.id.grossisteSelect);

        final NewCommandeGridAdapter adapter = new NewCommandeGridAdapter(CreeCommandeActivity.this, R.layout.custum_grid_commande, getData(new Model().getAllProduit()));

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(CreeCommandeActivity.this, android.R.layout.simple_list_item_1, new Model().getAllGrossiste_());
        grossiste.setAdapter(stringArrayAdapter);
        gridView.setAdapter(adapter);

        edRecherche.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence textSaisie, int start, int before, int count) {
                adapter.getFilter().filter(textSaisie);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        grossiste.addTextChangedListener(new OnItemSelected() {
            @Override
            protected void onItemSelected(String string) {
                grossiste_ = string;
            }
        });
        
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recuperation du grossiste
                ArrayList<Grossiste> listGrossite = new ArrayList<Grossiste>();
                for (int i=0;i< Partager.getListeGrossite().size(); i++)
                {
                    if (Partager.getListeGrossite().get(i).getLibelle().equals(grossiste_))
                    {
                        listGrossite.add(Partager.getListeGrossite().get(i));
                    }
                }
                Partager.setListeGrossite(listGrossite);
                Intent intent = new Intent(CreeCommandeActivity.this, AjoutQuantiteProduitCommande.class);
                startActivity(intent);
            }
        });





    }

    private ArrayList<CommandeItem> getData(ArrayList<Produit> produits) {
        ArrayList<CommandeItem> items = new ArrayList<CommandeItem>();
        CommandeItem commandeItem;

        for (int i=0; i < produits.size(); i++){
            commandeItem = new CommandeItem();
            commandeItem.setLibelleProduit(produits.get(i).getLibelleProduit());
            commandeItem.setMontant(produits.get(i).getPu());
            commandeItem.setDateProduit(produits.get(i).getDate());

            items.add(commandeItem);
        }

        return items;
    }
}
