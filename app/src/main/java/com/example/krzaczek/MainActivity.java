package com.example.krzaczek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.krzaczek.Data.RecyclerViewAdapter;
import com.example.krzaczek.Model.Tweet;
import com.example.krzaczek.Util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private List<Tweet> tweetList;
    private RequestQueue queue;
    private final static String URl = "https://github.com/jcob-sikorski/NewsFeed/blob/master/sorted_tweets_by_likes.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.Recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tweetList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            Tweet tweet = new Tweet("data", "text", "2000", "Nick");

            tweetList.add(tweet);

        }

        recyclerViewAdapter = new RecyclerViewAdapter(this, tweetList);
        recyclerView.setAdapter(recyclerViewAdapter);


    }

      JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
              Constants.URL,null, new Response.Listener<JSONObject>() {
          @Override
          public void onResponse(JSONObject response) {
              try {
                  JSONArray tweetsArray = response.getJSONArray("Search");

                  for (int i = 0; i < tweetsArray.length(); i++){

                      JSONObject tweetObj = tweetsArray.getJSONObject(i);

                      Tweet tweet = new Tweet();

                      tweet.setDate(tweetObj.getString("created_at"));
                      tweet.setLikes(tweetObj.getString("favorite_count"));
                      tweet.setText(tweetObj.getString("text"));
                      tweet.setNick(tweetObj.getString(""));


                  }
              } catch (JSONException e) {
                  e.printStackTrace();
              }


          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {

          }
      });


}


