package com.pratap.ninja.newsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by darsh on 12-10-2017.
 */

public class Results {
    @SerializedName("key")
    @Expose
    private String key;

    public Results(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
