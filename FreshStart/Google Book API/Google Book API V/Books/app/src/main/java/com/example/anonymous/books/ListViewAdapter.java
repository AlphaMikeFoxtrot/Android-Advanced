package com.example.anonymous.books;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by ANONYMOUS on 18-Oct-17.
 */

public class ListViewAdapter extends ArrayAdapter {
    public ListViewAdapter(@NonNull Context context, ArrayList<Books> resource) {
        super(context, 0 ,resource);
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

        Books currentBook = (Books) getItem(position);

        ImageView bookCover = (ImageView) listItemView.findViewById(R.id.book_cover);
        Picasso.with(getContext()).load(currentBook.getImageURL()).fit().into(bookCover);

        TextView bookTitle = (TextView) listItemView.findViewById(R.id.book_name);
        bookTitle.setText(currentBook.getBookName().toString());

        TextView bookAuthors = (TextView) listItemView.findViewById(R.id.book_authors);
        StringBuilder output = new StringBuilder();
        if(currentBook.getAuthorsArray().length() != 0){

            for(int i = 0; i < currentBook.getAuthorsArray().length(); i++){

                try {
                    output.append(currentBook.getAuthorsArray().get(i).toString());
                    if( (currentBook.getAuthorsArray().length() > 1)){

                        output.append(", ");

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
        bookAuthors.setText(output.toString());

        TextView category = (TextView) listItemView.findViewById(R.id.genre);
        StringBuilder categoryBuilder = new StringBuilder();

        for (int i = 0; i < currentBook.getGenre().length(); i++){

            try {
                categoryBuilder.append(currentBook.getGenre().get(i).toString());
                if(currentBook.getGenre().length() > 1){
                    categoryBuilder.append(", ");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        category.setText("Genre : " + categoryBuilder.toString());

        return listItemView;
    }
}
