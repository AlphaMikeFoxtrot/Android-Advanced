    package com.example.anonymous.earthquakedata;

import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static com.example.anonymous.earthquakedata.QueryUtils.extractEarthquakes;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Data>> {

    ListView data_list_view;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] USGS_REQUEST_URL = new String[]{"https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=0&maxmag=10&limit=100", "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=0&maxmag=10"};

        EarthquakeAsyncTask earthquakeAsyncTask = new EarthquakeAsyncTask();
        earthquakeAsyncTask.execute(USGS_REQUEST_URL);

        ArrayList<Data> arrayList = new ArrayList<Data>();

        data_list_view = (ListView) findViewById(R.id.list_view);
        mAdapter = new Adapter(MainActivity.this, arrayList);
        data_list_view.setAdapter(mAdapter);

        // final ArrayList<Data> earthquakes = QueryUtils.extractEarthquakes();

        // Adapter adapter = new Adapter(MainActivity.this, earthquakes);

        data_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data current = mAdapter.getItem(position);
                String url = current.getmUrl();

                Uri webpage = Uri.parse(url);

                Intent toBrowser = new Intent(Intent.ACTION_VIEW, webpage);
                if (toBrowser.resolveActivity(getPackageManager()) != null) {
                    startActivity(toBrowser);
                }
            }
        });

    }

    private class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Data>> {

        @Override
        protected List<Data> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Data> result = null;
            try {
                result = QueryUtils.fetchEarthquakes(urls[0]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(List<Data> datas) {
            mAdapter.clear();

            if(datas != null && !datas.isEmpty()){

                mAdapter.addAll(datas);

            }
        }
    }
}
