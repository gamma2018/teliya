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
import com.example.sad.tpharma.entite.CommandeItem;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.entite.Produit;

import java.util.ArrayList;

public class NewCommandeGridAdapter extends BaseAdapter implements Filterable{

    Context c;
    int layout;
    ArrayList<CommandeItem> items;
    ArrayList<Produit> produitsSelectionne = new ArrayList<Produit>();

    ArrayList<CommandeItem> filterList;
    CommandeCustomFilter filter;

    public NewCommandeGridAdapter(Context c, int layout, ArrayList<CommandeItem> items) {
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

            TextView libelleProduit = (TextView) convertView.findViewById(R.id.produitLib);
            TextView montant = (TextView) convertView.findViewById(R.id.montant);
            final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkProduit);
            TextView date = (TextView) convertView.findViewById(R.id.date);

            //Chargement
            libelleProduit.setText(items.get(position).getLibelleProduit());
            montant.setText(String.valueOf(items.get(position).getMontant())+" GNF");
            date.setText(items.get(position).getDateProduit());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!checkBox.isChecked())
                    {
                        checkBox.setChecked(false);
                        for (int i = 0; i< produitsSelectionne.size(); i++)
                        {
                            if (produitsSelectionne.get(i).getLibelleProduit().equals(items.get(position).getLibelleProduit()))
                            {
                                produitsSelectionne.remove(i);
                            }
                        }
                        Partager.setListeProuits(produitsSelectionne);
                    }
                    else {
                        checkBox.setChecked(true);
                        produitsSelectionne.add(new Produit(items.get(position).getLibelleProduit(), items.get(position).getMontant(), items.get(position).getDateProduit()));
                        Partager.setListeProuits(produitsSelectionne);
                    }
                }
            });


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(c, "Click grid", Toast.LENGTH_SHORT).show();

                }
            });


        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
        {
            filter = new CommandeCustomFilter();
        }
        return filter;
    }

    private class CommandeCustomFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0)
            {
                constraint = constraint.toString().toUpperCase();
                ArrayList<CommandeItem> filters = new ArrayList<CommandeItem>();
                for (int i=0; i<filterList.size(); i++)
                {
                    if (filterList.get(i).getLibelleProduit().toUpperCase().contains(constraint))
                    {
                        CommandeItem inventaireItem = new CommandeItem(
                                filterList.get(i).getMontant(),
                                filterList.get(i).getLibelleProduit(),
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

            items = (ArrayList<CommandeItem>) results.values;
            notifyDataSetChanged();
        }
    }
}
