package com.pratap.ninja.newsapp.api;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by darsh on 02-10-2017.
 */

public class MoviesService {
    private MoviesService() {}

    private static API api = null;

    public static API getMoviesAPI() {
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            api = retrofit.create(API.class);
        }
        return api;
    }
}
