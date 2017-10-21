package com.example.anonymous.charlietangoiii;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.fingerprintAuthDrawable;
import static android.R.attr.resource;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by ANONYMOUS on 10-Oct-17.
 */

public class CoffeeAdapter extends ArrayAdapter {

    public CoffeeAdapter(@NonNull Context context, ArrayList<CoffeeType> resource) {

        super(context, 0, resource);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        CoffeeType currentCoffee = (CoffeeType) getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentCoffee.getmImageResourceId());

        TextView coffee_type_tv = (TextView) listItemView.findViewById(R.id.coffee_type);
        coffee_type_tv.setText(currentCoffee.getmCoffeeType().toString());

        TextView ruppees_tv = (TextView) listItemView.findViewById(R.id.ruppees);
        ruppees_tv.setText(Integer.toString(currentCoffee.getmRuppees()) + "/-");

        TextView net_weight = (TextView) listItemView.findViewById(R.id.caffeine_circle);
        GradientDrawable gradientDrawable = (GradientDrawable) net_weight.getBackground();
        gradientDrawable.setColor(getColorId(currentCoffee.getmCoffeeNetWeight()));
        net_weight.setText(Integer.toString(currentCoffee.getmCoffeeNetWeight()));

        return listItemView;

    }

    public int getColorId(int netWeight){

        int colorID;

        switch (netWeight){

            case 0:
            case 1:
            case 2:
                colorID = R.color.caffeine_amount_2;
                break;

            case 3:
                colorID = R.color.caffeine_amount_3;
                break;

            case 4:
                colorID = R.color.caffeine_amount_4;
                break;

            case 5:
                colorID = R.color.caffeine_amount_5;
                break;

            case 6:
                colorID = R.color.caffeine_amount_6;
                break;

            case 7:
                colorID = R.color.caffeine_amount_7;
                break;

            case 8:

                // TODO : find a better way of using weight above 8 grarms

            case 9:


            case 10:
            default:
                colorID = R.color.caffeine_amount_10plus;
                break;

        }

        return ContextCompat.getColor(getContext(), colorID);

    }
}
