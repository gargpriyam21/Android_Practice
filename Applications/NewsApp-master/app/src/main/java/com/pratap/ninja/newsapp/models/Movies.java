package com.pratap.ninja.newsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by darsh on 02-10-2017.
 */

public class Movies {

    @SerializedName("results")
    @Expose
    ArrayList<Item> results = new ArrayList<>();

    public Movies(ArrayList<Item> results) {
        this.results = results;
    }

    public ArrayList<Item> getResults() {
        return results;
    }
}
