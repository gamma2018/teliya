package com.example.sad.tpharma.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.entite.InventaireItem;

import java.util.List;

/**
 * Created by SADGC on 5/30/2016.
 */
public class ListAdapterIventaire extends ArrayAdapter<InventaireItem> {

    Context context;
    int resLayout;
    List<InventaireItem> listeItems;
    public ListAdapterIventaire(Context context, int resource, List<InventaireItem> objects) {
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

        InventaireItem Item = listeItems.get(position);
        tvTitle.setText(Item.getTitle());
        tvSubTitle.setText(Item.getSubTitle());

        return v;
    }

    @Override
    public InventaireItem getItem(int position) {
        return super.getItem(position);
    }
}
