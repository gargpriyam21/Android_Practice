package com.pratap.ninja.newsapp.adapters;

import android.app.SearchManager;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.activities.MoviesActivity;
import com.pratap.ninja.newsapp.models.Cast;
import com.pratap.ninja.newsapp.models.Item;
import com.pratap.ninja.newsapp.models.StarCast;

import java.util.ArrayList;

/**
 * Created by darsh on 11-10-2017.
 */

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    private Context context;
    private ArrayList<Cast> casts = new ArrayList<>();
    private static final String TAG = "MV";

    public CastAdapter(Context context) {
        this.context = context;
    }

    public void updateCast(ArrayList<Cast> results) {
        this.casts = results;
        notifyDataSetChanged();
    }

    @Override
    public CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new CastViewHolder(li.inflate(R.layout.item_list_cast, parent, false));
    }

    @Override
    public void onBindViewHolder(CastViewHolder holder, int position) {
        holder.bindview(casts.get(position));
    }

    @Override
    public int getItemCount() {
        return casts.size();
    }

    class CastViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        TextView tvTitleRole, tvTitleName;
        LinearLayout llCast;
        public CastViewHolder(View itemView) {

            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitleName = itemView.findViewById(R.id.tvTitleName);
            tvTitleRole = itemView.findViewById(R.id.tvTitleRole);
            llCast = itemView.findViewById(R.id.llCast);
        }

        void bindview(final Cast result) {
            Log.d(TAG, "bindview: " + result.getName());
            Log.d(TAG, "bindview: " + result.getId());
            String title = result.getName();
            String role = result.getCharacter();
            tvTitleRole.setText(role);
            tvTitleName.setText(title);
            String urlImage = "https://image.tmdb.org/t/p/w500" + result.getProfile_path();

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.index);
            requestOptions.error(R.drawable.index);
            requestOptions.centerCrop();
            Glide.with(context).load(urlImage).apply(requestOptions).into(ivImage);

            llCast.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "https://google.com/search?q=" + result.getName();
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.launchUrl(context, Uri.parse(url));
                }
            });
        }
    }
}
