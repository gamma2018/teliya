package com.example.sad.tpharma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.entite.HistoriqueItem;
import com.example.sad.tpharma.entite.HomeItem;

import java.util.ArrayList;


public class HistoriqueGridAdapter extends BaseAdapter{

    Context c;
    int layout;
    ArrayList<HistoriqueItem> items;

    public HistoriqueGridAdapter(Context c, int layout, ArrayList<HistoriqueItem> items) {
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

            final HistoriqueItem item = (HistoriqueItem) getItem(position);
            TextView libelleProduit = (TextView) gridV.findViewById(R.id.produitLib);
            TextView montant = (TextView) gridV.findViewById(R.id.montant);
            TextView codeProd = (TextView) gridV.findViewById(R.id.codeProd);
            TextView date = (TextView) gridV.findViewById(R.id.date);

            //Chargement
            libelleProduit.setText(item.getLibelle());
            montant.setText(String.valueOf(item.getMontant())+" GNF");
            codeProd.setText(item.getCodeProd());
            date.setText(item.getDate());

            gridV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c, "sadou", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            gridV = (View) convertView;
        }

        return gridV;
    }
    }
