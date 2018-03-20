package com.example.sad.tpharma.commande;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.VenteActivity;
import com.example.sad.tpharma.adapter.ReceptionCommandeGridAdapter;
import com.example.sad.tpharma.entite.HistoriqueCommandeItem;
import com.example.sad.tpharma.entite.ReceptionCommandeItem;
import com.example.sad.tpharma.metier.entite.Commande;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;

public class ReceptionCommandeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique_reception_commande);

        Button btn = (Button) findViewById(R.id.creer_commande);
        EditText edRecherche = (EditText) findViewById(R.id.edRecherche);
        GridView gridView = (GridView) findViewById(R.id.gridHistoriqueCommande);
        final ReceptionCommandeGridAdapter adapter = new ReceptionCommandeGridAdapter(ReceptionCommandeActivity.this, R.layout.custom_grid_reception_commande, getData(new Model().getAllCommandeAReceptionne()));
        gridView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReceptionCommandeActivity.this, VenteActivity.class);
                startActivity(intent);
                finish();
            }
        });

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
    }

    private ArrayList<ReceptionCommandeItem> getData(ArrayList<Commande> commandes)
    {
        ArrayList<ReceptionCommandeItem> items = new ArrayList<ReceptionCommandeItem>();

        ReceptionCommandeItem item;

        for (int i =0; i<commandes.size();i++)
        {
            item = new ReceptionCommandeItem();
            item.setIdCommande(commandes.get(i).getIdCommande());
            item.setDateProduit(commandes.get(i).getDateCommande());
            item.setMontant(commandes.get(i).getMontantCommande());
            item.setStatutCommande(commandes.get(i).getStatutCommande());
            item.setNombreProd(commandes.get(i).getNombreProduits());
            items.add(item);
        }

        return items;
    }
}
