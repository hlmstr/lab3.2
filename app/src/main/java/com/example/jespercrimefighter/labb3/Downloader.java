package com.example.jespercrimefighter.labb3;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jespercrimefighter on 11/23/16.
 * TODO: parserklass som fixar indatan och fixar den, synca trådarna, popup window grejen
 *
 */

public class Downloader extends AsyncTask<String, Integer, String> {

    private PopUpList pul;
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
        pul = InteractiveSearcher.pul;
        pul.handleResult(result);

    }
}
