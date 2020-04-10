package com.pratap.ninja.newsapp.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.adapters.MoviesAdapter;
import com.pratap.ninja.newsapp.api.MoviesService;
import com.pratap.ninja.newsapp.models.Item;
import com.pratap.ninja.newsapp.models.Movies;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;

public class MoviesFragment extends Fragment {

    EditText etSearch;
    ImageView ivSearch, ivBack;
    RecyclerView rvMovies;
    MoviesAdapter adapter;
    ProgressBar pbMovies;
    TabLayout tabLayout;
    Integer i = 0;
    ArrayList<Item> results = new ArrayList<>();
    String lang = "hi";
    private static final String TAG = "MF";

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View moviesFragmentView = inflater.inflate(R.layout.fragment_movies, container, false);
        etSearch = moviesFragmentView.findViewById(R.id.etSearch);
        ivSearch = moviesFragmentView.findViewById(R.id.ivSearch);
        pbMovies = moviesFragmentView.findViewById(R.id.pbMovies);
        ivBack = moviesFragmentView.findViewById(R.id.ivBackspace);
        rvMovies = moviesFragmentView.findViewById(R.id.rvMovies);
        tabLayout = moviesFragmentView.findViewById(R.id.tabs);

        ivBack.setVisibility(GONE);
        tabLayout.addTab(tabLayout.newTab().setText("Bollywood Movies"), true);
        tabLayout.addTab(tabLayout.newTab().setText("Hollywood Movies"));
        tabLayout.addTab(tabLayout.newTab().setText("Now Playing"));

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new MoviesAdapter(getContext());
        rvMovies.setLayoutManager(layoutManager);
        rvMovies.setAdapter(adapter);


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        final String date = formatter.format(calendar.getTime());
        Log.d(TAG, "onCreateView: " + date);

        MoviesService.getMoviesAPI().getUpcomingMovies(date, lang).enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                adapter.updateMovies(response.body().getResults());
                pbMovies.setVisibility(GONE);
                pbMovies.setIndeterminate(false);
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                i = tab.getPosition();
                adapter.updateMovies(new ArrayList<Item>());
                pbMovies.setVisibility(View.VISIBLE);
                pbMovies.setIndeterminate(true);

                if (i == 0 || i == 1) {
                    if (i == 0) {
                        lang = "hi";
                    }
                    else if (i == 1){
                        lang = "en";
                    }
                    MoviesService.getMoviesAPI().getUpcomingMovies(date, lang).enqueue(new Callback<Movies>() {
                        @Override
                        public void onResponse(Call<Movies> call, Response<Movies> response) {
                            adapter.updateMovies(response.body().getResults());
                            pbMovies.setVisibility(GONE);
                            pbMovies.setIndeterminate(false);
                        }

                        @Override
                        public void onFailure(Call<Movies> call, Throwable t) {

                        }
                    });
                }else {
                    MoviesService.getMoviesAPI().getNowPlayingMovies().enqueue(new Callback<Movies>() {
                        @Override
                        public void onResponse(Call<Movies> call, Response<Movies> response) {
                            adapter.updateMovies(response.body().getResults());
                            pbMovies.setVisibility(GONE);
                            pbMovies.setIndeterminate(false);
                        }

                        @Override
                        public void onFailure(Call<Movies> call, Throwable t) {

                        }
                    });
                }
                layoutManager.smoothScrollToPosition(rvMovies, null, 0);


                Log.d(TAG, "onTabSelected: " + i);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearch.setCursorVisible(true);
            }
        });

        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etSearch.getText().toString().isEmpty()) {

                    tabLayout.setVisibility(GONE);
                    ivBack.setVisibility(View.VISIBLE);
                    adapter.updateMovies(results);
                    pbMovies.setVisibility(View.VISIBLE);
                    pbMovies.setIndeterminate(true);

                    MoviesService.getMoviesAPI().getMovieSearch(etSearch.getText().toString()).enqueue(new Callback<Movies>() {
                        @Override
                        public void onResponse(Call<Movies> call, Response<Movies> response) {
                            adapter.updateMovies(response.body().getResults());
                            layoutManager.smoothScrollToPosition(rvMovies, null, 0);

                            pbMovies.setVisibility(GONE);
                            pbMovies.setIndeterminate(false);
                        }

                        @Override
                        public void onFailure(Call<Movies> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                } else {
                    Toast.makeText(getContext(), "Enter Text!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.beginTransaction()
                        .replace(R.id.cmMain, new MoviesFragment())
//                        .addToBackStack(TAG)
                        .commit();
            }
        });


        return moviesFragmentView;

    }

}
