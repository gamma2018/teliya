package com.example.sad.tpharma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.sad.tpharma.adapter.ConsultationPrixGridAdapter;
import com.example.sad.tpharma.entite.ConsultationItem;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;

public class ConsultationPrixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation_prix);

        Button btn = (Button) findViewById(R.id.consulterBtn);
        GridView gridView = (GridView) findViewById(R.id.gridConsultation);
        ConsultationPrixGridAdapter adapter = new ConsultationPrixGridAdapter(ConsultationPrixActivity.this, R.layout.custum_grid_consultation_prix, getData(new Model().getAllProduit()));
        gridView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsultationPrixActivity.this, ImprimerConsultationPrixActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private ArrayList<ConsultationItem> getData(ArrayList<Produit> produits)
    {
        ArrayList<ConsultationItem> items = new ArrayList<ConsultationItem>();

        ConsultationItem item;

        for (int i =0; i<produits.size();i++)
        {
            item = new ConsultationItem();
            item.setLibelleProduit(produits.get(i).getLibelleProduit());
            item.setMontant(produits.get(i).getPu());
            item.setDateProduit(produits.get(i).getDate());
            items.add(item);
        }

        return items;
    }
}
