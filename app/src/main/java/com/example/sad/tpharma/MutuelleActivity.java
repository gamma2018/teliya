package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.sad.tpharma.adapter.CustomAlertDialogBuilder;
import com.example.sad.tpharma.adapter.MutuelleGridAdapter;
import com.example.sad.tpharma.entite.HomeItem;
import com.example.sad.tpharma.metier.asynck.AddMutuelle;
import com.example.sad.tpharma.metier.entite.Mutuelle;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;

public class MutuelleActivity extends AppCompatActivity {

    private EditText NomMutuelle, AdresseMutuelle, TelephoneMutuelle, EmailMutuelle, edRecherche;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutuelle);

        GridView gridView = (GridView) findViewById(R.id.gridMutuelle);
        EditText edRecherche = (EditText) findViewById(R.id.rechercheClient);
        final MutuelleGridAdapter adapter = new MutuelleGridAdapter(this, R.layout.custum_grid_mutuelle, getData(new Model().getAllMutuelles()));
        gridView.setAdapter(adapter);

        edRecherche = (EditText) findViewById(R.id.rechercheMutuelle);
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

        Button addMutuelle = (Button) findViewById(R.id.creerMutuelle);
        addMutuelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(MutuelleActivity.this);
                LayoutInflater inflater = LayoutInflater.from(MutuelleActivity.this);
                View addMutuelleLayout = inflater.inflate(R.layout.add_mutuelle_layout, null);

                NomMutuelle = (EditText) addMutuelleLayout.findViewById(R.id.nomMutuelle);
                NomMutuelle.addTextChangedListener(new MutuelleActivity.MyTextWatcher(NomMutuelle));

                TelephoneMutuelle = (EditText) addMutuelleLayout.findViewById(R.id.telephoneMutuelle);
                TelephoneMutuelle.addTextChangedListener(new MutuelleActivity.MyTextWatcher(TelephoneMutuelle));

                AdresseMutuelle = (EditText) addMutuelleLayout.findViewById(R.id.adresseMutuelle);
                AdresseMutuelle.addTextChangedListener(new MutuelleActivity.MyTextWatcher(AdresseMutuelle));

                EmailMutuelle = (EditText) addMutuelleLayout.findViewById(R.id.emailMutuelle);
                EmailMutuelle.addTextChangedListener(new MutuelleActivity.MyTextWatcher(EmailMutuelle));

                final ProgressDialog pD = new ProgressDialog(MutuelleActivity.this, ProgressDialog.STYLE_SPINNER);

                alertDialog.setTitle("Ajout d'un mutuelle");
                alertDialog.setView(addMutuelleLayout);
                alertDialog.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (statutChamps())
                        {
                            erreurLabel();
                            return;
                        }

                        Mutuelle mutuelleAdd = new Mutuelle(NomMutuelle.getText().toString(), TelephoneMutuelle.getText().toString(), AdresseMutuelle.getText().toString(), EmailMutuelle.getText().toString());
                        new AddMutuelle(mutuelleAdd, pD, MutuelleActivity.this).execute((Void) null);
                        dialog.dismiss();

                      /*  gridView.setAdapter(new FournisseurGridAdapter(GrossisteActivity.this, R.layout.custum_grid_fournisseur, getData(new Model().getAllGrossiste())));
                        Toast.makeText(GrossisteActivity.this, "Le grossiste a été avec succès.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();*/
                    }
                });
                alertDialog.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();
            }
        });

    }


    private ArrayList<HomeItem> getData(ArrayList<Mutuelle> pList)
    {
        ArrayList<HomeItem> items = new ArrayList<HomeItem>();

        HomeItem item;
        for (int i=0; i < pList.size(); i++){
            item =  new HomeItem();
            item.setNomMutuelle(pList.get(i).getNomMutuelle());
            item.setTelephoneMutuelle(pList.get(i).getPhoneMutuelle());
            item.setImage(R.drawable.bank_building);
            item.setEmailMutuelle(pList.get(i).getEmailMutuelle());
            item.setAdresseMutuelle(pList.get(i).getAdresseMutuelle());
            items.add(item);
        }

        return items;
    }

    private class MyTextWatcher implements TextWatcher
    {

        private View view;

        public MyTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

         /*   switch (view.getId())
            {
                case R.id.nomGrossiste:
                    valideNom();
                    break;
                case R.id.telephoneGrossiste:
                    valideTelephone();
                    break;
                case R.id.adresseGrossiste:
                    valideAdresse();
                    break;
            }*/
        }
    }

    public Boolean  statutChamps() {
        return NomMutuelle.length() == 0 || TelephoneMutuelle.length()==0 || EmailMutuelle.length()==0 || AdresseMutuelle.length()==0 ;
    }

    public void erreurLabel() {
        if (NomMutuelle.length() == 0) {
            NomMutuelle.setError("Veuillez entrer le nom du mutuelle.");
            NomMutuelle.requestFocus();
        }

        if (TelephoneMutuelle.length() == 0) {
            TelephoneMutuelle.setError("Veuillez entrer le n° Telephone du mutuelle.");
            TelephoneMutuelle.requestFocus();
        }

        if (AdresseMutuelle.length() == 0) {
            AdresseMutuelle.setError("Veuillez entrer l'adresse du mutuelle.");
            AdresseMutuelle.requestFocus();
        }

        if (EmailMutuelle.length() == 0) {
            EmailMutuelle.setError("Veuillez entrer l'adresse email du mutuelle.");
            EmailMutuelle.requestFocus();
        }
    }
}
