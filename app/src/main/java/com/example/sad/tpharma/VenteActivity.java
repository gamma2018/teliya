package com.example.sad.tpharma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.sad.tpharma.adapter.HomeGridAdapter;
import com.example.sad.tpharma.entite.HomeItem;

import java.util.ArrayList;

public class VenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vente);

        GridView gridVente = (GridView) findViewById(R.id.gridVente);
        HomeGridAdapter adapter = new HomeGridAdapter(this, R.layout.custum_grid_home, getData());

        gridVente.setAdapter(adapter);
    }

    private ArrayList<HomeItem> getData()
    {
        ArrayList<HomeItem> items = new ArrayList<HomeItem>();

        HomeItem item = new HomeItem();

        item.setLibelle("Vente");
        item.setDescription("Vente produit");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Produit");
        item.setDescription("Les produits");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Commande");
        item.setDescription("Les commande");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Produit");
        item.setDescription("Les produits");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Commande");
        item.setDescription("Les commande");
        item.setImage(R.drawable.client);
        items.add(item);

        item.setLibelle("Vente");
        item.setDescription("Vente produit");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Produit");
        item.setDescription("Les produits");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Commande");
        item.setDescription("Les commande");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Produit");
        item.setDescription("Les produits");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Commande");
        item.setDescription("Les commande");
        item.setImage(R.drawable.client);
        items.add(item);

        item.setLibelle("Vente");
        item.setDescription("Vente produit");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Produit");
        item.setDescription("Les produits");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Commande");
        item.setDescription("Les commande");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Produit");
        item.setDescription("Les produits");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Commande");
        item.setDescription("Les commande");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Produit");
        item.setDescription("Les produits");
        item.setImage(R.drawable.client);
        items.add(item);

        item = new HomeItem();
        item.setLibelle("Commande");
        item.setDescription("Les commande");
        item.setImage(R.drawable.client);
        items.add(item);



        return items;
    }
}
