package com.pratap.ninja.newsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.activities.NewsActivity;
import com.pratap.ninja.newsapp.models.Articles;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private ArrayList<Articles> articles = new ArrayList<>();
    private static final String TAG = "NL";

    public NewsAdapter(Context context) {
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
        return new NewsViewHolder(li.inflate(R.layout.item_list_news, parent, false));
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
        ImageView ivImage;
        LinearLayout llNews;

        NewsViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            llNews = itemView.findViewById(R.id.llNews);
            ivImage = itemView.findViewById(R.id.ivImage);
        }

        void bindView(final Articles articles) {
            Log.d(TAG, "bindView: " + articles.getTitle());
            String date = articles.getPublishedAt();
            if (date != null) date = date.substring(0, date.indexOf('T'));
            String title = articles.getTitle();
            String urlImage = articles.getUrlToImage();
            if (title.endsWith("- Times of India")) {
                title = title.substring(0, title.length() - 16);
            }

            final String finalDate = date;
            final String finalTitle = title;
            final String finalUrlImage = urlImage;
            llNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, NewsActivity.class)
                            .putExtra("Title", finalTitle)
                            .putExtra("Description", articles.getDescription())
                            .putExtra("Author", articles.getAuthor())
                            .putExtra("Date", finalDate)
                            .putExtra("Url", articles.getUrl())
                            .putExtra("UrlImage", finalUrlImage));
                }
            });
            if (title.length() > 116) {
                title = title.substring(0, 115);
                title = title + "...";
            }

            tvTitle.setText(title);
            Log.d(TAG, "bindView: " + urlImage);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.index);
            requestOptions.error(R.drawable.index);
            requestOptions.centerCrop();
            Glide.with(context).load(urlImage).apply(requestOptions).into(ivImage);

        }
    }
}
