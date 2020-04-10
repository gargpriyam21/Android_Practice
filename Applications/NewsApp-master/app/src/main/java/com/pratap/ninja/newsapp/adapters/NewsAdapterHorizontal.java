package com.pratap.ninja.newsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.models.Articles;

import java.util.ArrayList;

public class NewsAdapterHorizontal extends RecyclerView.Adapter<NewsAdapterHorizontal.NewsViewHolder> {

    private Context context;
    private ArrayList<Articles> articles = new ArrayList<>();
    private static final String TAG = "NL";

    public NewsAdapterHorizontal(Context context) {
        this.context = context;
    }

    public void updateNews(ArrayList<Articles> articles) {
        Log.d(TAG, "updateNews: " + articles.size());
        this.articles = articles;
        notifyDataSetChanged();
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new NewsViewHolder(li.inflate(R.layout.item_list_news_horizontal, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.bindView(articles.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + articles.size());
        return articles.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivNewsH, ivLink;

        NewsViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitleHorizontal);
            ivNewsH = itemView.findViewById(R.id.ivImageHorizontal);
            ivLink = itemView.findViewById(R.id.ivLink);
        }

        void bindView(final Articles articles) {
            Log.d(TAG, "bindView: " + articles.getTitle());
            String title = articles.getTitle();
            String urlImage = articles.getUrlToImage();
            if (title.endsWith("- Times of India")) {
                title = title.substring(0, title.length() - 16);
            }

            tvTitle.setText(title);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.index);
            requestOptions.error(R.drawable.index);
            requestOptions.centerCrop();
            Glide.with(context).load(urlImage).apply(requestOptions).into(ivNewsH);

            ivLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
                    customTabsIntent.launchUrl(context, Uri.parse(articles.getUrl()));
                }
            });
        }
    }
}
