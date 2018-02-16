package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.asynck.ChangePassword;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        final EditText edOldPassword = (EditText) findViewById(R.id.oldPassword);
        final EditText edNewPassword = (EditText) findViewById(R.id.newPassword);
        final EditText edConfirmPassword = (EditText) findViewById(R.id.confirmPassword);
        Button btnUpdatePass = (Button) findViewById(R.id.updatePassword);
        final ProgressDialog pD = new ProgressDialog(ChangePasswordActivity.this, ProgressDialog.STYLE_SPINNER);

        btnUpdatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(edOldPassword.getText().toString().length() == 0 || edNewPassword.getText().toString().length() == 0))
                {
                    if (edOldPassword.getText().toString().equals(Partager.getPassword()))
                    {
                        if (edNewPassword.getText().toString().equals(edConfirmPassword.getText().toString()))
                        {
                            new ChangePassword(Partager.getUsername(), edOldPassword.getText().toString(), edNewPassword.getText().toString(), pD, ChangePasswordActivity.this).execute((Void) null);
                        }
                        else
                            Toast.makeText(ChangePasswordActivity.this, "Les deux mots de passe ne sont pas identique", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(ChangePasswordActivity.this, "L'ancien mot de passe ne correspond pas", Toast.LENGTH_SHORT).show();

                }
                Toast.makeText(ChangePasswordActivity.this, "Veillez remplir les champs !", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
