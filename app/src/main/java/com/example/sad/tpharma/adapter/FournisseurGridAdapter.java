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
import com.example.sad.tpharma.entite.HomeItem;

import java.util.ArrayList;


public class FournisseurGridAdapter extends BaseAdapter{

    Context c;
    int layout;
    ArrayList<HomeItem> items;

    public FournisseurGridAdapter(Context c, int layout, ArrayList<HomeItem> items) {
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

            final HomeItem item = (HomeItem) getItem(position);
            ImageView imageV = (ImageView) gridV.findViewById(R.id.photoFournisseur);
            TextView libelleV = (TextView) gridV.findViewById(R.id.nomFournisseur);
            TextView nameV = (TextView) gridV.findViewById(R.id.phoneFournisseur);

            //Chargement
            imageV.setImageResource(item.getImage());
            libelleV.setText(item.getLibelle());
            nameV.setText(item.getDescription());

            gridV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c, item.getLibelle(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            gridV = (View) convertView;
        }

        return gridV;
    }
    }
