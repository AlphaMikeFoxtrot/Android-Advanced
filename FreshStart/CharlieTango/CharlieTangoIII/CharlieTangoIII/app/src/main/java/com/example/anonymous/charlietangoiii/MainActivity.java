package com.example.anonymous.charlietangoiii;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Intent toAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<CoffeeType> coffees = new ArrayList<>();

        // BRU :
        coffees.add(new CoffeeType("Bru Instant", 2, 2, R.drawable.bru_final));
        coffees.add(new CoffeeType("Bru Instant", 5, 5, R.drawable.bru_final));
        coffees.add(new CoffeeType("Bru Instant", 8, 10, R.drawable.bru_final));

        // NESCAFE :
        coffees.add(new CoffeeType("NESCAFÉ sunrise", 2, 2, R.drawable.nes));
        coffees.add(new CoffeeType("NESCAFÉ sunrise", 5, 5, R.drawable.nes));
        coffees.add(new CoffeeType("NESCAFÉ sunrise", 8, 10, R.drawable.nes));

        // TODO : add more coffee types!!

//        coffees.add(new CoffeeType("Bru Instant", 2, 2, R.drawable.bru_final));
//        coffees.add(new CoffeeType("Bru Instant", 5, 5, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 8, 10, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 45, 2, R.drawable.bru_final));
//        coffees.add(new CoffeeType("Bru Instant", 5, 5, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 8, 10, R.drawable.bru_final));
//        coffees.add(new CoffeeType("Bru Instant", 2, 2, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 5, 5, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 8, 10, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 2, 2, R.drawable.bru_final));
//        coffees.add(new CoffeeType("Bru Instant", 5, 5, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 8, 10, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 15, 2, R.drawable.bru_final));
//        coffees.add(new CoffeeType("Bru Instant", 5, 5, R.drawable.bru_final));
//        coffees.add(new CoffeeType("Bru Instant", 10, 10, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 2, 2, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 5, 5, R.drawable.nes));
//        coffees.add(new CoffeeType("Bru Instant", 8, 10, R.drawable.nes));

        lv = (ListView) findViewById(R.id.list_view);
        CoffeeAdapter coffeeAdapter = new CoffeeAdapter(this, coffees);
        lv.setAdapter(coffeeAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                String testToastMessage = " weight :  " + coffees.get(position).getmCoffeeNetWeight() +
//                        "\n type :  " + coffees.get(position).getmCoffeeType() +
//                        "\n ruppees :  " + coffees.get(position).getmRuppees() ;
//
//                Toast.makeText(MainActivity.this, testToastMessage, Toast.LENGTH_LONG).show();

                // TODO : add intents and pass data from here to the other intent
                // TODO : create new activity that takes the passed data and
                // TODO : converts it into 'SierraCharlie' card

                toAdd = new Intent(MainActivity.this, SummaryCard.class);

                toAdd.putExtra("coffeeType", coffees.get(position).getmCoffeeType().toString());
                toAdd.putExtra("coffeeWeight", coffees.get(position).getmCoffeeNetWeight());
                toAdd.putExtra("coffeeRuppees", coffees.get(position).getmRuppees());
                toAdd.putExtra("coffeeImageResourceId", coffees.get(position).getmImageResourceId());

                startActivity(toAdd);
            }
        });

    }
}
