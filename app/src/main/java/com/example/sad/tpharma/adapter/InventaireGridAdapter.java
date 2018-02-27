package com.example.sad.tpharma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.entite.InventaireItem;

import java.util.ArrayList;


public class InventaireGridAdapter extends BaseAdapter implements Filterable{

    Context c;
    int layout;
    ArrayList<InventaireItem> items;

    ArrayList<InventaireItem> filterList;
    InventaireCustomFilter filter;

    public InventaireGridAdapter(Context c, int layout, ArrayList<InventaireItem> items) {
        this.c = c;
        this.layout = layout;
        this.items = items;
        this.filterList = items;
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
            convertView = inflater.inflate(layout, null);
        }

            TextView libelleProduit = (TextView) convertView.findViewById(R.id.produitLib);
            TextView montant = (TextView) convertView.findViewById(R.id.montant);
            TextView codeProd = (TextView) convertView.findViewById(R.id.codeProd);
            TextView date = (TextView) convertView.findViewById(R.id.date);

            //Chargement
            libelleProduit.setText(items.get(position).getLibelle());
            montant.setText(String.valueOf(items.get(position).getMontant())+" GNF");
            codeProd.setText(items.get(position).getCodeProd());
            date.setText(items.get(position).getDate());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c, "sadou", Toast.LENGTH_SHORT).show();
                }
            });


        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
        {
            filter = new InventaireCustomFilter();
        }
        return filter;
    }

    private class InventaireCustomFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0)
            {
                constraint = constraint.toString().toUpperCase();
                ArrayList<InventaireItem> filters = new ArrayList<InventaireItem>();
                for (int i=0; i<filterList.size(); i++)
                {
                    if (filterList.get(i).getLibelle().toUpperCase().contains(constraint))
                    {
                        InventaireItem inventaireItem = new InventaireItem(
                                filterList.get(i).getLibelle(),
                                filterList.get(i).getCodeProd(),
                                filterList.get(i).getDate(),
                                filterList.get(i).getMontant()
                        );
                        filters.add(inventaireItem);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }
             else
                {
                    results.count = filterList.size();
                    results.values = filterList;
                }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            items = (ArrayList<InventaireItem>) results.values;
            notifyDataSetChanged();
        }
    }
}
