package com.btssio.applicationrftg;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AfficherPanierActivity extends AppCompatActivity {

    static HashMap<Films, Integer> panier;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficherpanier);

        StockPanier stockPanier = StockPanier.getInstance();
        panier = stockPanier.getPanier();
        TextView titleTextView = findViewById(R.id.textView);
        if(panier.isEmpty()){
            titleTextView.setText(">>>>>>Le panier est vide");
        } else {
            String films = "";
            int size = panier.size();
            int count = 1;
            for(Map.Entry<Films, Integer> entry : panier.entrySet()) {
                Films film = entry.getKey();
                if (count == size) {
                    films = films + film.getTitle();
                } else {
                    films = films + film.getTitle() + ", ";
                }
                count++;
            }
            titleTextView.setText(films);
        }

        Button validepanier = findViewById(R.id.validepanier);
        TextView erreur = findViewById(R.id.erreur);

        // Définition de l'action du bouton
        validepanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action à effectuer lorsque le bouton est cliqué
                if(panier.isEmpty()){
                    erreur.setText("Le panier est vide");
                } else{
                    validerLePanier(panier);
                    StockPanier stockPanier = StockPanier.getInstance();
                    stockPanier.viderLePanier();
                    // Création de l'Intent pour démarrer AfficherListeDvdsActivity
                    Intent intent = new Intent(AfficherPanierActivity.this, AfficherListeDvdsActivity.class);

                    // Démarrage de l'activité AfficherListeDvdsActivity
                    startActivity(intent);
                }
            }
        });
    }

    // Méthode pour valider le panier
    public void validerLePanier(HashMap<Films, Integer> panierAValider) {
        for (Map.Entry<Films, Integer> entry : panierAValider.entrySet()) {
            try {
                // Utiliser l'inventaire trouvé pour construire l'URL
                URL urlAAppeler = new URL("http://10.0.2.2:8080/rental/save?inventory_id=" + entry.getValue() + "&customer_id=" + ConnexionActivity.getCustomer().getCustomer_id() + "&staff_id=" + 1 + "&state=À Traiter");
                new AppelerServiceRestPOSTTask(this).execute(urlAAppeler, null, null);
            } catch (MalformedURLException mue) {
                Log.d("mydebug", ">>>Pour AppelerServiceRestPOSTTask - MalformedURLException mue=" + mue.toString());
            }
        }
    }
}
