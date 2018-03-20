package com.example.sad.tpharma;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sad.tpharma.entite.ListeProduitItem;
import com.example.sad.tpharma.entite.VenteGridItem;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.traitement.Model;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.List;

public class VenteActivity extends AppCompatActivity {

    ListView lvProduitChoche;
    TextView txtMontant;
    ListviewAdapter adapterLv;
    MaterialBetterSpinner spClient;
    Button btnPaiement;
    ArrayList<ListeProduitItem> listeProdCoche = new ArrayList<ListeProduitItem>();
    int montant = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vente);

        txtMontant = (TextView) findViewById(R.id.montantTotal);
        lvProduitChoche = (ListView) findViewById(R.id.listeProduitCoche);
        spClient = (MaterialBetterSpinner) findViewById(R.id.nomClient);
        btnPaiement = (Button) findViewById(R.id.paiement);
        //initialisation de la list view
        adapterLv = new ListviewAdapter(VenteActivity.this, R.layout.custom_adding_quantite_vente, new ArrayList<ListeProduitItem>());

        EditText edRecherche = (EditText) findViewById(R.id.rechercheProduit);
        GridView gridVente = (GridView) findViewById(R.id.gridVente);
        final VenteGridAdapter adapter = new VenteGridAdapter(getData(new Model().getAllProduitAVendre()));

        gridVente.setAdapter(adapter);
        edRecherche.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Chargement client
        spClient.setAdapter(new ArrayAdapter<String>(VenteActivity.this, android.R.layout.simple_list_item_1, new Model().getAllClients()));

        btnPaiement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    private ArrayList<VenteGridItem> getData(ArrayList<Produit> produits)
    {
        ArrayList<VenteGridItem> items = new ArrayList<VenteGridItem>();

        VenteGridItem item;

        for (int i =0; i<produits.size();i++)
        {
            item = new VenteGridItem();
            item.setLibelleProduit(produits.get(i).getLibelleProduit());
            item.setMontant(produits.get(i).getPu());
            item.setQtProduit(produits.get(i).getQuantite());
            items.add(item);
        }

        return items;
    }
    private class VenteGridAdapter extends BaseAdapter implements Filterable
    {
        ArrayList<VenteGridItem> items;
        ArrayList<VenteGridItem> filterList;
        VenteProduitCustomFilter filter;

        public VenteGridAdapter(ArrayList<VenteGridItem> items) {
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

            LayoutInflater inflater = (LayoutInflater) VenteActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.custom_vente_grid_home, null);
            }

            TextView libelleProduit = (TextView) convertView.findViewById(R.id.produitLib);
            TextView montant = (TextView) convertView.findViewById(R.id.montant);
            final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkProduit);
            TextView quantite = (TextView) convertView.findViewById(R.id.quantiteProduit);

            //Chargement

            libelleProduit.setText(items.get(position).getLibelleProduit());
            montant.setText(String.valueOf(items.get(position).getMontant())+" GNF");
            quantite.setText(String.valueOf(items.get(position).getQtProduit()));


            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!checkBox.isChecked())
                    {
                        checkBox.setChecked(false);
                        for (int i = 0; i< listeProdCoche.size(); i++)
                        {
                            if (listeProdCoche.get(i).getLibelleProduit().equals(items.get(position).getLibelleProduit()))
                            {
                                listeProdCoche.remove(i);
                            }
                        }
                    }
                    else {
                        checkBox.setChecked(true);
                        List<Produit> listProduit=adapterLv.getProduits();
                        listeProdCoche.add(new ListeProduitItem(items.get(position).getLibelleProduit(), items.get(position).getMontant()));
                        //listProduit.add(new Produit(items.get(position).getLibelleProduit(), items.get(position).getMontant(), items.get(position).getQtProduit()));
                        //adapterLv.add(listProduit);
                       // adapterLv.add(new ListeProduitItem(items.get(position).getLibelleProduit(), items.get(position).getMontant()));
                    }



                    adapterLv = new ListviewAdapter(VenteActivity.this, R.layout.custom_adding_quantite_vente, listeProdCoche);
                    lvProduitChoche.setAdapter(adapterLv);
                }
            });

            return convertView;
        }

        @Override
        public Filter getFilter() {
            if (filter == null)
            {
                filter = new VenteProduitCustomFilter();
            }
            return filter;
        }

        private class VenteProduitCustomFilter extends Filter
        {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();
                if (constraint != null && constraint.length() > 0)
                {
                    constraint = constraint.toString().toUpperCase();
                    ArrayList<VenteGridItem> filters = new ArrayList<VenteGridItem>();
                    for (int i=0; i<filterList.size(); i++)
                    {
                        if (filterList.get(i).getLibelleProduit().toUpperCase().contains(constraint))
                        {
                            VenteGridItem venteGridItem = new VenteGridItem(
                                    filterList.get(i).getMontant(),
                                    filterList.get(i).getLibelleProduit(),
                                    filterList.get(i).getQtProduit()
                            );
                            filters.add(venteGridItem);
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

                items = (ArrayList<VenteGridItem>) results.values;
                notifyDataSetChanged();
            }
        }
    }
    private class ListviewAdapter extends ArrayAdapter<ListeProduitItem>
    {
        Context c;
        int resLayout;
        List<ListeProduitItem> produitItems;
        List<Produit> produitsList = new ArrayList<Produit>();

        public ListviewAdapter(@NonNull Context context, int resource, @NonNull List<ListeProduitItem> objects)
        {
            super(context, resource, objects);
            this.c = context;
            this.resLayout = resource;
            this.produitItems = objects;
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
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View v = View.inflate(c, resLayout, null);
            TextView tvLibelleProd = (TextView) v.findViewById(R.id.nomProduit);
            EditText edQuantite = (EditText) v.findViewById(R.id.quantiteProduit);

            final Produit produit = new Produit();
            tvLibelleProd.setText(produitItems.get(position).getLibelleProduit());
            edQuantite.setText(String.valueOf(produitItems.get(position).getQuantite()));
            produit.setLibelleProduit(produitItems.get(position).getLibelleProduit());
            edQuantite.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    if (!s.toString().equals(""))
                         montant -= Integer.parseInt(String.valueOf(s))*produitItems.get(position).getPrixUnitaireProduit();
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if (!s.toString().equals(""))
                    {
                        produit.setQuantite(Integer.parseInt(String.valueOf(s)));
                        montant += Integer.parseInt(String.valueOf(s))*produitItems.get(position).getPrixUnitaireProduit();
                    }
                    txtMontant.setText("Total :     "+String.valueOf(montant)+" GNF");
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            produitsList.add(produit);
            return v;
        }
        public List<Produit> getProduits()
        {
            return produitsList;
        }

        @Override
        public void add(@Nullable ListeProduitItem object) {
            super.add(object);
        }
    }
}
