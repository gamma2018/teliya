package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sad.tpharma.metier.asynck.Login;
import com.example.sad.tpharma.metier.traitement.Model;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edUsername = (EditText) findViewById(R.id.username);
        final EditText edPassword = (EditText) findViewById(R.id.password);
        Button btnConnexion = (Button) findViewById(R.id.connexion);
        final ProgressDialog pD = new ProgressDialog(this, ProgressDialog.STYLE_SPINNER);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Login(edUsername.getText().toString(), edPassword.getText().toString(), pD, LoginActivity.this).execute((Void) null);
            }
        });
    }
}
