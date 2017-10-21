package com.example.anonymous.googlebookapithree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button toLVbutton;
    Intent toLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toLVbutton = (Button) findViewById(R.id.button);
        toLV = new Intent(MainActivity.this, BooksListView.class);
    }
}
