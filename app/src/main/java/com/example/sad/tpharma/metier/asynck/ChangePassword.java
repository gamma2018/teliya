package com.example.sad.tpharma.metier.asynck;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.sad.tpharma.LoginActivity;
import com.example.sad.tpharma.metier.traitement.Model;


public class ChangePassword extends AsyncTask<Void, Void, Boolean> {

    private String username;
    private String oldPassword;
    private String newPassword;
    private ProgressDialog pD;
    private Context c;

    public ChangePassword(String username, String oldPassword, String newPassword, ProgressDialog pD, Context c) {
        this.username = username;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.pD = pD;
        this.c = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pD.setTitle("Traitement");
        pD.setMessage("Veillez patienter");
        pD.show();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if (aBoolean) {
            pD.dismiss();
            Intent intent = new Intent(c, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.getApplicationContext().startActivity(intent);
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        new Model().changeUserPassword(username, oldPassword, newPassword);
        return true;
    }
}
