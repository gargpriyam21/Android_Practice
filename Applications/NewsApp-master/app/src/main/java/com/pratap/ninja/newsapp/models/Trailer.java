package com.pratap.ninja.newsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by darsh on 12-10-2017.
 */

public class Trailer {
    @SerializedName("results")
    @Expose
    ArrayList<Results> results = new ArrayList<>();

    public Trailer(ArrayList<Results> results) {
        this.results = results;
    }

    public ArrayList<Results> getResults() {
        return results;
    }
}
