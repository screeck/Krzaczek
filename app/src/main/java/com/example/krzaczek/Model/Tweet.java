package com.example.krzaczek.Model;

import java.io.Serializable;

public class Tweet implements Serializable {

    private static final long id = 1L;

    private String nick;
    private String text;
    private String Date;
    private String likes;

    public Tweet(String date, String text, String likes, String nick) {

        this.Date = date;
        this.text = text;
        this.likes = likes;
        this.nick = nick;

    }

    public static long getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }


}
