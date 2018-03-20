package com.example.sad.tpharma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.entite.FactureGrossisteItem;

import java.util.ArrayList;


public class FactureFournisseurGridAdapter extends BaseAdapter{

    Context c;
    int layout;
    ArrayList<FactureGrossisteItem> items;

    public FactureFournisseurGridAdapter(Context c, int layout, ArrayList<FactureGrossisteItem> items) {
        this.c = c;
        this.layout = layout;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridV;

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridV = new View(c);
            gridV = inflater.inflate(layout, null);

            final FactureGrossisteItem item = (FactureGrossisteItem) getItem(position);
            TextView lvNumeroFacture = (TextView) gridV.findViewById(R.id.numeroFacture);
            TextView montant = (TextView) gridV.findViewById(R.id.montant);
            TextView lvGrossiste = (TextView) gridV.findViewById(R.id.grossiste);
            TextView date = (TextView) gridV.findViewById(R.id.date);

            //Chargement
            lvNumeroFacture.setText(item.getNumeroFacture());
            montant.setText(String.valueOf(item.getMontant())+" GNF");
            lvGrossiste.setText(item.getGrossiste());
            date.setText(item.getDateFacture());

            gridV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c, item.getGrossiste(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            gridV = (View) convertView;
        }

        return gridV;
    }
    }
