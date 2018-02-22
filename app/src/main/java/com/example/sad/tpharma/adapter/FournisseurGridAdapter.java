package com.example.sad.tpharma.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.adapter.CustomAlertDialogBuilder;
import com.example.sad.tpharma.entite.HomeItem;
import com.example.sad.tpharma.metier.asynck.UpdateGrossiste;
import com.example.sad.tpharma.metier.entite.Grossiste;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;


public class FournisseurGridAdapter extends BaseAdapter implements Filterable{

    Context c;
    int layout;
    ArrayList<HomeItem> items;

    ArrayList<HomeItem> filterList;
    GrossisteCustomFilter filter;

    Grossiste mGrossiste;
    ProgressDialog pD;

    public FournisseurGridAdapter(Context c, int layout, ArrayList<HomeItem> items) {
        this.c = c;
        this.layout = layout;
        this.items = items;
        this.filterList = items;
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
    public View getView(final int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = inflater.inflate(layout, null);
        }

            ImageView imageV = (ImageView) convertView.findViewById(R.id.photoFournisseur);
            TextView libelleV = (TextView) convertView.findViewById(R.id.nomFournisseur);
            TextView nameV = (TextView) convertView.findViewById(R.id.phoneFournisseur);

            //Chargement
            imageV.setImageResource(items.get(position).getImage());
            libelleV.setText(items.get(position).getLibelle());
            nameV.setText(items.get(position).getDescription());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(c);
                    LayoutInflater inflater = LayoutInflater.from(c);
                    View infosGrossisteLayout = inflater.inflate(R.layout.infos_grossiste_layout, null);

                    TextView nom = (TextView) infosGrossisteLayout.findViewById(R.id.valeurNomGrossiste);
                    TextView tel = (TextView) infosGrossisteLayout.findViewById(R.id.valeurTelephoneGrossiste);
                    TextView adresse = (TextView) infosGrossisteLayout.findViewById(R.id.valeurAdresseGrossiste);

                    //Chargement des infos du grossiste
                    mGrossiste = new Grossiste();
                    mGrossiste = new Model().getGrossisteById(items.get(position).getIdGrossiste());


                    nom.setText(mGrossiste.getLibelle());
                    tel.setText(mGrossiste.getTelephone());
                    adresse.setText(mGrossiste.getAdresse());

                    alertDialog.setTitle(items.get(position).getLibelle());
                    alertDialog.setView(infosGrossisteLayout);
                    alertDialog.setPositiveButton("Editer", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //Chargement d'un nouvelle boite de dialogue.
                            final CustomAlertDialogBuilder dlg = new CustomAlertDialogBuilder(c);
                            LayoutInflater inflater = LayoutInflater.from(c);
                            View updateGrossisteLayout = inflater.inflate(R.layout.edit_infos_grossiste_layout, null);

                            final EditText editNomGrossiste = (EditText) updateGrossisteLayout.findViewById(R.id.editValeurNomGrossiste);
                            final EditText  editAdresseGrossiste = (EditText) updateGrossisteLayout.findViewById(R.id.editValeurAddresseGrossiste);
                            final EditText  editTelephoneGrossiste = (EditText) updateGrossisteLayout.findViewById(R.id.editValeurTelephoneGrossiste);
                            pD = new ProgressDialog(c, ProgressDialog.STYLE_SPINNER);

                            editNomGrossiste.setText(mGrossiste.getLibelle());
                            editAdresseGrossiste.setText(mGrossiste.getAdresse());
                            editTelephoneGrossiste.setText(mGrossiste.getTelephone());

                            dlg.setTitle(items.get(position).getLibelle());
                            dlg.setView(updateGrossisteLayout);
                            dlg.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    new UpdateGrossiste(mGrossiste.getCode(),
                                            new Grossiste(
                                                    editNomGrossiste.getText().toString(),
                                                    editAdresseGrossiste.getText().toString()
                                                    ,editTelephoneGrossiste.getText().toString()
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
                    alertDialog.setNegativeButton("Re.init", null);
                    alertDialog.setCanceledOnTouchOutside(false);
                    alertDialog.show();
                }
            });

        return convertView;
    }

    @Override
    public Filter getFilter() {

        if (filter == null)
        {
            filter = new GrossisteCustomFilter();
        }
        return filter;
    }

    private class GrossisteCustomFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0)
            {
                constraint = constraint.toString().toUpperCase();
                ArrayList<HomeItem> filters = new ArrayList<HomeItem>();

                for (int i=0; i<filterList.size(); i++)
                {
                    if (filterList.get(i).getLibelle().toUpperCase().contains(constraint))
                    {
                        HomeItem item = new HomeItem(
                                filterList.get(i).getImage(),
                                filterList.get(i).getLibelle(),
                                filterList.get(i).getDescription(),
                                filterList.get(i).getUsername(),
                                filterList.get(i).getIdGrossiste());
                        filters.add(item);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }
            else
            {
                results.count = filterList.size();
                results.values = filterList;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            items = (ArrayList<HomeItem>) results.values;
            notifyDataSetChanged();
        }
    }
}
