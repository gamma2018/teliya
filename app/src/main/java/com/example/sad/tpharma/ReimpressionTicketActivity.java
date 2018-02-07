package com.example.sad.tpharma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.sad.tpharma.adapter.ReimpressionGridAdapter;
import com.example.sad.tpharma.entite.HistoriqueItem;

import java.util.ArrayList;

public class ReimpressionTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reimpression_ticket);

        GridView gridView = (GridView) findViewById(R.id.gridReimpression);
        ReimpressionGridAdapter adapter = new ReimpressionGridAdapter(this, R.layout.custum_grid_reimpression, getData());
        gridView.setAdapter(adapter);
    }

    private ArrayList<HistoriqueItem> getData()
    {
        ArrayList<HistoriqueItem> items = new ArrayList<HistoriqueItem>();

        HistoriqueItem item = new HistoriqueItem();

        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();

        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();

        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();

        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();

        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();

        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();

        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();

        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        item = new HistoriqueItem();

        item.setCodeProd("#P001");
        item.setMontant(50000);
        items.add(item);

        item = new HistoriqueItem();

        item.setCodeProd("#P001");
        item.setMontant(50000);
        item.setDate("12/02/2018");
        items.add(item);

        return items;
    }
}
