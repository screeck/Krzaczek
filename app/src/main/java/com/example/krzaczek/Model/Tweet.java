package com.example.krzaczek.Model;

import java.io.Serializable;

public class Tweet implements Serializable {

    private static final long id = 1L;

    private String nick;
    private String text;
    private String Date;
    private int likes;

    public Tweet() {
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


}
