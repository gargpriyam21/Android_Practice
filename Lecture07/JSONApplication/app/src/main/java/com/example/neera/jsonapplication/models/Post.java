package com.example.neera.jsonapplication.models;

/**
 * Created by Neera on 10/09/17.
 */

public class Post {
    Integer id;
    String title;
    String body;

    public Post(Integer id, String title, String body) {
        this.id = id;
        this.title = title;
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
}
