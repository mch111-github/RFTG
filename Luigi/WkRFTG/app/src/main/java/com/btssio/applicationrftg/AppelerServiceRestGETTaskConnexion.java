package com.btssio.applicationrftg;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class AppelerServiceRestGETTaskConnexion extends AsyncTask<URL,Integer,String> {

    private volatile ConnexionActivity screen;  //référence à l'écran
    public AppelerServiceRestGETTaskConnexion(ConnexionActivity s) {
        this.screen = s ;
    }
    @Override
    protected void onPreExecute() {
        System.out.println(">>>onPreExecute");
        //prétraitement de l'appel
    }
    @Override
    protected String doInBackground(URL... urls) {
        String sResultatAppel = null;
        URL urlAAppeler = urls[0];
        System.out.println(">>>lien:"+urlAAppeler);
        sResultatAppel = appelerServiceRestHttp(urlAAppeler);
        System.out.println(">>>résultat:"+sResultatAppel);
        return sResultatAppel;
    }
    @Override
    protected void onPostExecute(String resultat) {
        System.out.println(">>>onPostExecute");
        this.screen.connexionValide(resultat);
    }

    //On peut par exemple implémenter ici appelerServiceRestHttp (par exemple, ou si on veut dans une classe à part)
    private String appelerServiceRestHttp(URL urlAAppeler) {
        HttpURLConnection urlConnection = null;
        int responseCode = -1;
        String sResultatAppel = "";
        try {
            //Exemple pour un appel GET
            urlConnection = (HttpURLConnection) urlAAppeler.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("User-Agent", System.getProperty("http.agent"));

            responseCode = urlConnection.getResponseCode();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            //lecture du résulat de l'appel et alimentation de la chaine de caractères à renvoyer vers l'appelant
            int codeCaractere = -1;
            while ((codeCaractere = in.read()) != -1) {
                sResultatAppel = sResultatAppel + (char) codeCaractere;
            }
            in.close();
        } catch (IOException ioe) {
            Log.d("mydebug", ">>>Pour appelerServiceRestHttp - IOException ioe =" + ioe.toString());
        } catch (Exception e) {
            Log.d("mydebug",">>>Pour appelerServiceRestHttp - Excep-tion="+e.toString());
        } finally {
            urlConnection.disconnect();
        }
        return sResultatAppel;
    }
}
