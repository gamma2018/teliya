package com.example.sad.tpharma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sad.tpharma.adapter.ListeProduitListviewAdapter;
import com.example.sad.tpharma.entite.ListeProduitItem;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.entite.Produit;

import java.util.ArrayList;

public class ImprimerConsultationPrixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimer_consultation_prix);

        TextView txtDate = (TextView) findViewById(R.id.date);
        TextView txtMontant = (TextView) findViewById(R.id.montant);
        ListView lvProduit = (ListView) findViewById(R.id.listeProduit);
        int montant =0;

        txtDate.setText("12/04/2018");

        ListeProduitListviewAdapter adapter = new ListeProduitListviewAdapter(ImprimerConsultationPrixActivity.this, R.layout.custum_liste_produit_impression, getData(Partager.getListeProuits()));
        lvProduit.setAdapter(adapter);
        //Calcul du prix Total
        for (int i=0; i<adapter.getCount(); i++)
        {
            montant += adapter.getItem(i).getPrixUnitaireProduit();
        }

        txtMontant.setText(String.valueOf(montant)+" GNF");
    }

    private ArrayList<ListeProduitItem> getData(ArrayList<Produit> listeProuits)
    {
        ArrayList<ListeProduitItem> listeProduitItems = new ArrayList<ListeProduitItem>();
        ListeProduitItem item;
        for (int i =0; i<listeProuits.size(); i++)
        {
            item = new ListeProduitItem();
            item.setLibelleProduit(listeProuits.get(i).getLibelleProduit());
            item.setPrixUnitaireProduit(listeProuits.get(i).getPu());
            listeProduitItems.add(item);
        }
        return listeProduitItems;
    }
}
