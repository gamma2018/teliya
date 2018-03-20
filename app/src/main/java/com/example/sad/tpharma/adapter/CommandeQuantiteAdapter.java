package com.example.sad.tpharma.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.entite.InventaireItem;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.entite.Produit;

import java.util.ArrayList;
import java.util.List;

public class CommandeQuantiteAdapter extends ArrayAdapter<InventaireItem>{

    Context context;
    int resLayout;
    List<InventaireItem> listeItems;
    List<Produit> produitsList = new ArrayList<Produit>();


    public CommandeQuantiteAdapter(@NonNull Context context, int resource, @NonNull List<InventaireItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resLayout = resource;
        this.listeItems = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // super.getView(position, convertView, parent);

         final View v = View.inflate(context, resLayout, null);
        TextView tvLibelleProd = (TextView) v.findViewById(R.id.nomProduit);
        EditText edPu = (EditText) v.findViewById(R.id.puProduit);
        final EditText edQuantite = (EditText) v.findViewById(R.id.quantiteProduit);

        final Produit produit = new Produit();

        tvLibelleProd.setText(listeItems.get(position).getLibelle());

        produit.setLibelleProduit(listeItems.get(position).getLibelle());


        edPu.addTextChangedListener(new TextChangedListener<EditText>(edPu) {
            @Override
            public void onTextChanged(EditText target, Editable s) {

                produit.setPu(Integer.parseInt(String.valueOf(s)));
               // pu = Integer.parseInt(String.valueOf(s));
            }
        });
        edQuantite.addTextChangedListener(new TextChangedListener<EditText>(edQuantite) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                produit.setQuantite(Integer.parseInt(String.valueOf(s)));
            }
        });

        produitsList.add(produit);

        return v;
    }

    @Nullable
    @Override
    public InventaireItem getItem(int position) {
        return super.getItem(position);
    }

    public List<Produit> getProduits()
    {
        return produitsList;
    }
}
