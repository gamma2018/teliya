package com.example.sad.tpharma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.entite.HistoriqueCommandeItem;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.entite.Produit;

import java.util.ArrayList;

public class HistoriqueCommandeGridAdapter extends BaseAdapter implements Filterable{

    Context c;
    int layout;
    ArrayList<HistoriqueCommandeItem> items;
    ArrayList<Produit> produitsSelectionne = new ArrayList<Produit>();

    ArrayList<HistoriqueCommandeItem> filterList;
    HistoriqueCommandeCustomFilter filter;

    public HistoriqueCommandeGridAdapter(Context c, int layout, ArrayList<HistoriqueCommandeItem> items) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
        }

            TextView statutCommande = (TextView) convertView.findViewById(R.id.idStatut);
            TextView montant = (TextView) convertView.findViewById(R.id.montantTotal);
            TextView date = (TextView) convertView.findViewById(R.id.date);
            TextView nombreProduit = (TextView) convertView.findViewById(R.id.nbrProduits);

            //Chargement
            statutCommande.setText(items.get(position).getStatutCommande());
            montant.setText(String.valueOf(items.get(position).getMontant())+" GNF");
            date.setText(items.get(position).getDateProduit());
            nombreProduit.setText(String.valueOf(items.get(position).getNombreProd()));

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
        {
            filter = new HistoriqueCommandeCustomFilter();
        }
        return filter;
    }

    private class HistoriqueCommandeCustomFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0)
            {
                constraint = constraint.toString().toUpperCase();
                ArrayList<HistoriqueCommandeItem> filters = new ArrayList<HistoriqueCommandeItem>();
                for (int i=0; i<filterList.size(); i++)
                {
                    if (filterList.get(i).getStatutCommande().toUpperCase().contains(constraint))
                    {
                        HistoriqueCommandeItem inventaireItem = new HistoriqueCommandeItem(
                                filterList.get(i).getMontant(),
                                filterList.get(i).getNombreProd(),
                                filterList.get(i).getStatutCommande(),
                                filterList.get(i).getDateProduit()
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

            items = (ArrayList<HistoriqueCommandeItem>) results.values;
            notifyDataSetChanged();
        }
    }
}
