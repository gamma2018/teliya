package com.example.sad.tpharma.metier.asynck;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.sad.tpharma.metier.entite.User;
import com.example.sad.tpharma.metier.entite.Utilisateur;
import com.example.sad.tpharma.metier.traitement.Model;


public class AddUser extends AsyncTask<Void, Void, Boolean> {

    private Utilisateur user;
    private ProgressDialog pD;

    public AddUser(Utilisateur user, ProgressDialog pD) {
        this.user = user;
        this.pD = pD;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pD.setTitle("Traitement...");
        pD.setMessage("Veillez patienter");
        pD.show();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if (aBoolean) {
            pD.dismiss();

        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        new Model().addUser(user);
        return true;
    }
}
