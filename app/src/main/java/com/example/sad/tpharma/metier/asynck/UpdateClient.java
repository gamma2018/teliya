package com.example.sad.tpharma.metier.asynck;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.sad.tpharma.metier.entite.Client;
import com.example.sad.tpharma.metier.traitement.Model;


public class UpdateClient extends AsyncTask<Void, Void, Boolean> {

    private int id;
    private Client mClient;
    private ProgressDialog pD;

    public UpdateClient(int id, Client client, ProgressDialog pD) {
        this.id = id;
        this.mClient = client;
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

        if (aBoolean)
        {
            pD.dismiss();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        new Model().updateClient(id, mClient);
        return true;
    }
}
