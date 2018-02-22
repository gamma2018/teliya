package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;

import com.example.sad.tpharma.adapter.CustomAlertDialogBuilder;
import com.example.sad.tpharma.adapter.HistoriqueGridAdapter;
import com.example.sad.tpharma.entite.HistoriqueItem;
import com.example.sad.tpharma.metier.asynck.AddFamille;
import com.example.sad.tpharma.metier.asynck.AddProduit;
import com.example.sad.tpharma.metier.entite.FamilleProduit;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;

public class InventaireActivity extends AppCompatActivity {

    private Button ajoutProduit;
    SwipeRefreshLayout refresh;
    private Button ajoutFamille;
    private  EditText editFamilleProduit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventaire);
        refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);

         final GridView gridView = (GridView) findViewById(R.id.gridInventaire);
        HistoriqueGridAdapter adapter = new HistoriqueGridAdapter(InventaireActivity.this, R.layout.custum_grid_inventaire, getData(new Model().getAllProduit()));
        gridView.setAdapter(adapter);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                gridView.setAdapter(new HistoriqueGridAdapter(InventaireActivity.this, R.layout.custum_grid_inventaire, getData(new Model().getAllProduit())));
                refresh.setRefreshing(false);
            }
        });

        ajoutProduit = (Button) findViewById(R.id.ajoutProduit);
        ajoutProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(InventaireActivity.this);
                LayoutInflater inflater = LayoutInflater.from(InventaireActivity.this);
                View addProduitLayout = inflater.inflate(R.layout.add_inventaire_layout, null);

                final EditText edNom = (EditText) addProduitLayout.findViewById(R.id.nomProduit);
                final EditText edType = (EditText) addProduitLayout.findViewById(R.id.typeProduit);
                final EditText edPrixUnitaire = (EditText) addProduitLayout.findViewById(R.id.prixUnitaireProduit);
                final EditText edQuantite = (EditText) addProduitLayout.findViewById(R.id.quantiteInitialProduit);
                final EditText edCodeProduit = (EditText) addProduitLayout.findViewById(R.id.codeProduit);
                final DatePicker edPeremption = (DatePicker) addProduitLayout.findViewById(R.id.datePeremption);

                final ProgressDialog pD = new ProgressDialog(InventaireActivity.this, ProgressDialog.STYLE_SPINNER);

                alertDialog.setTitle("Ajout d'un grossiste");
                alertDialog.setView(addProduitLayout);

                alertDialog.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       /* Produit produit = new Produit(
                                edNom.getText().toString(),
                                Integer.parseInt(edPrixUnitaire.getText().toString()),
                                Integer.parseInt(edQuantite.getText().toString()),
                                String.valueOf(edPeremption.getYear())+"-"+String.valueOf(edPeremption.getMonth()+1)+"-"+String.valueOf(edPeremption.getDayOfMonth()),
                                edType.getText().toString(),
                                edCodeProduit.getText().toString()
                        );*/
                       Produit produit = new Produit(edType.getText().toString(), edNom.getText().toString(),"Forme", edCodeProduit.getText().toString(), String.valueOf(edPeremption.getYear())+"-"+String.valueOf(edPeremption.getMonth()+1)+"-"+String.valueOf(edPeremption.getDayOfMonth()), Integer.parseInt(edQuantite.getText().toString()), Integer.parseInt(edPrixUnitaire.getText().toString()));
                        new AddProduit(produit, pD, InventaireActivity.this).execute((Void) null);

                        gridView.setAdapter(new HistoriqueGridAdapter(InventaireActivity.this, R.layout.custum_grid_inventaire, getData(new Model().getAllProduit())));
                        dialog.dismiss();

                    }
                });

                alertDialog.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                alertDialog.setCanceledOnTouchOutside(false);

                alertDialog.show();
            }
        });


        editFamilleProduit = (EditText) findViewById(R.id.familleProduit);
        ajoutFamille = (Button) findViewById(R.id.ajoutFamilleProduit);
        //Ajout d'une famille de produit.
        ajoutFamille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            final CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(InventaireActivity.this);
                LayoutInflater inflater = LayoutInflater.from(InventaireActivity.this);
                View addFamilleLayout = inflater.inflate(R.layout.add_famille_layout, null);

                final EditText nom = (EditText) addFamilleLayout.findViewById(R.id.familleProduit);

                final ProgressDialog pD = new ProgressDialog(InventaireActivity.this, ProgressDialog.STYLE_SPINNER);

                alertDialog.setTitle("Ajout d'une fammille de produit.");
                alertDialog.setView(addFamilleLayout);

                alertDialog.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                      FamilleProduit familleProduit = new FamilleProduit(nom.getText().toString());
                        new AddFamille(familleProduit, pD, InventaireActivity.this).execute((Void) null);

                        gridView.setAdapter(new HistoriqueGridAdapter(InventaireActivity.this, R.layout.custum_grid_inventaire, getData(new Model().getAllProduit())));
                        dialog.dismiss();

                    }
                });

                alertDialog.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                alertDialog.setCanceledOnTouchOutside(false);

                alertDialog.show();
            }
        });


    }

    private ArrayList<HistoriqueItem> getData(ArrayList<Produit> produits)
    {
        ArrayList<HistoriqueItem> items = new ArrayList<HistoriqueItem>();

        HistoriqueItem item;

        for (int i =0; i<produits.size();i++)
        {
            item = new HistoriqueItem();
            item.setLibelle(produits.get(i).getDesignation());
            item.setCodeProd(produits.get(i).getCode());
            item.setMontant(produits.get(i).getPu());
            item.setDate(produits.get(i).getDatePremption());
            items.add(item);
        }

        return items;
    }


}
