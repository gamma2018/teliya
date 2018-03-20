package com.example.sad.tpharma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.sad.tpharma.commande.HistoriqueCommandeActivity;
import com.example.sad.tpharma.commande.ReceptionCommandeActivity;

public class CommandeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commde);

        CardView newCommande = (CardView) findViewById(R.id.creer_commande);
        CardView historiqueCommande = (CardView) findViewById(R.id.historique_commande);
        CardView receptionCommande = (CardView) findViewById(R.id.receptionner);
        newCommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommandeActivity.this, CreeCommandeActivity.class );
                startActivity(intent);


            }
        });
        historiqueCommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommandeActivity.this, HistoriqueCommandeActivity.class );
                startActivity(intent);


            }
        });

        receptionCommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommandeActivity.this, ReceptionCommandeActivity.class );
                startActivity(intent);


            }
        });
    }
}
