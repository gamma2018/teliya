package com.example.sad.tpharma.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.entite.ListeProduitItem;

import java.util.List;

/**
 * Created by SADGC on 5/30/2016.
 */
public class ListProduitCommande extends ArrayAdapter<ListeProduitItem> {

    Context context;
    int resLayout;
    List<ListeProduitItem> listeItems;
    public ListProduitCommande(Context context, int resource, List<ListeProduitItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resLayout = resource;
        this.listeItems = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, resLayout, null);

        TextView tvTitle = (TextView) v.findViewById(R.id.title);
        TextView tvSubTitle = (TextView) v.findViewById(R.id.subtitle);

        tvTitle.setText(listeItems.get(position).getLibelleProduit());
        tvSubTitle.setText("Prix unitaire: "+listeItems.get(position).getPrixUnitaireProduit()+" GNF, Qtite: "+listeItems.get(position).getQuantite() );
        return v;
    }

    @Override
    public ListeProduitItem getItem(int position) {
        return listeItems.get(position);
    }
}
