package com.btssio.applicationrftg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;

public class ConnexionActivity extends AppCompatActivity {

    private static Customer customer = null;
    public static final String CUSTOMER = "com.btssio.applicationrftg.CUSTOMER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        // Récupération de la référence du bouton
        Button monBouton = findViewById(R.id.button);

        // Définition de l'action du bouton
        monBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.email);
                EditText password = findViewById(R.id.password);
                verificationConnexion(email.getText().toString(),password.getText().toString());
            }
        });

        Button listeDvds = findViewById(R.id.listeDvds);

        listeDvds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnexionActivity.this, AfficherListeDvdsActivity.class);
                // Démarrage de l'activité AfficherListeDvdsActivity
                startActivity(intent);
            }
        });
    }

    public void verificationConnexion(String email, String password){
        try {
            // Utiliser l'inventaire trouvé pour construire l'URL
            URL urlAAppeler = new URL("http://10.0.2.2:8080/customer/login?email="+email+"&password="+password);
            new AppelerServiceRestGETTaskConnexion(this).execute(urlAAppeler, null, null);
        } catch (MalformedURLException mue) {
            Log.d("mydebug", ">>>Pour AppelerServiceRestPOSTTask - MalformedURLException mue=" + mue.toString());
        }
    }

    public void connexionValide(String resultat){
        if(resultat != ""){
            System.out.println(">>>>>>>>>>login "+resultat);
            Customer customerConnected = convertitCustomerEnObjet(resultat);
            setCustomer(customerConnected);
            TextView erreur = findViewById(R.id.erreur);
            erreur.setText("Bonjour, "+customerConnected.getFirst_name());
            Button listeDvds = findViewById(R.id.listeDvds);
            listeDvds.setEnabled(true);
        } else{
            TextView erreur = findViewById(R.id.erreur);
            erreur.setText("Email ou mot de passe incorrect");
        }
    }

    public Customer convertitCustomerEnObjet(String customerJson) {
        Gson gson = new Gson();

        Customer customer = gson.fromJson(customerJson, Customer.class);

        return customer;
    }

    public static Customer getCustomer(){
        return customer;
    }

    public static void setCustomer(Customer customerInstance) {
        customer = customerInstance;
    }
}
