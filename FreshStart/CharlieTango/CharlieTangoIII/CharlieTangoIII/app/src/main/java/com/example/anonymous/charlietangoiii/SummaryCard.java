package com.example.anonymous.charlietangoiii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SummaryCard extends AppCompatActivity {

    TextView mMrp, mWeight, mCoffeeAmount, mCaffeineAmount, mCoffeeType, mNoOfPackets;
    Button addPackets, removePackets;
    ImageView mBrandImage;
    private String coffeeType;
    private int coffeeImageResourceID;
    private int coffeeWeight;
    private int coffeeRuppees;
    private double coffeeAmount;
    private double caffeineAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_card);

        mBrandImage = (ImageView) findViewById(R.id.brand_image);

        mNoOfPackets = (TextView) findViewById(R.id.no_of_packets);
        mMrp = (TextView) findViewById(R.id.mrp);
        mCoffeeType = (TextView) findViewById(R.id.coffee_type);
        mCoffeeAmount = (TextView) findViewById(R.id.coffee_amount);
        mCaffeineAmount = (TextView) findViewById(R.id.caffeine_amount);
        mWeight = (TextView) findViewById(R.id.weight);

        addPackets = (Button) findViewById(R.id.more_button_packets);
        removePackets = (Button) findViewById(R.id.less_button_packets);

        Intent intent = getIntent();

        coffeeType = intent.getStringExtra("coffeeType").toUpperCase();
        coffeeImageResourceID = intent.getIntExtra("coffeeImageResourceId", 0);
        coffeeRuppees = intent.getIntExtra("coffeeRuppees", 0);
        coffeeWeight = intent.getIntExtra("coffeeWeight", 0);

        coffeeAmount = 0.59 * coffeeWeight;     // in grams
        caffeineAmount = coffeeAmount * 0.00026;    // in grams

        DecimalFormat decimalFormat = new DecimalFormat("0.0000");
        decimalFormat.format(coffeeAmount);
        decimalFormat.format(caffeineAmount);

        mMrp.setText(Integer.toString(coffeeRuppees) + "/-");
        mCoffeeType.setText(coffeeType.toString());
        mCoffeeAmount.setText(Double.toString(coffeeAmount));
        mCaffeineAmount.setText(Double.toString(caffeineAmount * 100));
        mWeight.setText(Integer.toString(coffeeWeight));

        mBrandImage.setImageResource(coffeeImageResourceID);

        addPackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double aCoffeeAmount, aCaffeineAmount;
                int aWeight;

                // TODO : add methods to update coffee and caffeine values on click
                // TODO : find a way to convert the present view into dynamic view

                mNoOfPackets.setText(Integer.toString(Integer.parseInt(mNoOfPackets.getText().toString()) + 1));

                aCoffeeAmount = Double.parseDouble(mCoffeeAmount.getText().toString());
                aCaffeineAmount = Double.parseDouble(mCaffeineAmount.getText().toString());
                aWeight = Integer.parseInt(mWeight.getText().toString());

//                mCoffeeAmount.setText(Double.toString(Double.parseDouble(mCoffeeAmount.getText().toString()) + aCoffeeAmount));
//                mCaffeineAmount.setText(Double.toString(Double.parseDouble(mCaffeineAmount.getText().toString()) + aCaffeineAmount));
//                mWeight.setText(Integer.toString(Integer.parseInt(mWeight.getText().toString()) + aWeight));

                mCoffeeAmount.setText(Double.toString(aCoffeeAmount + coffeeAmount));
                mCaffeineAmount.setText(Double.toString(aCaffeineAmount + caffeineAmount));
                mWeight.setText(Integer.toString(aWeight + coffeeWeight));

            }
        });

        removePackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Integer.parseInt(mNoOfPackets.getText().toString()) > 1) {

                    double aCoffeeAmount, aCaffeineAmount;
                    int aWeight;

                    mNoOfPackets.setText(Integer.toString(Integer.parseInt(mNoOfPackets.getText().toString()) - 1));

                    aCoffeeAmount = Double.parseDouble(mCoffeeAmount.getText().toString());
                    aCaffeineAmount = Double.parseDouble(mCaffeineAmount.getText().toString());
                    aWeight = Integer.parseInt(mWeight.getText().toString());

//                    mCoffeeAmount.setText(Double.toString(Double.parseDouble(mCoffeeAmount.getText().toString()) - aCoffeeAmount));
//                    mCaffeineAmount.setText(Double.toString(Double.parseDouble(mCaffeineAmount.getText().toString()) - aCaffeineAmount));
//                    mWeight.setText(Integer.toString(Integer.parseInt(mWeight.getText().toString()) - aWeight));

                    mCoffeeAmount.setText(Double.toString(aCoffeeAmount - coffeeAmount));
                    mCaffeineAmount.setText(Double.toString(aCaffeineAmount - caffeineAmount));
                    mWeight.setText(Integer.toString(aWeight - coffeeWeight));

                } else {

                    Toast.makeText(SummaryCard.this, "no of packets cannot be less than one !!!!", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_submit){

            Toast.makeText(this, "Your coffee entry has been registered!! \n" + mNoOfPackets.getText().toString(), Toast.LENGTH_LONG).show();
            return true;

        } else {

            return false;

        }


    }

}
