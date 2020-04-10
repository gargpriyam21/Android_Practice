package com.pratap.ninja.newsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.adapters.NewsAdapter;
import com.pratap.ninja.newsapp.adapters.NewsAdapterHorizontal;
import com.pratap.ninja.newsapp.api.NewsService;
import com.pratap.ninja.newsapp.models.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;

public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    RecyclerView rvNews, rvHorizontalNews;
    ProgressBar pbNews;
    Spinner spinner;
    String source, sortBy;
    LinearLayoutManager layoutManager;
    NewsAdapter adapter;

    public static final String TAG = "ERROR";

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainFragmentView = inflater.inflate(R.layout.fragment_main, container, false);
        rvNews = mainFragmentView.findViewById(R.id.rvNews);
        rvHorizontalNews = mainFragmentView.findViewById(R.id.rvHorizontalNews);
        spinner = mainFragmentView.findViewById(R.id.spMain);


        SnapHelper snapHelper = new PagerSnapHelper();
        pbNews = mainFragmentView.findViewById(R.id.pbNews);
        snapHelper.attachToRecyclerView(rvHorizontalNews);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_main, R.layout.selected_channel);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(this);
        spinner.setVisibility(GONE);

        layoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvNews.getContext(),
                layoutManager.getOrientation());
        rvNews.addItemDecoration(dividerItemDecoration);
        rvNews.setLayoutManager(layoutManager);
        rvHorizontalNews.setLayoutManager(layoutManager1);

        pbNews.setIndeterminate(true);

        adapter = new NewsAdapter(getContext());
        final NewsAdapterHorizontal adapterH = new NewsAdapterHorizontal(getContext());
        rvNews.setAdapter(adapter);
        rvHorizontalNews.setAdapter(adapterH);


        NewsService.getNewsAPI().getGoogleNews("top").enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                adapterH.updateNews(response.body().getArticles());
                pbNews.setIndeterminate(false);
                spinner.setVisibility(View.VISIBLE);
                pbNews.setVisibility(GONE);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                t.printStackTrace();
            }
        });


        source = "the-times-of-india";
        sortBy = "latest";
        NewsService.getNewsAPI().getNews(source, sortBy).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                Log.d(TAG, "onResponse: " + response.body().getArticles().size());
                adapter.updateNews(response.body().getArticles());
                pbNews.setIndeterminate(false);
                pbNews.setVisibility(GONE);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return mainFragmentView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        pbNews.setIndeterminate(true);
        switch (i) {
            case 0:
                source = "the-times-of-india";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvNews, null, 0);
                break;
            case 1:
                source = "the-hindu";
                sortBy = "latest";
                layoutManager.smoothScrollToPosition(rvNews, null, 0);
                break;
            case 2:
                source = "abc-news-au";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvNews, null, 0);
                break;
            case 3:
                source = "the-new-york-times";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvNews, null, 0);
                break;
            case 4:
                source = "bbc-news";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvNews, null, 0);
                break;
            case 5:
                source = "new-york-magazine";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvNews, null, 0);
                break;
            case 6:
                source = "cnn";
                sortBy = "top";
                layoutManager.smoothScrollToPosition(rvNews, null, 0);
                break;
        }

        NewsService.getNewsAPI().getNews(source, sortBy).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                adapter.updateNews(response.body().getArticles());
                pbNews.setIndeterminate(false);
                pbNews.setVisibility(GONE);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
