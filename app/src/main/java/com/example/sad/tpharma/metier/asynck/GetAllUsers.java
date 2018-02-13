package com.example.sad.tpharma.metier.asynck;

import android.os.AsyncTask;

import com.example.sad.tpharma.metier.traitement.Model;


public class GetAllUsers extends AsyncTask<Void, Void, Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

       new Model().getAllUser();
        return null;
    }
}
