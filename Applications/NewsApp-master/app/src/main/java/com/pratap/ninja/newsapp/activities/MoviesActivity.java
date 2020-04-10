package com.pratap.ninja.newsapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.adapters.CastAdapter;
import com.pratap.ninja.newsapp.adapters.MoviesAdapter;
import com.pratap.ninja.newsapp.api.MoviesService;
import com.pratap.ninja.newsapp.models.StarCast;
import com.pratap.ninja.newsapp.models.Trailer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static com.pratap.ninja.newsapp.MainActivity.setMark;

public class MoviesActivity extends AppCompatActivity {

    RecyclerView rvCast;
    CardView cdView;
    CastAdapter adapter;
    ProgressBar progressBar;
    public static final String TAG = "DP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        setMark(false);
        rvCast = (RecyclerView) findViewById(R.id.rvCast);
        cdView = (CardView) findViewById(R.id.cdView);
        progressBar = (ProgressBar) findViewById(R.id.pbCast);

        progressBar.setIndeterminate(true);

        Intent i = getIntent();
        final int id = i.getIntExtra("Id", 0);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new CastAdapter(this);
        rvCast.setLayoutManager(layoutManager);
        rvCast.setAdapter(adapter);

        MoviesService.getMoviesAPI().getCast(id).enqueue(new Callback<StarCast>() {
            @Override
            public void onResponse(Call<StarCast> call, Response<StarCast> response) {
                Log.d(TAG, "onResponse: " + response.body().getCast().size());
                adapter.updateCast(response.body().getCast());
                progressBar.setIndeterminate(false);
                progressBar.setVisibility(GONE);
            }

            @Override
            public void onFailure(Call<StarCast> call, Throwable t) {

            }
        });

        cdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoviesService.getMoviesAPI().getVideo(id).enqueue(new Callback<Trailer>() {
                    @Override
                    public void onResponse(Call<Trailer> call, Response<Trailer> response) {
                        if (response.body().getResults().size() != 0) {
                            String url = "https://www.youtube.com/watch?v=" + response.body().getResults().get(0).getKey()
                                    + ".mp4";

                            Log.d(TAG, "onResponse: " + url);
                            Log.d(TAG, "onResponse: " + response.body().getResults().size());
                            Uri uri = Uri.parse(url);

                            CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
                            customTabsIntent.launchUrl(MoviesActivity.this, uri);
                        }
                        else {
                            Toast.makeText(MoviesActivity.this, "Link Missing", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Trailer> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
    }
}
