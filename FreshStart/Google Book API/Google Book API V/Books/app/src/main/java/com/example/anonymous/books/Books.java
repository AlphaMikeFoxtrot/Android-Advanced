package com.example.anonymous.books;

import org.json.JSONArray;

/**
 * Created by ANONYMOUS on 18-Oct-17.
 */

public class Books {

    private String imageURL;
    private String bookName;
    private JSONArray authorsArray;
    private JSONArray genre;

    public Books(String imageURL, String bookName, JSONArray authorsArray, JSONArray genre) {
        this.imageURL = imageURL;
        this.bookName = bookName;
        this. authorsArray = authorsArray;
        this.genre = genre;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getBookName() {
        return bookName;
    }

    public JSONArray getAuthorsArray() {
        return authorsArray;
    }

    public JSONArray getGenre() {
        return genre;
    }
}
