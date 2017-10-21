package com.example.anonymous.googlebookapi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ANONYMOUS on 18-Oct-17.
 */

public class QueryUtils {

    public static URL stringToUrl(String stringUrl){

        URL url = null;

        try {
            url = new URL(stringUrl);
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;

    }

    public static String readFromStream(InputStream inputStream) throws IOException {

        StringBuilder output = new StringBuilder();

        if(inputStream != null){

            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);

            String line = reader.readLine();
            while(line != null){

                output.append(line);
                line = reader.readLine();

            }

        }

        return output.toString();

    }

    public static ArrayList<Book> getJSONfromString(String stringJSON) throws JSONException {

        ArrayList<Book> bookList = new ArrayList<>();

        JSONObject root = new JSONObject(stringJSON);
        JSONArray items = root.getJSONArray("items");

        for (int i = 0; i < 10; i++){

            JSONObject nthItem = items.getJSONObject(i);
            JSONObject volumeInfo = nthItem.getJSONObject("volumeInfo");
            JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
            String imageURL = imageLinks.getString("thumbnail");

            bookList.add(new Book(imageURL));

        }

        return bookList;

    }

    public static ArrayList<Book> makeHttpRequest(URL url) throws JSONException {

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        ArrayList<Book> bookList = null;

        try {

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if(urlConnection.getResponseCode() == 200){

                inputStream = urlConnection.getInputStream();
                String jsonResponse = readFromStream(inputStream);
                bookList = getJSONfromString(jsonResponse);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookList;
    }

}
