package com.btssio.applicationrftg;

import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class StockPanier {
    private static StockPanier instance;

    private static HashMap<Films, Integer> stockPanier;

    private StockPanier() {
        stockPanier = new HashMap<>();
    }

    public static synchronized StockPanier getInstance() {
        if (instance == null) {
            instance = new StockPanier();
        }
        return instance;
    }

    // Méthode pour ajouter un film au panier
    public static void ajouterAuPanier(Films film, Inventory inventory) {
        stockPanier.put(film, inventory.getInventory_id());
    }

    public static HashMap<Films, Integer> getPanier() {
        return stockPanier;
    }

    public static void viderLePanier() {
        stockPanier = new HashMap<>();
    }
}
