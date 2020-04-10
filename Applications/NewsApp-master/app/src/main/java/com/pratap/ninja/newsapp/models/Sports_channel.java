package com.pratap.ninja.newsapp.models;

/**
 * Created by darsh on 07-10-2017.
 */

public class Sports_channel {
    Integer id;
    String name;

    public Sports_channel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
