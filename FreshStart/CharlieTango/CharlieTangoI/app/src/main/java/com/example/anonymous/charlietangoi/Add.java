package com.example.anonymous.charlietangoi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Add extends AppCompatActivity {

    ListView coffee_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ArrayList<Coffee> coffees = new ArrayList<>();

        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 10/-", 8));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 5/-", 5));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 2/-", 8));
        coffees.add(new Coffee(R.drawable.nes, "bru instant", "mrp 10/-", 8));
        coffees.add(new Coffee(R.drawable.nes, "bru instant", "mrp 5/-", 5));
        coffees.add(new Coffee(R.drawable.nes, "bru instant", "mrp 2/-", 8));
        coffees.add(new Coffee(R.drawable.nes, "bru instant", "mrp 10/-", 8));
        coffees.add(new Coffee(R.drawable.nes, "bru instant", "mrp 5/-", 5));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 2/-", 8));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 10/-", 8));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 5/-", 10));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 2/-", 8));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 10/-", 8));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 5/-", 5));
        coffees.add(new Coffee(R.drawable.nes, "bru instant", "mrp 2/-", 8));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 10/-", 15));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 5/-", 5));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 2/-", 1));
        coffees.add(new Coffee(R.drawable.nes, "bru instant", "mrp 10/-", 8));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 5/-", 4));
        coffees.add(new Coffee(R.drawable.bru, "bru instant", "mrp 2/-", 8));

        coffee_lv = (ListView) findViewById(R.id.coffe_list_view);
        Adapter adapter = new Adapter(Add.this, coffees);
        coffee_lv.setAdapter(adapter);
    }
}
