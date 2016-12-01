package com.example.jespercrimefighter.labb3;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jespercrimefighter on 11/23/16
 */

public class Downloader extends AsyncTask<String, Integer, String> {

    private InteractiveSearcher interactiveSearcher;

    public Downloader(InteractiveSearcher is){
        interactiveSearcher = is;
    }

    private String connect(final String searchTerm, final String id) {
        URL url;
        String indata ="";
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("http://flask-afteach.rhcloud.com/getnames/" + id + "/" + searchTerm);

            urlConnection = (HttpURLConnection) url
                    .openConnection();

            InputStream in = urlConnection.getInputStream();
            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                indata += current;
                data = isw.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return indata;
    }


    @Override
    protected String doInBackground(String... params) {
        return connect(params[0], params[1]);
    }

    protected void onPostExecute(String result){
        JSONObject json = null;
        JSONArray itemList = null;
        System.out.println("indata: " + result);
        try {
            json = new JSONObject(result);
            itemList = json.getJSONArray("result");
            System.out.println("itemList: " + itemList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        interactiveSearcher.setItemList(itemList); //Skicka reslutaten
        interactiveSearcher.getPopUpList().showAsDropDown(interactiveSearcher.getSearchField()); //Visa popup
    }
}
