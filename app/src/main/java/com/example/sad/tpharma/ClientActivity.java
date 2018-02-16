package com.example.sad.tpharma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.GridView;

import com.example.sad.tpharma.adapter.ClientGridAdapter;
import com.example.sad.tpharma.entite.HomeItem;

import java.util.ArrayList;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        GridView gridView = (GridView) findViewById(R.id.gridClient);
        ClientGridAdapter adapter = new ClientGridAdapter(this, R.layout.custum_grid_client, getData());
        gridView.setAdapter(adapter);

    }

    private ArrayList<HomeItem> getData()
    {
        ArrayList<HomeItem> items = new ArrayList<HomeItem>();

        HomeItem item = new HomeItem();

        item.setImage(R.drawable.client);
        item.setLibelle("Barry");
        item.setDescription("Sadou");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Barry");
        item.setDescription("Sadou");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Barry");
        item.setDescription("Sadou");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Barry");
        item.setDescription("Sadou");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Barry");
        item.setDescription("Sadou");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Barry");
        item.setDescription("Sadou");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Barry");
        item.setDescription("Sadou");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Barry");
        item.setDescription("Sadou");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Barry");
        item.setDescription("Sadou");
        items.add(item);

        item.setImage(R.drawable.client);
        item.setLibelle("Barry");
        item.setDescription("Sadou");
        items.add(item);

        return items;
    }
}
