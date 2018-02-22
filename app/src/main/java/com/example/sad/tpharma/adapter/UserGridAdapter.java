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

import com.example.sad.tpharma.R;
import com.example.sad.tpharma.entite.HomeItem;
import com.example.sad.tpharma.metier.asynck.UpdateUser;
import com.example.sad.tpharma.metier.entite.User;
import com.example.sad.tpharma.metier.traitement.Model;

import java.util.ArrayList;


public class UserGridAdapter extends BaseAdapter implements Filterable{

    Context c;
    int layout;
    ArrayList<HomeItem> items;

    ArrayList<HomeItem> filterList;
    UserCustomFilter filter;

    TextView nom;
    TextView prenom;
    TextView userName;
    EditText edNom;
    EditText edPrenom;
    EditText edUserName;
    User user;
    ProgressDialog pD;


    public UserGridAdapter(Context c, int layout, ArrayList<HomeItem> items) {
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
        if (convertView == null)
        {
            convertView = inflater.inflate(layout, null);
        }

        ImageView imageV = (ImageView) convertView.findViewById(R.id.photoClient);
        TextView libelleV = (TextView) convertView.findViewById(R.id.nomClient);
        TextView nameV = (TextView) convertView.findViewById(R.id.prenomClient);

        imageV.setImageResource(items.get(position).getImage());
        libelleV.setText(items.get(position).getLibelle());
        nameV.setText(items.get(position).getDescription());

        //popup

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CustomAlertDialogBuilder alertDialog = new CustomAlertDialogBuilder(c);
                LayoutInflater inflater = LayoutInflater.from(c);
                View addUserLayout = inflater.inflate(R.layout.infos_user_layout, null);

                nom = (TextView)  addUserLayout.findViewById(R.id.valeurNomUtilisateur);
                prenom = (TextView)  addUserLayout.findViewById(R.id.valeurPrenomUtilisateur);
                userName = (TextView)  addUserLayout.findViewById(R.id.valeurUserName);

                alertDialog.setTitle(items.get(position).getLibelle());
                alertDialog.setView(addUserLayout);

                user = new User();
                user = new Model().getUserByUsername(items.get(position).getUsername());

                nom.setText(user.getFirstName());
                prenom.setText(user.getLastName());
                userName.setText(user.getUsername());

                alertDialog.setPositiveButton("Editer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        final CustomAlertDialogBuilder dlg = new CustomAlertDialogBuilder(c);
                        LayoutInflater inflater = LayoutInflater.from(c);
                        View updateUserLayout = inflater.inflate(R.layout.edit_infos_user_layout, null);

                        edNom = (EditText)  updateUserLayout.findViewById(R.id.editValeurNomUtilisateur);
                        edPrenom = (EditText)  updateUserLayout.findViewById(R.id.editValeurPrenomUtilisateur);
                        edUserName = (EditText)  updateUserLayout.findViewById(R.id.editValeurUserName);
                        pD = new ProgressDialog(c, ProgressDialog.STYLE_SPINNER);

                        edNom.setText(user.getFirstName());
                        edPrenom.setText(user.getLastName());
                        edUserName.setText(user.getUsername());

                        dlg.setTitle(items.get(position).getLibelle());
                        dlg.setView(updateUserLayout);
                        dlg.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                new UpdateUser(user.getUsername(),
                                        new User(edNom.getText().toString(),edPrenom.getText().toString(), edUserName.getText().toString()),
                                        pD
                                ).execute((Void) null);
                            }
                        });
                        dlg.setNegativeButton("Annuler", null);
                        dlg.setCanceledOnTouchOutside(false);
                        dlg.show();

                    }
                });

                alertDialog.setNeutralButton("Retour", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.setNegativeButton("Reinit...", null);

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
            filter = new UserCustomFilter();
        }
        return filter;
    }

    private class UserCustomFilter extends Filter
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
                        HomeItem item = new HomeItem(filterList.get(i).getImage(), filterList.get(i).getLibelle(),filterList.get(i).getDescription(), filterList.get(i).getUsername());
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
