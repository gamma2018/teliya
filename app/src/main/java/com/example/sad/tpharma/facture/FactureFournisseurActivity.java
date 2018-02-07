package com.example.sad.tpharma.facture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.adapter.FactureFournisseurGridAdapter;
import com.example.sad.tpharma.entite.HistoriqueItem;

import java.util.ArrayList;

public class FactureFournisseurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facture_fournisseur);

        GridView gridView = (GridView) findViewById(R.id.gridFactFournisseur);
        FactureFournisseurGridAdapter adapter = new FactureFournisseurGridAdapter(this, R.layout.custum_grid_facture_fournisseur, getData());
        gridView.setAdapter(adapter);
    }

    private ArrayList<HistoriqueItem> getData()
    {
        ArrayList<HistoriqueItem> items = new ArrayList<HistoriqueItem>();

        HistoriqueItem item = new HistoriqueItem();

        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();
        item.setLibelle("Paracetmol");
        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);


        return items;
    }
}
