package com.example.anonymous.books;

import android.text.style.TabStopSpan;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.security.AccessController;
import java.util.ArrayList;

/**
 * Created by ANONYMOUS on 18-Oct-17.
 */

public class QueryUtils {

    public static ArrayList<Books> readFromJson(String json) throws JSONException {

        ArrayList<Books> booksList = new ArrayList<>();
        String imageUrl;
        String bookTitle;

        JSONObject root = new JSONObject(json);
        JSONArray items = root.getJSONArray("items");

        for(int i = 0; i < items.length(); i++){

            JSONObject nthItem = items.getJSONObject(i);
            JSONObject volumeInfo = nthItem.getJSONObject("volumeInfo");
            if(volumeInfo.has("imageLinks") && volumeInfo.has("title") && volumeInfo.has("authors") && volumeInfo.has("categories")) {
                JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                imageUrl = imageLinks.getString("thumbnail");
                bookTitle = volumeInfo.getString("title");
                JSONArray authors = volumeInfo.getJSONArray("authors");
                JSONArray categories = volumeInfo.getJSONArray("categories");
                booksList.add(new Books(imageUrl, bookTitle, authors, categories));
            }

        }

        return booksList;

    }

}
