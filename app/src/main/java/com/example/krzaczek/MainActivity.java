package com.example.krzaczek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.example.krzaczek.Data.RecyclerViewAdapter;
import com.example.krzaczek.Model.Tweet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Tweet> tweetList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.Recycler_view);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(this, tweetList);
        recyclerView.setAdapter(recyclerViewAdapter);

        tweetList = new ArrayList<>();

        try {
            addItemsFromJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void addItemsFromJSON() throws IOException {

        try{

            String jsonDataString = readJSONDataFromFile();

            JSONArray jsonArray = new JSONArray(jsonDataString);

            for(int i = 0; i < jsonArray.length(); ++i) {

                JSONObject itemObj = jsonArray.getJSONObject(i);

                String date = itemObj.getString("created_at");
                String text = itemObj.getString("text");
                String likes = itemObj.getString("favorite_count");

                Tweet tweet = new Tweet(date, text, likes);
                tweetList.add(tweet);



            }


        }catch (JSONException e) {

        }
    }

    private String readJSONDataFromFile() throws IOException {

        InputStream inputStream = null;

        StringBuilder builder = new StringBuilder();

        try{

            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.sorted_tweets_by_likes);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));

            while ((jsonString = bufferedReader.readLine()) != null) {

                builder.append(jsonString);
            }


        }finally {
            if(inputStream != null) {
                inputStream.close();
            }

        }

        return new String(builder);



    }
}
