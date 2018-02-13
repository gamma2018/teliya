package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.sad.tpharma.adapter.ClientGridAdapter;
import com.example.sad.tpharma.adapter.CustomAlertDialogBuilder;
import com.example.sad.tpharma.entite.HomeItem;
import com.example.sad.tpharma.metier.asynck.AddUser;
import com.example.sad.tpharma.metier.entite.User;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    ArrayList<User> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final GridView gridView = (GridView) findViewById(R.id.gridUser);
        user = new ArrayList<User>(new Model().getAllUser());
        ClientGridAdapter adapter = new ClientGridAdapter(this, R.layout.custum_grid_client, getData(user));
        gridView.setAdapter(adapter);
        registerForContextMenu(gridView);

        Button btnAddUser = (Button) findViewById(R.id.addUser);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(UserActivity.this);
                LayoutInflater inflater = LayoutInflater.from(UserActivity.this);
                View addUserLayout = inflater.inflate(R.layout.add_user_layout, null);

                final EditText edNom = (EditText) addUserLayout.findViewById(R.id.nom);
                final EditText edPrenom = (EditText) addUserLayout.findViewById(R.id.prenom);
                final EditText edUsername = (EditText) addUserLayout.findViewById(R.id.username);
                final EditText edPrivilege = (EditText) addUserLayout.findViewById(R.id.privilege);
                final ProgressDialog pD = new ProgressDialog(UserActivity.this, ProgressDialog.STYLE_SPINNER);

                alertDialog.setTitle("Ajout d'un utilisateur");
                alertDialog.setView(addUserLayout);

                alertDialog.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        User user = new User(edNom.getText().toString(), edPrenom.getText().toString(), edUsername.getText().toString(),edPrivilege.getText().toString());
                        new AddUser(user, pD).execute((Void) null);

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

        if (v.getId() == R.id.gridUser)
        {
            MenuInflater inflater = getMenuInflater();
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            String name = user.get(info.position).getFirstName();
            menu.setHeaderTitle(name);
            inflater.inflate(R.menu.menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        return super.onContextItemSelected(item);
    }
}
