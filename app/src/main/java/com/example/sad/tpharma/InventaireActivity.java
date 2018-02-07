package com.example.sad.tpharma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sad.tpharma.adapter.ListAdapterIventaire;
import com.example.sad.tpharma.entite.InventaireItem;

import java.util.ArrayList;

public class InventaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventaire);

        ListView listView = (ListView) findViewById(R.id.listeInventaire);
        ArrayList<InventaireItem> items = new ArrayList<InventaireItem>();
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        items.add(new InventaireItem("Produit1","Paracetamol"));
        listView.setAdapter(new ListAdapterIventaire(this, R.layout.item_list, items));
    }
}
