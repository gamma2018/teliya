package com.example.sad.tpharma.commande;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.adapter.HistoriqueGridAdapter;
import com.example.sad.tpharma.entite.HistoriqueItem;

import java.util.ArrayList;

public class HistoriqueCommandeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique_commande);

        GridView gridView = (GridView) findViewById(R.id.gridHistoCmnd);
        HistoriqueGridAdapter adapter = new HistoriqueGridAdapter(this, R.layout.custum_grid_historique, getData());
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
