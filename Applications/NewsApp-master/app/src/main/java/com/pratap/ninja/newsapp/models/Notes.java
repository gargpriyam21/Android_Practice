package com.pratap.ninja.newsapp.models;

/**
 * Created by darsh on 01-10-2017.
 */

public class Notes {
    private Integer id;
    private String title, body, date;

    public Notes(Integer id, String title, String body, String date) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public Notes(String title, String body, String date) {
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public Notes(String body) {
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }
}
