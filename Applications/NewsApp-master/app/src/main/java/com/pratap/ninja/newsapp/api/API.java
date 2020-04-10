package com.pratap.ninja.newsapp.api;

import com.pratap.ninja.newsapp.models.Movies;
import com.pratap.ninja.newsapp.models.MutiUse;
import com.pratap.ninja.newsapp.models.News;
import com.pratap.ninja.newsapp.models.StarCast;
import com.pratap.ninja.newsapp.models.Trailer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    @GET("v1/articles?source=new-scientist&apiKey=0c79744f40544082a89092f81237200f")
    Call<News> getGoogleNews(@Query("sortBy") String sortBy);

    @GET("v1/articles?apiKey=0c79744f40544082a89092f81237200f")
    Call<News> getNews(@Query("source") String source,
                       @Query("sortBy") String sortBy);

    @GET("v1/articles?apiKey=0c79744f40544082a89092f81237200f")
    Call<MutiUse> getMultiUse(@Query("source") String source,
                              @Query("sortBy") String sortBy);

    @GET("search/movie?api_key=a209668efcf190ad658fdf2361572ceb&")
    Call<Movies> getMovieSearch(@Query("query") String query);

    @GET("discover/movie?api_key=a209668efcf190ad658fdf2361572ceb" +
            "&language=en-US&include_adult=false&include_video=false")
    Call<Movies> getUpcomingMovies(@Query("primary_release_date.gte") String primary_release_date,
                                    @Query("with_original_language") String with_original_language
    );

    @GET("movie/{movie_id}/credits?api_key=a209668efcf190ad658fdf2361572ceb")
    Call<StarCast> getCast(@Path("movie_id") Integer movie_id);

    @GET("movie/now_playing?api_key=a209668efcf190ad658fdf2361572ceb&language=en-US")
    Call<Movies> getNowPlayingMovies ();

    @GET("movie/{movie_id}/videos?api_key=a209668efcf190ad658fdf2361572ceb&language=en-US")
    Call<Trailer> getVideo(@Path("movie_id") Integer movie_id);


}
