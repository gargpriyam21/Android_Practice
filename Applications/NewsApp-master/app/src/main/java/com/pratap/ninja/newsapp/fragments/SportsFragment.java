package com.pratap.ninja.newsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.adapters.MultiUseAdapter;
import com.pratap.ninja.newsapp.api.NewsService;
import com.pratap.ninja.newsapp.models.MutiUse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;

public class SportsFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    RecyclerView rvSports;
    ProgressBar pbSports;
    String source, sortBy;
    MultiUseAdapter adapter;
    LinearLayoutManager layoutManager;

    public static final String TAG = "TECH";

    public SportsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View sportsFragmentView = inflater.inflate(R.layout.fragment_sports, container, false);
        rvSports = sportsFragmentView.findViewById(R.id.rvSports);
        pbSports = sportsFragmentView.findViewById(R.id.pbSports);
        spinner = sportsFragmentView.findViewById(R.id.spSports);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_sports, R.layout.selected_channel);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(this);

        layoutManager = new LinearLayoutManager(getContext());
        rvSports.setLayoutManager(layoutManager);

        pbSports.setIndeterminate(true);

        adapter = new MultiUseAdapter(getContext());
        rvSports.setAdapter(adapter);

        source = "bbc-sport";
        sortBy = "top";
        NewsService.getNewsAPI().getMultiUse(source, sortBy).enqueue(new Callback<MutiUse>() {
            @Override
            public void onResponse(Call<MutiUse> call, Response<MutiUse> response) {
                Log.d(TAG, "onResponse: " + response.body().getArticles().size());
                adapter.updateMultiUse(response.body().getArticles());
                pbSports.setIndeterminate(false);
                pbSports.setVisibility(GONE);
            }

            @Override
            public void onFailure(Call<MutiUse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return sportsFragmentView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemSelected: " + adapterView.getItemAtPosition(i));
        Log.d(TAG, "onItemSelected: " + i);
        pbSports.setIndeterminate(true);
        switch (i) {
            case 0:
                source = "bbc-sport";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvSports, null, 0);
                break;
            case 1:
                source = "espn";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvSports, null, 0);
                break;
            case 2:
                source = "espn-cric-info";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvSports, null, 0);
                break;
            case 3:
                source = "football-italia";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvSports, null, 0);
                break;
            case 4:
                source = "four-four-two";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvSports, null, 0);
                break;
            case 5:
                source = "fox-sports";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvSports, null, 0);
                break;
            case 6:
                source = "nfl-news";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvSports, null, 0);
                break;
            case 7:
                source = "talksport";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvSports, null, 0);
                break;
            case 8:
                source = "the-sport-bible";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvSports, null, 0);
                break;
        }

        NewsService.getNewsAPI().getMultiUse(source, sortBy).enqueue(new Callback<MutiUse>() {
            @Override
            public void onResponse(Call<MutiUse> call, Response<MutiUse> response) {
                Log.d(TAG, "onResponse: " + response.body().getArticles().size());
                adapter.updateMultiUse(response.body().getArticles());
                pbSports.setIndeterminate(false);
                pbSports.setVisibility(GONE);
            }

            @Override
            public void onFailure(Call<MutiUse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
