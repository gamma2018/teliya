package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sad.tpharma.adapter.ClientGridAdapter;
import com.example.sad.tpharma.adapter.CustomAlertDialogBuilder;
import com.example.sad.tpharma.entite.HomeItem;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.asynck.AddUser;
import com.example.sad.tpharma.metier.entite.User;
import com.example.sad.tpharma.metier.entite.Utilisateur;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    ArrayList<User> user;
    EditText edNom, edPrenom, edUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final GridView gridView = (GridView) findViewById(R.id.gridUser);
        registerForContextMenu(gridView);
        user = new ArrayList<User>(new Model().getAllUser());
        ClientGridAdapter adapter = new ClientGridAdapter(this, R.layout.custum_grid_client, getData(user));
        gridView.setAdapter(adapter);

        Button btnAddUser = (Button) findViewById(R.id.addUser);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(UserActivity.this);
                LayoutInflater inflater = LayoutInflater.from(UserActivity.this);
                View addUserLayout = inflater.inflate(R.layout.add_user_layout, null);

                 edNom = (EditText) addUserLayout.findViewById(R.id.nom);
                 edNom.addTextChangedListener(new MyTextWatcher(edNom));

                 edPrenom = (EditText) addUserLayout.findViewById(R.id.prenom);
                 edPrenom.addTextChangedListener(new MyTextWatcher(edPrenom));

                 edUsername = (EditText) addUserLayout.findViewById(R.id.username);
                 edUsername.addTextChangedListener(new MyTextWatcher(edUsername));

                /* edPrivilege = (EditText) addUserLayout.findViewById(R.id.privilege);
                 edPrivilege.addTextChangedListener(new MyTextWatcher(edPrivilege));*/

                final ProgressDialog pD = new ProgressDialog(UserActivity.this, ProgressDialog.STYLE_SPINNER);

                alertDialog.setTitle("Ajout d'un utilisateur");
                alertDialog.setView(addUserLayout);

                alertDialog.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (statutChamps())
                        {
                            erreurLabel();
                            return;
                        }

                        Utilisateur user = new Utilisateur(edNom.getText().toString(), edPrenom.getText().toString(), edUsername.getText().toString(),"");
                        new AddUser(user, pD).execute((Void) null);
                        gridView.setAdapter(new ClientGridAdapter(UserActivity.this, R.layout.custum_grid_client, getData(new Model().getAllUser())));
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

    private ArrayList<HomeItem> getData(ArrayList<User> user)
    {
        ArrayList<HomeItem> items = new ArrayList<HomeItem>();

        HomeItem item;

        for (int i = 0; i<user.size();i++)
        {
            item = new HomeItem();
            item.setImage(R.drawable.client);
            item.setLibelle(user.get(i).getFirstName());
            item.setDescription(user.get(i).getLastName());
            items.add(item);
        }


        return items;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context Menu");
        AdapterView.AdapterContextMenuInfo cmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.add(1, cmi.position, 0, "Action 1");
        menu.add(2, cmi.position, 0, "Action 2");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        GridView g = (GridView) findViewById(R.id.gridUser);
        String s = (String) g.getItemAtPosition(item.getItemId());
        switch (item.getGroupId()) {
            case 1:
                Toast.makeText(this, "Action 1, Item "+s, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Action 2, Item "+s, Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private boolean valideNom()
    {
        if (edNom.getText().toString().trim().isEmpty())
        {
            edNom.setError("Veillez entrer le nom");
            edNom.requestFocus();
            return false;
        }
        else {edNom.setError(null);}
        return true;
    }
    private boolean validePrenom()
    {
        if (edPrenom.getText().toString().trim().isEmpty())
        {
            edPrenom.setError("Veillez entrer le prenom");
            edPrenom.requestFocus();
            return false;
        }
        else {edPrenom.setError(null);}
        return true;
    }
    private boolean valideUsername()
    {
        if (edUsername.getText().toString().trim().isEmpty())
        {
            edUsername.setError("Veillez entrer un nom d'utilisateur");
            edUsername.requestFocus();
            return false;
        }
        else {edUsername.setError(null);}
        return true;
    }
   /* private boolean validePrivilege()
    {
        if (edPrivilege.getText().toString().trim().isEmpty())
        {
            edPrivilege.setError("Veillez entrer un privilege");
            edPrivilege.requestFocus();
            return false;
        }
        else {edPrivilege.setError(null);}
        return true;
    }*/
    public Boolean  statutChamps() {
        return edNom.length() == 0 || edPrenom.length() == 0 || edUsername.length() == 0;
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
                case R.id.nom:
                    valideNom();
                    break;
                case R.id.prenom:
                    validePrenom();
                    break;
                case R.id.username:
                    valideUsername();
                    break;
            }
        }
    }
    public void erreurLabel()
    {
        if (edNom.length() == 0) {
            edNom.setError("Veuillez entrer le nom");
            edNom.requestFocus();
        }
        if (edPrenom.length() == 0) {
            edPrenom.setError("Veuillez entrer le prenom");
            edPrenom.requestFocus();
        }
        if (edUsername.length() == 0) {
            edUsername.setError("Veuillez entrer un nom d'utilisateur");
            edUsername.requestFocus();
        }
        /*if (edPrivilege.length() == 0) {
            edPrivilege.setError("Veuillez entrer un privilege");
            edPrivilege.requestFocus();
        }*/
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

                Intent intent = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(this, "Deconnexion", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemChangePassword:

                Intent intent1 = new Intent(UserActivity.this, ChangePasswordActivity.class);
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
