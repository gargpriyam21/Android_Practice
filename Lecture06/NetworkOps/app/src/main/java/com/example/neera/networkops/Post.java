package com.example.neera.networkops;

/**
 * Created by Neera on 10/09/17.
 */

public class Post {
    Integer id;
    String title;

    public Post(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
