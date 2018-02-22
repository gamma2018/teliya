package com.example.sad.tpharma.metier.asynck;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.sad.tpharma.metier.entite.Grossiste;
import com.example.sad.tpharma.metier.traitement.Model;


public class UpdateGrossiste extends AsyncTask<Void, Void, Boolean> {

    private int grossisteid;
    private Grossiste mGrossiste;
    private ProgressDialog pD;

    public UpdateGrossiste(int id, Grossiste grossiste, ProgressDialog pD) {
        this.grossisteid = id;
        this.mGrossiste = grossiste;
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

        new Model().updateGrossiste(grossisteid, mGrossiste);
        return true;
    }
}
