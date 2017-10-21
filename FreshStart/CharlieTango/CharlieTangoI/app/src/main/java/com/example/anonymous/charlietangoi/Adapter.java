package com.example.anonymous.charlietangoi;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by ANONYMOUS on 09-Oct-17.
 */

public class Adapter extends ArrayAdapter<Coffee> {

    public Adapter(@NonNull Context context, @LayoutRes ArrayList<Coffee> resource) {
        super(context, 0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_list_view, parent, false);
        }


        Coffee currentCoffee = (Coffee) getItem(position);

        ImageView brand = (ImageView) listItemView.findViewById(R.id.brand);
        brand.setImageResource(currentCoffee.getmImageResId());

        TextView coffeeType = (TextView) listItemView.findViewById(R.id.coffee_type);
        coffeeType.setText(currentCoffee.getmCoffeeType().toString());

        TextView description = (TextView) listItemView.findViewById(R.id.sub_description);
        description.setText(currentCoffee.getmDescription().toString());

        TextView grams = (TextView) listItemView.findViewById(R.id.death_circle);
        GradientDrawable caffeine_circle = (GradientDrawable) grams.getBackground();
        int caffeine_circle_color = getCaffeineColor(currentCoffee.getmWeight());
        caffeine_circle.setColor(caffeine_circle_color);
        grams.setText(currentCoffee.getmWeight());

        return listItemView;

    }

    public int getCaffeineColor(int weight){

        int colorId;

        if(weight > 10){

            colorId = R.color.caffeineGreaterThan10;

        } else if(weight < 8 && weight > 5){

            colorId = R.color.caffeineLessThan8;

        } else if(weight < 5 && weight > 3){

            colorId = R.color.caffeineLessThan5;

        } else {

            colorId = R.color.caffeineLessThan3;

        }

        return ContextCompat.getColor(getContext(), colorId);
    }
}
