package com.example.sad.telpo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sad.telpo.Entite.Partage;
import com.example.sad.telpo.Entite.Produit;
import com.example.sad.telpo.adapter.FilterWithSpaceAdapter;
import com.example.sad.telpo.adapter.ItemRecherche;
import com.example.sad.telpo.adapter.ListAdapter;
import com.example.sad.telpo.adapter.ListeItem;

import java.util.ArrayList;

/**
 * Created by SAD on 11/01/2018.
 */
public class VenteSimple extends AppCompatActivity {

    private AutoCompleteTextView edProduit;
    private EditText edQuantite;
    private Button btnAjouter;
    private ListView lvProduit;
    private ArrayList<Produit> listeProduits, produitsVendu = new ArrayList<Produit>();
    private ArrayList<ListeItem> lProduits = new ArrayList<ListeItem>();
    private ArrayList<ItemRecherche> lProduits1 = new ArrayList<ItemRecherche>();
    private ListeItem item;
    private String pu = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vente_simple_layout);

        //bouton retour
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edProduit = (AutoCompleteTextView) findViewById(R.id.prduit);
        edQuantite = (EditText) findViewById(R.id.quantite);
        btnAjouter = (Button) findViewById(R.id.ajouter);
        lvProduit = (ListView) findViewById(R.id.listeProduit);

        //Chargement de la liste de produit
        listeProduits = new ArrayList<Produit>();
        listeProduits.add(new Produit("Paracetamol", 2000));
        listeProduits.add(new Produit("Doliprane", 25000));
        listeProduits.add(new Produit("Sulfobactin", 10000));
        listeProduits.add(new Produit("Nivaquine", 5000));
        listeProduits.add(new Produit("Grippex", 1500));
        listeProduits.add(new Produit("Rhumadol", 7500));

        //chargement des produits
        for (int i = 0; i < listeProduits.size(); i++) {
            lProduits1.add(new ItemRecherche(listeProduits.get(i).getLibelle(), String.valueOf(listeProduits.get(i).getPu()) + " gnf"));
        }

        edProduit.setAdapter(new FilterWithSpaceAdapter<ItemRecherche>(VenteSimple.this, R.layout.item_list, lProduits1));
        edProduit.setThreshold(1);
        edProduit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                edProduit.setText(lProduits1.get(position).getTitre());
            }
        });

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < listeProduits.size(); i++) {
                    if (listeProduits.get(i).getLibelle().equals(edProduit.getText().toString())) {
                        pu = String.valueOf(listeProduits.get(i).getPu());
                    }
                }

                lProduits.add(new ListeItem(edProduit.getText().toString(), "Qt : " + edQuantite.getText().toString() + ", PU : " + pu));
                produitsVendu.add(new Produit(edProduit.getText().toString(), Integer.valueOf(pu), Integer.valueOf(edQuantite.getText().toString())));

                lvProduit.setAdapter(new ListAdapter(VenteSimple.this, R.layout.item_list, lProduits));
                edProduit.setText("");
                edQuantite.setText("");

                Toast.makeText(VenteSimple.this, "Produits ajouter avec succès !!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_next, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.itemSuivant) {
            Partage.setListeProduits(produitsVendu);
            Intent intent = new Intent(VenteSimple.this, ResumeVenteSimple.class);
            startActivity(intent);
            Toast.makeText(VenteSimple.this, "Suivant", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return true;
    }
}

