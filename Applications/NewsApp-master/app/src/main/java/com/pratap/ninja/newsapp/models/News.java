package com.pratap.ninja.newsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by darsh on 02-10-2017.
 */

public class News {

    @SerializedName("articles")
    @Expose
    ArrayList<Articles> articles = new ArrayList<>();

    public News(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }
}
