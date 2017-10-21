package com.example.anonymous.googlebookapi;

import android.graphics.Bitmap;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by ANONYMOUS on 15-Oct-17.
 */

public class Book {

    String title;
    ArrayList<String> authors = new ArrayList<>();
    String publish_date;
    String description;
    String info_link;
    Bitmap image_bitmap;

    public Book(String title, ArrayList<String> authors, String publish_date, String description, String info_link, Bitmap image_bitmap) {

        this.title = title;
        this.authors = authors;
        this.publish_date = publish_date;
        this.description = description;
        this.info_link = info_link;
        this.image_bitmap = image_bitmap;

    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public String getDescription() {
        return description;
    }

    public String getInfo_link() {
        return info_link;
    }

    public Bitmap getImage_bitmap() {
        return image_bitmap;
    }
}
