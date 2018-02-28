package com.example.sad.tpharma.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.entite.ListeProduitItem;

import java.util.List;

public class ListeProduitListviewAdapter extends ArrayAdapter<ListeProduitItem> {

    Context c;
    int resLayout;
    List<ListeProduitItem> produitItems;
    public ListeProduitListviewAdapter(@NonNull Context context, int resource, @NonNull List<ListeProduitItem> objects) {
        super(context, resource, objects);
        this.c = context;
        this.resLayout = resource;
        this.produitItems = objects;
    }


    @Override
    public int getCount() {
        return produitItems.size();
    }

    @Nullable
    @Override
    public ListeProduitItem getItem(int position) {
        return produitItems.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = View.inflate(c, resLayout, null);

        TextView txtLibelle = (TextView) v.findViewById(R.id.libelle);
        TextView txtMontant = (TextView) v.findViewById(R.id.montant);

        txtLibelle.setText(produitItems.get(position).getLibelleProduit());
        txtMontant.setText(String.valueOf(produitItems.get(position).getPrixUnitaireProduit()));

        return v;
    }
}
