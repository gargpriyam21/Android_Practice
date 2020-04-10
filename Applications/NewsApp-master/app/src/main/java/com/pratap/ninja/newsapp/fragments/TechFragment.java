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

public class TechFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    RecyclerView rvTech;
    ProgressBar pbTech;
    String source, sortBy;
    MultiUseAdapter adapter;
    LinearLayoutManager layoutManager;

    public static final String TAG = "TECH";

    public TechFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View techFragmentView = inflater.inflate(R.layout.fragment_tech, container, false);
        rvTech = techFragmentView.findViewById(R.id.rvTech);
        pbTech = techFragmentView.findViewById(R.id.pbTech);
        spinner = techFragmentView.findViewById(R.id.spTech);


        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_tech, R.layout.selected_channel);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(this);

        layoutManager = new LinearLayoutManager(getContext());
        rvTech.setLayoutManager(layoutManager);

        pbTech.setIndeterminate(true);

        adapter = new MultiUseAdapter(getContext());
        rvTech.setAdapter(adapter);

        source = "techradar";
        sortBy = "latest";
        NewsService.getNewsAPI().getMultiUse(source, sortBy).enqueue(new Callback<MutiUse>() {
            @Override
            public void onResponse(Call<MutiUse> call, Response<MutiUse> response) {
                Log.d(TAG, "onResponse: " + response.body().getArticles().size());
                adapter.updateMultiUse(response.body().getArticles());
                pbTech.setIndeterminate(false);
                pbTech.setVisibility(GONE);
            }

            @Override
            public void onFailure(Call<MutiUse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return techFragmentView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemSelected: " + adapterView.getItemAtPosition(i));
        Log.d(TAG, "onItemSelected: " + i);
        pbTech.setIndeterminate(true);
        switch (i) {
            case 0:
                source = "techradar";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvTech, null, 0);
                break;
            case 1:
                source = "techcrunch";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvTech, null, 0);
                break;
            case 2:
                source = "polygon";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvTech, null, 0);
                break;
            case 3:
                source = "engadget";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvTech, null, 0);
                break;
            case 4:
                source = "hacker-news";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvTech, null, 0);
                break;
            case 5:
                source = "ars-technica";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvTech, null, 0);
                break;
        }

        NewsService.getNewsAPI().getMultiUse(source, sortBy).enqueue(new Callback<MutiUse>() {
            @Override
            public void onResponse(Call<MutiUse> call, Response<MutiUse> response) {
                Log.d(TAG, "onResponse: " + response.body().getArticles().size());
                adapter.updateMultiUse(response.body().getArticles());
                pbTech.setIndeterminate(false);
                pbTech.setVisibility(GONE);
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
