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

public class BusinessFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    RecyclerView rvBusiness;
    ProgressBar pbBusiness;
    String source, sortBy;
    MultiUseAdapter adapter;
    LinearLayoutManager layoutManager;

    public static final String TAG = "BSS";

    public BusinessFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View businessFragmentView = inflater.inflate(R.layout.fragment_business, container, false);
        rvBusiness = businessFragmentView.findViewById(R.id.rvBusiness);
        pbBusiness = businessFragmentView.findViewById(R.id.pbBusiness);
        spinner = businessFragmentView.findViewById(R.id.spBusiness);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_business, R.layout.selected_channel);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(this);

        layoutManager = new LinearLayoutManager(getContext());
        rvBusiness.setLayoutManager(layoutManager);

        pbBusiness.setIndeterminate(true);

        adapter = new MultiUseAdapter(getContext());
        rvBusiness.setAdapter(adapter);

        source = "cnbc";
        sortBy = "top";
        NewsService.getNewsAPI().getMultiUse(source, sortBy).enqueue(new Callback<MutiUse>() {
            @Override
            public void onResponse(Call<MutiUse> call, Response<MutiUse> response) {
                Log.d(TAG, "onResponse: " + response.body().getArticles().size());
                adapter.updateMultiUse(response.body().getArticles());
                pbBusiness.setIndeterminate(false);
                pbBusiness.setVisibility(GONE);
            }

            @Override
            public void onFailure(Call<MutiUse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return businessFragmentView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemSelected: " + adapterView.getItemAtPosition(i));
        Log.d(TAG, "onItemSelected: " + i);
        pbBusiness.setIndeterminate(true);
        switch (i) {
            case 0:
                source = "cnbc";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvBusiness, null, 0);
                break;
            case 1:
                source = "the-economist";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvBusiness, null, 0);
                break;
            case 2:
                source = "financial-times";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvBusiness, null, 0);
                break;
            case 3:
                source = "fortune";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvBusiness, null, 0);
                break;
            case 4:
                source = "bloomberg";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvBusiness, null, 0);
                break;
            case 5:
                source = "business-insider";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvBusiness, null, 0);
                break;
            case 6:
                source = "the-wall-street-journal";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvBusiness, null, 0);
                break;
        }

        NewsService.getNewsAPI().getMultiUse(source, sortBy).enqueue(new Callback<MutiUse>() {
            @Override
            public void onResponse(Call<MutiUse> call, Response<MutiUse> response) {
                Log.d(TAG, "onResponse: " + response.body().getArticles().size());
                adapter.updateMultiUse(response.body().getArticles());
                pbBusiness.setIndeterminate(false);
                pbBusiness.setVisibility(GONE);
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
