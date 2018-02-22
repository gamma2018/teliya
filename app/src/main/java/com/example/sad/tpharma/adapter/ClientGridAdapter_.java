package com.example.sad.tpharma.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.sad.tpharma.R;
import com.example.sad.tpharma.entite.HomeItem;
import com.example.sad.tpharma.metier.asynck.UpdateClient;
import com.example.sad.tpharma.metier.entite.Client;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;


public class ClientGridAdapter_ extends BaseAdapter{

    Context c;
    int layout;
    ArrayList<HomeItem> items;
    ProgressDialog pD;
    EditText editNomClient, editPrenomClient, editTelephoneClient, editNomMutuelle;
    Client client;

    public ClientGridAdapter_(Context c, int layout, ArrayList<HomeItem> items) {
        this.c = c;
        this.layout = layout;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridV;

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridV = new View(c);
            gridV = inflater.inflate(layout, null);

            final HomeItem item = (HomeItem) getItem(position);
            ImageView imageV = (ImageView) gridV.findViewById(R.id.photoClient);
            TextView libelleV = (TextView) gridV.findViewById(R.id.nomClient);
            TextView nameV = (TextView) gridV.findViewById(R.id.prenomClient);
            TextView mutuelle = (TextView) gridV.findViewById(R.id.mutuelle);

            //Chargement
            imageV.setImageResource(item.getImage());
            libelleV.setText(item.getNomClient());
            nameV.setText(item.getTelephoneClient());
            mutuelle.setText(item.getNomClientMutuelle());

            gridV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(c);
                    LayoutInflater inflater = LayoutInflater.from(c);
                    View infosGrossisteLayout = inflater.inflate(R.layout.infos_client_layout, null);

                    TextView nom = (TextView) infosGrossisteLayout.findViewById(R.id.valeurNomClient);
                    TextView prenom = (TextView) infosGrossisteLayout.findViewById(R.id.valeurPrenomClient);
                    TextView tel = (TextView) infosGrossisteLayout.findViewById(R.id.valeurTelephoneClient);
                    TextView mutuelle = (TextView) infosGrossisteLayout.findViewById(R.id.valeurMutuelleClient);

                    client = new Client();
                    client = new Model().getClientByID(item.getIdclient());

                    nom.setText(client.getNomClient());
                    prenom.setText(client.getPrenomClient());
                    tel.setText(client.getTelClient());
                    mutuelle.setText(client.getNomMutuelle());



                    alertDialog.setTitle(item.getLibelle());
                    alertDialog.setView(infosGrossisteLayout);
                    alertDialog.setPositiveButton("Editer", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Chargement d'un nouvelle boite de dialogue.
                            final CustomAlertDialogBuilder dlg = new CustomAlertDialogBuilder(c);
                            LayoutInflater inflater = LayoutInflater.from(c);
                            View updateClientLayout = inflater.inflate(R.layout.edit_infos_client_layout, null);

                            editNomClient = (EditText) updateClientLayout.findViewById(R.id.editValeurNomClient);
                            editPrenomClient = (EditText) updateClientLayout.findViewById(R.id.editValeurPrenomClient);
                            editTelephoneClient = (EditText) updateClientLayout.findViewById(R.id.editTelephoneClient);
                            editNomMutuelle = (EditText) updateClientLayout.findViewById(R.id.editMutuelleClient);

                            pD = new ProgressDialog(c, ProgressDialog.STYLE_SPINNER);

                            editNomClient.setText(client.getNomClient());
                            editPrenomClient.setText(client.getPrenomClient());
                            editTelephoneClient.setText(client.getTelClient());
                            editNomMutuelle.setText(client.getNomMutuelle());


                            dlg.setTitle(client.getNomClient());
                            dlg.setView(updateClientLayout);
                         dlg.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    new UpdateClient(client.getIdClient(),
                                            new Client(
                                                    editNomMutuelle.getText().toString(),
                                                    editNomClient.getText().toString()
                                                    ,editPrenomClient.getText().toString(),
                                                    editTelephoneClient.getText().toString()
                                            ),
                                            pD
                                    ).execute((Void) null);
                                    dialog.dismiss();
                                    Toast.makeText(c, "Les informations sont mise à jour avec succès.", Toast.LENGTH_SHORT).show();

                                }
                            });

                          dlg.setNegativeButton("Annuler", null);
                            dlg.setCanceledOnTouchOutside(false);
                            dlg.show();
                        }
                    });
                    alertDialog.setNeutralButton("Supprimer", null);
                    alertDialog.setCanceledOnTouchOutside(false);
                    alertDialog.show();
                }
            });

        } else {
            gridV = (View) convertView;
        }

        return gridV;
    }
}
