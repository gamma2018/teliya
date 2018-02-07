package com.example.sad.tpharma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.sad.tpharma.adapter.ClientGridAdapter;
import com.example.sad.tpharma.adapter.FournisseurGridAdapter;
import com.example.sad.tpharma.entite.HomeItem;

import java.util.ArrayList;

public class FournisseurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fournisseur);

        GridView gridView = (GridView) findViewById(R.id.gridFournisseur);
        FournisseurGridAdapter adapter = new FournisseurGridAdapter(this, R.layout.custum_grid_fournisseur, getData());
        gridView.setAdapter(adapter);
    }

    private ArrayList<HomeItem> getData()
    {
        ArrayList<HomeItem> items = new ArrayList<HomeItem>();

        HomeItem item = new HomeItem();

        item.setImage(R.drawable.client);
        item.setLibelle("Laborex");
        item.setDescription("622-35-03-75");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Pharma Guinee");
        item.setDescription("622-35-03-75");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Philco");
        item.setDescription("622-35-03-75");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Laborex");
        item.setDescription("622-35-03-75");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Pharma Guinee");
        item.setDescription("622-35-03-75");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Philco");
        item.setDescription("622-35-03-75");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Laborex");
        item.setDescription("622-35-03-75");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Pharma Guinee");
        item.setDescription("622-35-03-75");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Philco");
        item.setDescription("622-35-03-75");
        items.add(item);


        return items;
    }
}
