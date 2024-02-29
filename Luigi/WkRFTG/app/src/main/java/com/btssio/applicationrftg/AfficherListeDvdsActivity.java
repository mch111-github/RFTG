package com.btssio.applicationrftg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class AfficherListeDvdsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String listeFilmsResultat = "";
    private String inventoryFilmResultat = "";

    public static final String FILM = "com.btssio.applicationrftg.FILM";
    public static final String INVENTORY = "com.btssio.applicationrftg.INVENTORY";

    private Inventory inventory = null;
    private Films film = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficherlistedvds);

        StockPanier stockPanier = StockPanier.getInstance();
        ImageView panierButton = findViewById(R.id.panierButton);
        // Ajoutez un écouteur de clic à l'ImageView
        panierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action à effectuer lors du clic sur l'image du panier
                // Créez une Intent pour l'activité de destination
                Intent intent = new Intent(AfficherListeDvdsActivity.this, AfficherPanierActivity.class);

                // Lancez l'activité de destination
                startActivity(intent);
            }
        });


        URL urlAAppeler = null;
        try {
            urlAAppeler = new URL("http://10.0.2.2:8080/films");
            new AppelerServiceRestGETTask(this, true).execute(urlAAppeler, null, null);
        } catch (MalformedURLException mue) {
            Log.d("mydebug", ">>>Pour AppelerServiceRestGETTask - MalformedURLEx-ception mue=" + mue.toString());

        } finally {
            urlAAppeler = null;
            //A completer selon le contexte
        }
    }

    public ArrayList convertitListeFilmsEnArrayList(String filmsJson) {
        Gson gson = new Gson();

        Type filmsListType = new TypeToken<ArrayList<Films>>(){}.getType();
        ArrayList<Films> filmsArray = gson.fromJson(filmsJson, filmsListType);

        //Contrôle
        System.out.println(">>>>Les films >>>>>>>>>>>>>>>DEBUT");
        for(Films films : filmsArray) {
            System.out.println("FilmId="+films.getFilm_id()+" title="+films.getTitle()+"/description="+films.getDescription());
        }
        System.out.println(">>>>Les films >>>>>>>>>>>>>>>FIN");
        return filmsArray;
    }

    public void mettreAJourActivityApresAppelRest(String resultatAppelRest) {

        listeFilmsResultat = resultatAppelRest; //callback
        Log.d("mydebug",">>>Pour AppelServiceRestActivity - afficherResultatAppel-ServiceRest AppelServiceRest="+listeFilmsResultat);
        ArrayList<Films> arrayFilms = convertitListeFilmsEnArrayList(listeFilmsResultat);

        FilmsAdapter adapter = new FilmsAdapter(this, arrayFilms);

        ListView listView = findViewById(R.id.listeFilms);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    public void inventoryFilm(String resultatAppelRest) {
        inventoryFilmResultat = resultatAppelRest;
        if(!(inventoryFilmResultat == null)){
            inventory = convertitInventoryEnObjet(resultatAppelRest);
            // Créez une Intent pour l'activité de destination
            Intent intent = new Intent(this, AfficherDetailDvdActivity.class);

            // Ajoutez les informations du film à l'Intent
            intent.putExtra(FILM, film);
            intent.putExtra(INVENTORY, inventory);

            // Lancez l'activité de destination
            startActivity(intent);
        }
    }

    public Inventory convertitInventoryEnObjet(String inventoryJson) {
        Gson gson = new Gson();

        Inventory inventory = gson.fromJson(inventoryJson, Inventory.class);

        return inventory;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        film = (Films) parent.getItemAtPosition(position);

        URL urlAAppeler = null;
        try {
            urlAAppeler = new URL("http://10.0.2.2:8080/inventory/film?film_id="+film.getFilm_id());
            new AppelerServiceRestGETTask(this, false).execute(urlAAppeler, null, null);
        } catch (MalformedURLException mue) {
            Log.d("mydebug", ">>>Pour AppelerServiceRestGETTask - MalformedURLEx-ception mue=" + mue.toString());

        } finally {
            urlAAppeler = null;
        }
    }
}
