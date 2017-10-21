package com.example.anonymous.googlebookapi;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by ANONYMOUS on 18-Oct-17.
 */

public class ListViewAdapter extends ArrayAdapter {

    public ListViewAdapter(@NonNull Context context, ArrayList<Book> resource) {

        super(context, 0, resource);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_list_view, parent, false
            );

        }

        Book currentBook = (Book) getItem(position);

        ImageView bookCover = (ImageView) listItemView.findViewById(R.id.book_cover);
        Picasso.with(getContext()).load(currentBook.getImageURL()).into(bookCover);

        return listItemView;

    }
}
