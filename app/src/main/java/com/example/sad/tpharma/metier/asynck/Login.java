package com.example.sad.tpharma.metier.asynck;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;


import com.example.sad.tpharma.MainActivity;
import com.example.sad.tpharma.metier.traitement.Model;


public class Login extends AsyncTask<Void, Void, Boolean> {

    private String username;
    private String password;
    private ProgressDialog pD;
    private Context c;

    public Login(String username, String password, ProgressDialog pD, Context c) {
        this.username = username;
        this.password = password;
        this.pD = pD;
        this.c = c;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        return  new Model().login(username, password) > 0;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pD.setTitle("Connexion...");
        pD.setMessage("Veillez patienter");
        pD.show();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        if (aBoolean)
        {
            pD.dismiss();
            Intent intent = new Intent(c, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.getApplicationContext().startActivity(intent);
            Toast.makeText(c, "Nous vous souhaitons une meilleur utilisation !!!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            pD.dismiss();
            Toast.makeText(c, "Connexion Echouée", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
