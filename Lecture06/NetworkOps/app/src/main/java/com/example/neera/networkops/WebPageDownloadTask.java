package com.example.neera.networkops;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Neera on 09/09/17.
 */

public class WebPageDownloadTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStreamReader is = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(is);
            StringBuilder sb = new StringBuilder();
            String buffer = "";
            while (buffer != null) {
                sb.append(buffer);
                buffer = br.readLine();
            }
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return "Download Error";
        }


    }
}
