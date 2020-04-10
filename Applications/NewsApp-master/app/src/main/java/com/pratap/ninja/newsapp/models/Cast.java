package com.pratap.ninja.newsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by darsh on 12-10-2017.
 */

public class Cast {
    @SerializedName("character")
    @Expose
    private String character;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("profile_path")
    @Expose
    private String profile_path;

    public Cast(String character, Integer id, String name, String profile_path) {
        this.character = character;
        this.id = id;
        this.name = name;
        this.profile_path = profile_path;
    }

    public String getCharacter() {
        return character;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfile_path() {
        return profile_path;
    }
}
