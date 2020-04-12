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
    private List<Tweet> tweetList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.Recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tweetList = new ArrayList<>();


        for(int i = 0; i< 10; i++){
            Tweet tweet = new Tweet("data", "text",  "2000", "Nick");

            tweetList.add(tweet);

        }

        recyclerViewAdapter = new RecyclerViewAdapter(this, tweetList);
        recyclerView.setAdapter(recyclerViewAdapter);



    }


}
