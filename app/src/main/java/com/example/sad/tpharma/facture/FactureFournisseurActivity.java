package com.example.sad.tpharma.facture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.adapter.FactureFournisseurGridAdapter;
import com.example.sad.tpharma.entite.FactureGrossisteItem;
import com.example.sad.tpharma.metier.entite.FactureGrossiste;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;

public class FactureFournisseurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facture_fournisseur);

        GridView gridView = (GridView) findViewById(R.id.gridFactFournisseur);
        FactureFournisseurGridAdapter adapter = new FactureFournisseurGridAdapter(this, R.layout.custum_grid_facture_fournisseur, getData(new Model().getFactureGrossiste()));
        gridView.setAdapter(adapter);
    }

    private ArrayList<FactureGrossisteItem> getData(ArrayList<FactureGrossiste> factureGrossistes)
    {
        ArrayList<FactureGrossisteItem> items = new ArrayList<FactureGrossisteItem>();

        FactureGrossisteItem item;

        for (int i=0; i<factureGrossistes.size(); i++)
        {
            item = new FactureGrossisteItem();
            item.setNumeroFacture(factureGrossistes.get(i).getNumeroFactureGrossiste());
            item.setDateFacture(factureGrossistes.get(i).getDateFactureGrossiste());
            item.setMontant(factureGrossistes.get(i).getMontantFactureGrossiste());
            item.setGrossiste(factureGrossistes.get(i).getGrossiste());
            items.add(item);
        }
        return items;
    }
}
