package com.btssio.applicationrftg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AfficherDetailDvdActivity extends AppCompatActivity {

    public static final String FILM = "com.btssio.applicationrftg.FILM";
    public static final String INVENTORY = "com.btssio.applicationrftg.INVENTORY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficherdetaildvd);

        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        TextView infoTextView = findViewById(R.id.infoTextView);
        TextView erreur = findViewById(R.id.erreur);
        // Récupérez les données du film de l'Intent
        Intent intent = getIntent();
        Films film = null;
        if(intent.hasExtra(FILM)){
            film = (Films) intent.getSerializableExtra(FILM);

            titleTextView.setText(film.getTitle());
            descriptionTextView.setText(film.getDescription());

            String infos = "Année de sortie: " + film.getRelease_year() +
                    "\nPrix de location: " + film.getRental_rate() +
                    "\nDurée de location: " + film.getRental_duration() + " jours";

            infoTextView.setText(infos);
        }

        Button addpanier = findViewById(R.id.addpanier);

        Inventory inventory = null;
        if(intent.hasExtra(INVENTORY)) {
            inventory = (Inventory) intent.getSerializableExtra(INVENTORY);
        }
        // Définition de l'action du bouton
        Films finalFilm = film;
        Inventory finalInventory = inventory;
        addpanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action à effectuer lorsque le bouton est cliqué
                if(finalFilm == null){
                    addpanier.setClickable(false);
                    erreur.setText("Le film n'existe pas");
                } else if (finalInventory == null){
                    addpanier.setClickable(false);
                    erreur.setText("Le film n'est pas disponible");
                } else {
                    // Création de l'Intent pour démarrer AfficherListeDvdsActivity
                    StockPanier.ajouterAuPanier(finalFilm, finalInventory);
                    Intent intent = new Intent(AfficherDetailDvdActivity.this, AfficherListeDvdsActivity.class);

                    // Démarrage de l'activité AfficherListeDvdsActivity
                    startActivity(intent);
                }
            }
        });
    }

}
