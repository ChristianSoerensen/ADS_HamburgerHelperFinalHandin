package com.example.hamburgerhelper.JsonWebReader;

import android.os.AsyncTask;

import com.example.hamburgerhelper.RestaurantsSource.RestaurantsList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FetchJson extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParsed ="";
    String singleParsed = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/138v90");
            HttpsURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for(int i = 0; i < JA.length();i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "Name: " + JO.get("name") + "\n" +
                        "Food Type: " + JO.get("food_type") + "\n" +
                        "Phone: " + JO.get("phone") + "\n" +
                        "Star rating: " + JO.get("star_rating") + "\n\n";

                dataParsed = dataParsed + singleParsed;



            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        RestaurantsList.showText.setText(dataParsed);
    }
}
