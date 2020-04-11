package com.example.krzaczek.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krzaczek.Model.Tweet;
import com.example.krzaczek.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Tweet> tweetList;

    public RecyclerViewAdapter(Context context, List<Tweet> tweetList) {

        this.context = context;
        this.tweetList = tweetList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);





        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        Tweet tweet = tweetList.get(position);

        holder.nick.setText(tweet.getNick());
        holder.text.setText(tweet.getText());
        holder.date.setText(tweet.getDate());
        holder.date.setText(tweet.getLikes());


    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView nick;
        TextView text;
        TextView date;
        TextView likes;




        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;


            nick = (TextView) itemView.findViewById(R.id.Nick);
            text = (TextView) itemView.findViewById(R.id.tweet_text);
            date = (TextView) itemView.findViewById(R.id.tweet_date);
            likes = (TextView) itemView.findViewById(R.id.Like_counter);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
