package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sad.tpharma.adapter.CustomAlertDialogBuilder;
import com.example.sad.tpharma.adapter.FournisseurGridAdapter;
import com.example.sad.tpharma.entite.HomeItem;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.asynck.AddGrossiste;
import com.example.sad.tpharma.metier.entite.Grossiste;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;

public class GrossisteActivity extends AppCompatActivity {
    private Button addGrossiste;
    EditText edNom, edTelephone,edAddresse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grossiste);


        final  GridView gridView = (GridView) findViewById(R.id.gridFournisseur);
        FournisseurGridAdapter adapter = new FournisseurGridAdapter(this, R.layout.custum_grid_fournisseur, getData(new Model().getAllGrossiste()));
        gridView.setAdapter(adapter);


        addGrossiste = (Button) findViewById(R.id.ajoutGrossiste);
        addGrossiste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(GrossisteActivity.this);
                LayoutInflater inflater = LayoutInflater.from(GrossisteActivity.this);
                View addGrossisteLayout = inflater.inflate(R.layout.add_grossiste_layout, null);

                 edNom = (EditText) addGrossisteLayout.findViewById(R.id.nomGrossiste);
                 edNom.addTextChangedListener(new MyTextWatcher(edNom));

                 edTelephone = (EditText) addGrossisteLayout.findViewById(R.id.telephoneGrossiste);
                 edTelephone.addTextChangedListener(new MyTextWatcher(edTelephone));

                 edAddresse = (EditText) addGrossisteLayout.findViewById(R.id.adresseGrossiste);
                 edAddresse.addTextChangedListener(new MyTextWatcher(edAddresse));

                final ProgressDialog pD = new ProgressDialog(GrossisteActivity.this, ProgressDialog.STYLE_SPINNER);

                alertDialog.setTitle("Ajout d'un grossiste");
                alertDialog.setView(addGrossisteLayout);

                alertDialog.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (statutChamps())
                        {
                            erreurLabel();
                            return;
                        }
                        Grossiste grossiste = new Grossiste(edNom.getText().toString(), edTelephone.getText().toString(), edAddresse.getText().toString());
                        new AddGrossiste(grossiste, pD, GrossisteActivity.this).execute((Void) null);

                        gridView.setAdapter(new FournisseurGridAdapter(GrossisteActivity.this, R.layout.custum_grid_fournisseur, getData(new Model().getAllGrossiste())));
                        Toast.makeText(GrossisteActivity.this, "Le grossiste a été avec succès.", Toast.LENGTH_SHORT).show();
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

    private ArrayList<HomeItem> getData(ArrayList<Grossiste> pList)
    {
        ArrayList<HomeItem> items = new ArrayList<HomeItem>();


        HomeItem item;
        for (int i=0; i < pList.size(); i++){
            item =  new HomeItem();
            item.setImage(R.drawable.user);
            item.setLibelle(pList.get(i).getLibelle());
            item.setDescription(pList.get(i).getTelephone()+"\n"+pList.get(i).getAdresse());
            items.add(item);
        }

        return items;
    }

    private boolean valideNom()
    {
        if (edNom.getText().toString().trim().isEmpty())
        {
            edNom.setError("Veillez entrer le nom du grossiste");
            edNom.requestFocus();
            return false;
        }
        else {edNom.setError(null);}
        return true;
    }
    private boolean valideTelephone()
    {
        if (edTelephone.getText().toString().trim().isEmpty())
        {
            edTelephone.setError("Veillez entrer le numero de telephone");
            edTelephone.requestFocus();
            return false;
        }
        else {edTelephone.setError(null);}
        return true;
    }
    private boolean valideAdresse()
    {
        if (edAddresse.getText().toString().trim().isEmpty())
        {
            edAddresse.setError("Veillez entrer l'adresse");
            edAddresse.requestFocus();
            return false;
        }
        else {edAddresse.setError(null);}
        return true;
    }
    public void erreurLabel() {
        if (edNom.length() == 0) {
            edNom.setError("Veuillez entrer le nom");
            edNom.requestFocus();
        }
        if (edTelephone.length() == 0) {
            edTelephone.setError("Veuillez entrer le numero de telephone");
            edTelephone.requestFocus();
        }
        if (edAddresse.length() == 0) {
            edAddresse.setError("Veuillez entrer l'adresse");
            edAddresse.requestFocus();
        }
    }
    public Boolean  statutChamps() {
        return edNom.length() == 0 || edTelephone.length() == 0 || edAddresse.length() == 0;
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

            switch (view.getId())
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
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menu.add(Partager.getUsername()).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menuInflater.inflate(R.menu.main_menu_items, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId())
        {
            case R.id.itemDeconnecter:

                Intent intent = new Intent(GrossisteActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(this, "Deconnexion", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemChangePassword:

                Intent intent1 = new Intent(GrossisteActivity.this, ChangePasswordActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(this, "Change pass", Toast.LENGTH_SHORT).show();
                break;
            default:
                return true;
        }
        return true;
    }
}
