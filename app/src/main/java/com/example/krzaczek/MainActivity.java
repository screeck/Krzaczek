package com.example.krzaczek;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.example.krzaczek.Data.RecyclerViewAdapter;
import com.example.krzaczek.Model.Tweet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private List<Tweet> tweetList;
    private RequestQueue queue;
    private final static String URL = "https://github.com/jcob-sikorski/NewsFeed/blob/master/sorted_tweets_by_likes.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.Recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tweetList = new ArrayList<>();


        for(int i = 0; i < 10; i++) {

            Tweet tweet = new Tweet("Data", "Text", "2000", "Elon Musk");


            tweetList.add(tweet);

        }




        extractTweets(URL);


        recyclerViewAdapter = new RecyclerViewAdapter(this, tweetList);
        recyclerView.setAdapter(recyclerViewAdapter);


    }

    private void extractTweets(String url) {


    }
}




