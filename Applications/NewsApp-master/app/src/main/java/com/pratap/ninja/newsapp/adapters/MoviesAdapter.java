package com.pratap.ninja.newsapp.adapters;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.activities.MoviesActivity;
import com.pratap.ninja.newsapp.models.Item;

import java.util.ArrayList;

import static com.pratap.ninja.newsapp.MainActivity.setMark;

/**
 * Created by darsh on 11-10-2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private Context context;
    private ArrayList<Item> results = new ArrayList<>();
    private static final String TAG = "MV";

    public MoviesAdapter(Context context) {
        this.context = context;
    }

    public void updateMovies(ArrayList<Item> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new MoviesViewHolder(li.inflate(R.layout.item_list_movies, parent, false));
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        holder.bindview(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        TextView tvTitle, tvDes, tvDate, tvVisit, tvRate;

        public MoviesViewHolder(View itemView) {

            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImageMovies);
            tvTitle = itemView.findViewById(R.id.tvTitleMovies);
            tvDes = itemView.findViewById(R.id.tvDescriptionMovies);
            tvDate = itemView.findViewById(R.id.tvDateMovies);
            tvVisit = itemView.findViewById(R.id.tvSee);
            tvRate = itemView.findViewById(R.id.tvSearchRate);
        }

        void bindview(final Item result) {
            String title = result.getTitle();
            String date = "Release Date: " + result.getRelease_date();
            tvTitle.setText(title);
            tvDes.setText(result.getOverview());
            tvDate.setText(date);
            String urlImage = "https://image.tmdb.org/t/p/w500" + result.getPoster_path();

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.index);
            requestOptions.error(R.drawable.index);
            requestOptions.centerCrop();
            Glide.with(context).load(urlImage).apply(requestOptions).into(ivImage);

            tvVisit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, MoviesActivity.class)
                            .putExtra("Id", result.getId())
                    );
                }
            });

            tvRate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setMark(false);
                    String url = "https://google.com/search?q=" + "Ratings for " + result.getTitle();
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.launchUrl(context, Uri.parse(url));
                }
            });
        }
    }
}
