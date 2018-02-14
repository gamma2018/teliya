package com.example.sad.tpharma;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        final ProgressDialog pD = new ProgressDialog(ChangePasswordActivity.this, ProgressDialog.STYLE_HORIZONTAL);

        btnUpdatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    new ChangePassword(Partager.getUsername(), edOldPassword.getText().toString(), edNewPassword.getText().toString(), pD, ChangePasswordActivity.this).execute((Void) null);

            }
        });
    }
}
