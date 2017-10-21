package com.example.anonymous.googlebookapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public ImageView cover;
    Bitmap bookCover;
    public final String URL = ""; //= "http://books.google.com/books/content?id=x0cvCwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cover = (ImageView) findViewById(R.id.book_cover);
        ImageAsyncTask imageAsyncTask = new ImageAsyncTask();
        imageAsyncTask.execute(URL);

        Picasso.with(this).load(URL).into(cover);
    }

    public Bitmap getImageBitmap(String url){

        Bitmap image = null;
        try {
            InputStream input = new java.net.URL(url).openStream();
            image = BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;

    }

    public class ImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            return getImageBitmap(params[0]);
        }

        @Override
        protected void onPostExecute(Bitmap aVoid) {
            super.onPostExecute(aVoid);
            cover.setImageBitmap(aVoid);
        }
    }
}
