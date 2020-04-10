package com.pratap.ninja.newsapp.api;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by darsh on 02-10-2017.
 */

public class NewsService {
    private NewsService() {}

    private static API api = null;

    public static API getNewsAPI() {
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            api = retrofit.create(API.class);
        }
        Log.d("ERR", "getNewsAPI: llllllllllllllllllllllllllllllllllllll" + api);
        return api;
    }
}
