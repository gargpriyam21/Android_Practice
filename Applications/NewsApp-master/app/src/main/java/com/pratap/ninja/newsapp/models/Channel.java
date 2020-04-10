package com.pratap.ninja.newsapp.models;

/**
 * Created by darsh on 05-10-2017.
 */

public class Channel {

    int id;
    String name;
    String sortBy;
    String source;

    public Channel(int id, String name, String sortBy, String source) {
        this.id = id;
        this.name = name;
        this.sortBy = sortBy;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSource() {
        return source;
    }
}
