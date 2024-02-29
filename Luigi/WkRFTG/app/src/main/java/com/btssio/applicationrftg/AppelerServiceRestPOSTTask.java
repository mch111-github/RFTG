package com.btssio.applicationrftg;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppelerServiceRestPOSTTask extends AsyncTask<URL,Integer,String> {
    private volatile AfficherPanierActivity screen;  //référence à l'écran
    public AppelerServiceRestPOSTTask(AfficherPanierActivity p) {

        this.screen = p ;
    }
    @Override
    protected void onPreExecute() {
        System.out.println(">>>onPreExecute");
        //prétraitement de l'appel
    }
    @Override
    protected String doInBackground(URL... urls) {
        String sResultatAppel = null;
        boolean result;
        URL urlAAppeler = urls[0];
        System.out.println(">>>lien:"+urlAAppeler);
        result = appelerServiceRestHttp(urlAAppeler);
        if (result) {
            sResultatAppel = "Panier Valider";
        } else {
            sResultatAppel = "Panier non Valider";
        }
        return sResultatAppel;
    }
    @Override
    protected void onPostExecute(String resultat) {
        System.out.println(">>>onPostExecute "+resultat);
    }
    private Boolean appelerServiceRestHttp(URL urlAAppeler) {
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) urlAAppeler.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("User-Agent", System.getProperty("http.agent"));
            urlConnection.setDoOutput(true);

            int responseCode = urlConnection.getResponseCode();

        } catch (IOException ioe) {
            Log.d("mydebug", ">>>Pour appelerServiceRestHttp - IOException ioe =" + ioe.toString());
            return false;
        } catch (Exception e) {
            Log.d("mydebug",">>>Pour appelerServiceRestHttp - Excep-tion="+e.toString());
            return false;
        } finally {
            urlConnection.disconnect();
        }
        return true;
    }
}
