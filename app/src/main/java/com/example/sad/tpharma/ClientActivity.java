package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.sad.tpharma.adapter.ClientGridAdapter;
import com.example.sad.tpharma.adapter.CustomAlertDialogBuilder;
import com.example.sad.tpharma.adapter.OnItemSelected;
import com.example.sad.tpharma.entite.HomeItem;
import com.example.sad.tpharma.metier.asynck.AddClient;
import com.example.sad.tpharma.metier.entite.Client;
import com.example.sad.tpharma.metier.traitement.Model;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

public class ClientActivity extends AppCompatActivity {

    private EditText edNom, edPrenom, edTelephone;
    MaterialBetterSpinner edNomMutuelle;
    private String mutuelle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        GridView gridView = (GridView) findViewById(R.id.gridClient);
        EditText edRecherche = (EditText) findViewById(R.id.rechercheClient);
        final ClientGridAdapter adapter = new ClientGridAdapter(this, R.layout.custum_grid_client, getData(new Model().getAllClient()));
        gridView.setAdapter(adapter);

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

        final Button addClient = (Button) findViewById(R.id.creerClient);

        addClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(ClientActivity.this);
                LayoutInflater inflater = LayoutInflater.from(ClientActivity.this);
                View addClientLayout = inflater.inflate(R.layout.add_client_layout, null);

                edNom = (EditText) addClientLayout.findViewById(R.id.nomClientAjout);
                edNom.addTextChangedListener(new ClientActivity.MyTextWatcher(edNom));

                edPrenom = (EditText) addClientLayout.findViewById(R.id.prenomClientAjout);
                edNom.addTextChangedListener(new ClientActivity.MyTextWatcher(edPrenom));

                edNomMutuelle = (MaterialBetterSpinner) addClientLayout.findViewById(R.id.nomMutuelleClient);
                //Chargement mutuelle
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(ClientActivity.this, android.R.layout.simple_list_item_1, new Model().getAllMutuelle());
                edNomMutuelle.setAdapter(stringArrayAdapter);

                edNomMutuelle.addTextChangedListener(new OnItemSelected() {
                    @Override
                    protected void onItemSelected(String m) {
                        mutuelle = m;
                    }
                });

                edTelephone = (EditText) addClientLayout.findViewById(R.id.telClientAjout);
                edTelephone.addTextChangedListener(new ClientActivity.MyTextWatcher(edTelephone));

                final ProgressDialog pD = new ProgressDialog(ClientActivity.this, ProgressDialog.STYLE_SPINNER);

                alertDialog.setTitle("Ajout d'un client");
                alertDialog.setView(addClientLayout);
                alertDialog.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (statutChamps())
                        {
                            erreurLabel();
                            return;
                        }
                        Client grossiste = new Client(mutuelle, edNom.getText().toString(), edPrenom.getText().toString(), edTelephone.getText().toString());
                        new AddClient(grossiste, pD, ClientActivity.this).execute((Void) null);

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
    private ArrayList<HomeItem> getData(ArrayList<Client> pList)
    {
        ArrayList<HomeItem> items = new ArrayList<HomeItem>();


        HomeItem item;
        for (int i=0; i < pList.size(); i++){
            item =  new HomeItem();
            item.setIdclient(pList.get(i).getIdClient());
            item.setNomClient(pList.get(i).getNomClient());
            item.setPrenomClient(pList.get(i).getPrenomClient());
            item.setImage(R.drawable.user);
            item.setTelephoneClient(pList.get(i).getTelClient());
            item.setNomClientMutuelle(pList.get(i).getNomMutuelle());
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
        return edNom.length() == 0 || edTelephone.length() == 0 || edPrenom.length() == 0 || mutuelle.length()==0;
    }

    private boolean valideNom()
    {
        if (edNom.getText().toString().trim().isEmpty())
        {
            edNom.setError("Veillez entrer le nom du client.");
            edNom.requestFocus();
            return false;
        }
        else {edNom.setError(null);}
        return true;
    }

    public void erreurLabel() {
        if (edNom.length() == 0) {
            edNom.setError("Veuillez entrer le nom");
            edNom.requestFocus();
        }

        if (edPrenom.length() == 0) {
            edPrenom.setError("Veuillez entrer le prenom");
            edPrenom.requestFocus();
        }

        if (edTelephone.length() == 0) {
            edTelephone.setError("Veuillez entrer le numero de telephone");
            edTelephone.requestFocus();
        }
        if (mutuelle.length() == 0) {
            edNomMutuelle.setError("Veuillez entrer le nom du mutuelle.");
            edNomMutuelle.requestFocus();
        }
    }
}
