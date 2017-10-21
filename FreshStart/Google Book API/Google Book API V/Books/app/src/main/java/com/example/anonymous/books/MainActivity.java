package com.example.anonymous.books;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button author, title, subject;
    EditText search_query;
    Intent toLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        author = (Button) findViewById(R.id.author);
        title = (Button) findViewById(R.id.title);
        subject = (Button) findViewById(R.id.subject);

        search_query = (EditText) findViewById(R.id.userSearchQuery);

        toLv = new Intent(getApplicationContext(), BookList.class);

        if(!(search_query.getText().toString().isEmpty())) {
            author.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "https://www.googleapis.com/books/v1/volumes?q=inauthor:" + search_query.getText().toString().replace(" ", "+") + "&maxResults=20";
                    toLv.putExtra("url", url.toString());
                    startActivity(toLv);
                }
            });

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + search_query.getText().toString().replace(" ", "+") + "&maxResults=20";
                    toLv.putExtra("url", url.toString());
                    startActivity(toLv);
                }
            });

            subject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "https://www.googleapis.com/books/v1/volumes?q=subject:" + search_query.getText().toString().replace(" ", "+") + "&maxResults=20";
                    toLv.putExtra("url", url.toString());
                    startActivity(toLv);
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "Search field is empty!", Toast.LENGTH_SHORT).show();
        }

    }
}
