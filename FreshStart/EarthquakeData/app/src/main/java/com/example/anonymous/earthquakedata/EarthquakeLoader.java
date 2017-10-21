package com.example.anonymous.earthquakedata;

import android.content.AsyncTaskLoader;
import android.content.Context;

import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANONYMOUS on 14-Oct-17.
 */

public class EarthquakeLoader extends AsyncTaskLoader {

    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Data> loadInBackground() {

        ArrayList<Data> arrayList = null;

        if(mUrl != null){

            try {

                arrayList = QueryUtils.fetchEarthquakes(mUrl);

            } catch (JSONException e) {

                e.printStackTrace();

            }

        }
        return arrayList;
    }
}
