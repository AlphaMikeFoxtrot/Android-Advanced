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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.firstDayOfWeek;
import static android.R.attr.resource;

/**
 * Created by ANONYMOUS on 15-Oct-17.
 */

public class BooksListViewAdapter extends ArrayAdapter {

    public BooksListViewAdapter(@NonNull Context context, ArrayList<Book> resource) {

        super(context, 0, resource);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_list_view, parent, false);

        }

        Book currentBook = (Book) getItem(position);

        ImageView aBookCover = (ImageView) listItemView.findViewById(R.id.book_cover);
        aBookCover.setImageBitmap(currentBook.getImage_bitmap());

        TextView aTitle = (TextView) listItemView.findViewById(R.id.title);
        aTitle.setText(currentBook.getTitle().toString());

        TextView aAuthors = (TextView) listItemView.findViewById(R.id.authors);
        String authors = "";
        authors += currentBook.getAuthors().get(0);
//        for(int i = 0; i < currentBook.getAuthors().size(); i++){
//
//            authors += currentBook.getAuthors().get(i).toString();
//
//        }
        aAuthors.setText(authors.toString());

        TextView aDescription = (TextView) listItemView.findViewById(R.id.description);
        aDescription.setText(currentBook.getDescription().toString());

        TextView aPublishDate = (TextView) listItemView.findViewById(R.id.publish_date);
        aPublishDate.setText(currentBook.getPublish_date().toString());



        return listItemView;

    }
}
