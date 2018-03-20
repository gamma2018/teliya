package com.example.sad.telpo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.sad.telpo.R;

import java.util.List;

/**
 * Created by SADGC on 5/30/2016.
 */
public class ListAdapter extends ArrayAdapter<ListeItem> {

    Context context;
    int resLayout;
    List<ListeItem> listeItems;
    public ListAdapter(Context context, int resource, List<ListeItem> objects) {
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

        ListeItem Item = listeItems.get(position);
        tvTitle.setText(Item.getTitle());
        tvSubTitle.setText(Item.getSubTitle());

        return v;
    }

    @Override
    public ListeItem getItem(int position) {
        return listeItems.get(position);
    }
}
