package com.example.anonymous.googlebookapi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ANONYMOUS on 16-Oct-17.
 */

public class QueryUtils {

    public String readFromJSON(String string) throws JSONException {

        String imageUrl = null;

        JSONObject root = new JSONObject(string);
        JSONArray items = root.getJSONArray("items");
        for (int i = 0; i < items.length(); i++){

            JSONObject nthItem = items.getJSONObject(i);

            JSONObject volumeInfo = nthItem.getJSONObject("volumeInfo");

            JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");

            imageUrl = imageLinks.getString("smallThumbnail");

        }

        return imageUrl;
    }
}
