package com.pratap.ninja.newsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by darsh on 12-10-2017.
 */

public class StarCast {
    @SerializedName("cast")
    @Expose
    ArrayList<Cast> cast = new ArrayList<>();

    public StarCast(ArrayList<Cast> cast) {
        this.cast = cast;
    }

    public ArrayList<Cast> getCast() {
        return cast;
    }
}
