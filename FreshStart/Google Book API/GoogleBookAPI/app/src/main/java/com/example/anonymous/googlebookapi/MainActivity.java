package com.example.anonymous.googlebookapi;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    Spinner search_type;
    EditText search_type_et;
    Button search;

    Intent toLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_type = (Spinner) findViewById(R.id.search_type_spinner);
        search_type_et = (EditText) findViewById(R.id.search_type_edit_text);
        search = (Button) findViewById(R.id.search_button);

        ArrayList<String> search_type_list = new ArrayList<>();

        search_type_list.add("  ");
        search_type_list.add("TITLE");
        search_type_list.add("AUTHOR");
        search_type_list.add("GENRE");


        ArrayAdapter<String> spinner_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, search_type_list);

        search_type.setAdapter(spinner_adapter);

        search_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    case 1:
                        search_type_et.setHint("ex : \"Murder of Roger Ackroyd\"");
                        break;

                    case 2:
                        search_type_et.setHint("ex : \"Agatha Christie\"");
                        break;

                    case 3:
                        search_type_et.setHint("ex : \"Thriller\"");
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                
            }

        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String type_selected = search_type.getSelectedItem().toString();

                String editTextContent = search_type_et.getText().toString();

                toLV = new Intent(MainActivity.this, BooksListView.class);

                toLV.putExtra("type_selected", type_selected);
                toLV.putExtra("edit_text", editTextContent);

                startActivity(toLV);

                Toast.makeText(MainActivity.this, "Search type : " + type_selected + "\nSearch Query : " + editTextContent, Toast.LENGTH_LONG).show();

            }
        });

    }
}
