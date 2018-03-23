package com.oops.studentmanager.Api;

import android.util.Log;

import com.oops.studentmanager.Constants.Constants;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import Security.Crypto;

/**
 * Created by i24sm on 11/22/2016.
 */
public class HttpHandler {



    public String GetText(String url_to, String data) {


        Crypto cryp= new Crypto();

        String text = "";
        BufferedReader reader = null;
        try {
            Log.d("url_to",url_to);
            URL url = new URL(url_to);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            String encrypt=cryp.encrypt(data, Constants.FIVE,Constants.SECRET_KEY);
            wr.write(encrypt);
            wr.flush();

            // Get the server response
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while ((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }

            text = sb.toString();
            Log.d("text",text);
        } catch (Exception ex) {

        } finally {
            try {

                reader.close();
            } catch (Exception ex) {
            }
        }

        return text;
    }




}
