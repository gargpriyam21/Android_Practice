package com.example.neera.jsonapplication.api;

import com.example.neera.jsonapplication.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Neera on 26/09/17.
 */

public interface API {

    @GET("/users")
    Call<ArrayList<User>> getUsers();
}
