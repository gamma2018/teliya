package com.example.sad.tpharma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sad.tpharma.metier.Partager;

public class MainActivity extends AppCompatActivity {


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        CardView crdVente = (CardView) findViewById(R.id.vente);
        CardView crdHistoriqueVente = (CardView) findViewById(R.id.historiquevente);
        CardView crdCommande = (CardView) findViewById(R.id.commande);
        CardView crdFacture = (CardView) findViewById(R.id.facture);
        CardView crdIventaire = (CardView) findViewById(R.id.inventaire);
        CardView crdRapport = (CardView) findViewById(R.id.rapport);
        CardView crdRetourProduit = (CardView) findViewById(R.id.retourProduit);
        CardView crdNoteFrais = (CardView) findViewById(R.id.noteFrais);
        CardView crdClient = (CardView) findViewById(R.id.client);
        CardView crdFournisseur = (CardView) findViewById(R.id.fournisseur);
        CardView mutulle = (CardView) findViewById(R.id.mutuelles);
        CardView crdReimpression = (CardView) findViewById(R.id.reimpression);
        CardView crdUtilisateur = (CardView) findViewById(R.id.utilisateur);
        CardView crdLog = (CardView) findViewById(R.id.log);
        CardView crdNotification = (CardView) findViewById(R.id.notification);

        crdVente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VenteActivity.class);
                startActivity(intent);
            }
        });

        crdHistoriqueVente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Historique.class);
                startActivity(intent);
            }
        });

        crdCommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CommandeActivity.class);
                startActivity(intent);
            }
        });

        crdFacture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FactureActivity.class);
                startActivity(intent);
            }
        });

        crdFacture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FactureActivity.class);
                startActivity(intent);
            }
        });

        crdIventaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InventaireActivity.class);
                startActivity(intent);
            }
        });

        crdRetourProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RetourProduitActivity.class);
                startActivity(intent);
            }
        });

        crdNoteFrais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoteFraisActivity.class);
                startActivity(intent);
            }
        });

        crdClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClientActivity.class);
                startActivity(intent);
            }
        });

        crdFournisseur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GrossisteActivity.class);
                startActivity(intent);
            }
        });

        crdReimpression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReimpressionTicketActivity.class);
                startActivity(intent);
            }
        });

        crdUtilisateur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

        mutulle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MutuelleActivity.class);
                startActivity(intent);
            }
        });

        crdLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsultationPrixActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menu.add(Partager.getUsername()).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menuInflater.inflate(R.menu.main_menu_items, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId())
        {
            case R.id.itemDeconnecter:

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(this, "Deconnexion", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemChangePassword:

                Intent intent1 = new Intent(MainActivity.this, ChangePasswordActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(this, "Change pass", Toast.LENGTH_SHORT).show();
                break;
                default:
                    return true;
        }
        return true;
    }
}
