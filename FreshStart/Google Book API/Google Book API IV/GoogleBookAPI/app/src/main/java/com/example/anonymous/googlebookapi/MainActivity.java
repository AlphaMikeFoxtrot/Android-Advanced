package com.example.anonymous.googlebookapi;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static junit.runner.Version.id;

public class MainActivity extends Activity {

    ListView lv;
    EditText et;
    private ListViewAdapter mAdapter;
    private ArrayList<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.list_view);
        et = (EditText) findViewById(R.id.search_bar);

        mAdapter = new ListViewAdapter(MainActivity.this, bookList);

        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){

                    BookAsyncTask bookAsyncTask = new BookAsyncTask();
                    bookAsyncTask.execute("https://www.googleapis.com/books/v1/volumes?q=subject:crime&q=subject:thriller");
                    lv.setAdapter(mAdapter);
                    return true;
                }
                return false;
            }
        });

    }
    private class BookAsyncTask extends AsyncTask<String, Void, ArrayList<Book>>{

        @Override
        protected ArrayList<Book> doInBackground(String... params) {
            if(params.length == 0){

                return null;

            }
            // ArrayList<Book> bookList = null;

            try {
                bookList = QueryUtils.makeHttpRequest(QueryUtils.stringToUrl(params[0]));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return bookList;
        }

        @Override
        protected void onPostExecute(ArrayList<Book> books) {

            if(books != null){

                bookList = books;

            }
        }
    }
}
