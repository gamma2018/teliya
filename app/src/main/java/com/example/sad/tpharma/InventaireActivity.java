package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;

import com.example.sad.tpharma.adapter.CustomAlertDialogBuilder;
import com.example.sad.tpharma.adapter.InventaireGridAdapter;
import com.example.sad.tpharma.adapter.OnItemSelected;
import com.example.sad.tpharma.entite.HistoriqueItem;
import com.example.sad.tpharma.entite.InventaireItem;
import com.example.sad.tpharma.metier.asynck.AddFamille;
import com.example.sad.tpharma.metier.asynck.AddProduit;
import com.example.sad.tpharma.metier.entite.FamilleProduit;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.traitement.Model;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

public class InventaireActivity extends AppCompatActivity {

    private Button ajoutProduit;
    SwipeRefreshLayout refresh;
    private Button ajoutFamille;
    private  EditText editFamilleProduit;
    private String typeProduit ="", formeProduit="";
    EditText edCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventaire);
        refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        edCode = (EditText) findViewById(R.id.codeProduit);

         final GridView gridView = (GridView) findViewById(R.id.gridInventaire);
        final InventaireGridAdapter adapter = new InventaireGridAdapter(InventaireActivity.this, R.layout.custum_grid_inventaire, getData(new Model().getAllProduit()));
        gridView.setAdapter(adapter);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                gridView.setAdapter(new InventaireGridAdapter(InventaireActivity.this, R.layout.custum_grid_inventaire, getData(new Model().getAllProduit())));
                refresh.setRefreshing(false);
            }
        });

        edCode.addTextChangedListener(new TextWatcher() {
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

        ajoutProduit = (Button) findViewById(R.id.ajoutProduit);
        ajoutProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(InventaireActivity.this);
                LayoutInflater inflater = LayoutInflater.from(InventaireActivity.this);
                View addProduitLayout = inflater.inflate(R.layout.add_inventaire_layout, null);

                final EditText edNomProduit = (EditText) addProduitLayout.findViewById(R.id.editLibelleProduit);
                final MaterialBetterSpinner edType = (MaterialBetterSpinner) addProduitLayout.findViewById(R.id.spTypeProduit);
                final MaterialBetterSpinner edForme = (MaterialBetterSpinner) addProduitLayout.findViewById(R.id.spFormeProduit);
                final EditText edCodeProduit = (EditText) addProduitLayout.findViewById(R.id.editCodeProduit);
                final EditText edSeuilProduit = (EditText) addProduitLayout.findViewById(R.id.editSeuilProduit);
                //final DatePicker edPeremption = (DatePicker) addProduitLayout.findViewById(R.id.datePeremption);

                //Chargement des spinner
                ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(InventaireActivity.this, android.R.layout.simple_list_item_1, new Model().getAllTypeProduits());
                edType.setAdapter(typeAdapter);

                ArrayAdapter<String> formeAdapter = new ArrayAdapter<String>(InventaireActivity.this, android.R.layout.simple_list_item_1, new Model().getAllFormeProduits());
                edForme.setAdapter(formeAdapter);

                //Recuperation des spinner
                edType.addTextChangedListener(new OnItemSelected() {
                    @Override
                    protected void onItemSelected(String type) {
                        typeProduit = type;
                    }
                });

                edForme.addTextChangedListener(new OnItemSelected() {
                    @Override
                    protected void onItemSelected(String forme) {
                        formeProduit = forme;
                    }
                });

                final ProgressDialog pD = new ProgressDialog(InventaireActivity.this, ProgressDialog.STYLE_SPINNER);

                alertDialog.setTitle("Ajout d'un grossiste");
                alertDialog.setView(addProduitLayout);

                alertDialog.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                       Produit produit = new Produit(
                               edNomProduit.getText().toString(),
                               typeProduit,
                               formeProduit,
                               edCodeProduit.getText().toString(),
                               Integer.parseInt(edSeuilProduit.getText().toString())
                       );
                        new AddProduit(produit, pD, InventaireActivity.this).execute((Void) null);

                        gridView.setAdapter(new InventaireGridAdapter(InventaireActivity.this, R.layout.custum_grid_inventaire, getData(new Model().getAllProduit())));
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

                        gridView.setAdapter(new InventaireGridAdapter(InventaireActivity.this, R.layout.custum_grid_inventaire, getData(new Model().getAllProduit())));
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

    private ArrayList<InventaireItem> getData(ArrayList<Produit> produits)
    {
        ArrayList<InventaireItem> items = new ArrayList<InventaireItem>();

        InventaireItem item;

        for (int i =0; i<produits.size();i++)
        {
            item = new InventaireItem();
            item.setLibelle(produits.get(i).getLibelleProduit());
            item.setCodeProd(produits.get(i).getCode());
            item.setMontant(produits.get(i).getPu());
            item.setDate(produits.get(i).getDate());
            items.add(item);
        }

        return items;
    }


}
