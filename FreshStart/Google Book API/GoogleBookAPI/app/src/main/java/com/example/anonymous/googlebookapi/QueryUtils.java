package com.example.anonymous.googlebookapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by ANONYMOUS on 15-Oct-17.
 */

public class QueryUtils {

    public static ArrayList<Book> extractInfoFromJSON(String jsonString){

        ArrayList<Book> books = null;

        try {

            JSONObject root = new JSONObject(jsonString);
            JSONArray items = root.getJSONArray("items");
            for(int  i = 0; i < items.length(); i++){

                String title = "";
                ArrayList<String> authors = new ArrayList<>();
                String publish_date = "";
                String description = "";
                String info_link = "";
                String image_url = "";
                Bitmap image_bitmap = null;

                JSONObject nthItem = items.getJSONObject(i);

                JSONObject volume_info = nthItem.getJSONObject("volumeInfo");

                // extracting the title of the volume:
                title += volume_info.getString("title");

                /*
                 * extracting authors of the volume
                 * using for loop
                 * (since the name of the authors
                 *  is stored in an array)
                 */
                JSONArray authors_array = volume_info.getJSONArray("authors");
                for(int j = 0; j < authors_array.length(); j++){

                    authors.add(authors_array.get(j).toString());

                }

                // extracting the date the volume was published
                // TODO : converth the String publish date to Integer
                publish_date += volume_info.getString("publishedDate");

                // extracting the description of the volume
                description += volume_info.getString("description");

                // extracting link to access further info
                // regarding the volume
                // TODO : find a better way of using the link
                info_link += volume_info.getString("infoLink");

                // extracting image bitmap from the downloadable link:
                JSONObject image_links = volume_info.getJSONObject("imageLinks");
                image_url = image_links.getString("smallThumbnail");

                try {

                    InputStream input = new java.net.URL(image_url).openStream();
                    image_bitmap = BitmapFactory.decodeStream(input);

                } catch (IOException e) {

                    e.printStackTrace();

                }

                // converting authors jsonarray in to array list:
                ArrayList<String> authors_array_list = new ArrayList<>();
                for (int k = 0; k < authors_array.length(); k++){
                    authors_array_list.add(authors_array.get(k).toString());
                }

                books.add(new Book(title, authors_array_list, publish_date, description, info_link, image_bitmap));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return books;

    }

}
