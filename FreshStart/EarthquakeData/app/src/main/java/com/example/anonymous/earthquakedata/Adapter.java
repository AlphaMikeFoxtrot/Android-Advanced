package com.example.anonymous.earthquakedata;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import android.graphics.drawable.GradientDrawable;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.R.attr.offset;
import static android.R.attr.resource;
import static android.R.attr.switchMinWidth;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.anonymous.earthquakedata.R.layout.custom_list_view;

/**
 * Created by ANONYMOUS on 03-Oct-17.
 */

public class Adapter extends ArrayAdapter<Data> {


    public Adapter(@NonNull Context context, @LayoutRes ArrayList<Data> resource) {
        super(context, 0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    custom_list_view, parent, false);
        }

        Data currentData = getItem(position);

        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentData.getmMagnitude());
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.mag);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentData.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        magnitudeView.setText(output);



        // SPLITTING THE EXTRACTED LOCATION INTO TWO DIFFERENT PARTS
        // ONE : OFFSET LOCATION
        // TWO : PRIMARY LOCATION
        String primary_location;
        String offSet_location;
        TextView offsetlocation_text_view = (TextView) listItemView.findViewById(R.id.offset_loc);;
        TextView primarylocation_text_view = (TextView) listItemView.findViewById(R.id.primary_location);
        final String LOCATION_SEPERATOR = " of ";
        String originalLocation = currentData.getmLocation();
        if(originalLocation.contains(LOCATION_SEPERATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPERATOR);
            offSet_location = parts[0] + LOCATION_SEPERATOR;
            primary_location = parts[1];
            offsetlocation_text_view.setText(offSet_location);
            primarylocation_text_view.setText(primary_location);
        } else {

            offSet_location = getContext().getString(R.string.near_the);
            primary_location = originalLocation;
            offsetlocation_text_view.setText(offSet_location);
            primarylocation_text_view.setText(primary_location);

        }



        Date dateObject = new Date(currentData.getmTime());
        DateFormat timeFormat = new SimpleDateFormat("LLL dd, yyyy");
        String date = timeFormat.format(dateObject);
        TextView date_text_view = (TextView) listItemView.findViewById(R.id.date);
        date_text_view.setText(date);
        long date_in_milliseconds = currentData.getmTime();
        Date timeObject = new Date(date_in_milliseconds);
        DateFormat formatDate = new SimpleDateFormat("h:mm a");
        String formattedTime = formatDate.format(timeObject);
        TextView time_text_view = (TextView) listItemView.findViewById(R.id.time);
        time_text_view.setText(formattedTime);

        return listItemView;
    }

    public int getMagnitudeColor(double mag){

        int colorID;

        int simpleMag = (int) Math.floor(mag);

        switch(simpleMag){

            case 0:
            case 1:
                colorID = R.color.magnitude1;
                break;

            case 2:
                colorID = R.color.magnitude2;
                break;

            case 3:
                colorID = R.color.magnitude3;
                break;

            case 4:
                colorID = R.color.magnitude4;
                break;

            case 5:
                colorID = R.color.magnitude5;
                break;

            case 6:
                colorID = R.color.magnitude6;
                break;

            case 7:
                colorID = R.color.magnitude7;
                break;

            case 8:
                colorID = R.color.magnitude8;
                break;

            case 9:
                colorID = R.color.magnitude9;
                break;

            default:
                colorID = R.color.magnitude10plus;
                break;

        }

        return ContextCompat.getColor(getContext(), colorID);
    }
}
