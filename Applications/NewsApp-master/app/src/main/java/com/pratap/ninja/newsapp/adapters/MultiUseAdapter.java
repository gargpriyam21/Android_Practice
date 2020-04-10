package com.pratap.ninja.newsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.db.NotesDbHelper;
import com.pratap.ninja.newsapp.db.Table.NotesTable;
import com.pratap.ninja.newsapp.models.Articles;
import com.pratap.ninja.newsapp.models.Notes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static com.pratap.ninja.newsapp.MainActivity.setMark;

public class MultiUseAdapter extends RecyclerView.Adapter<MultiUseAdapter.MultiViewHolder> {

    private Context context;
    private ArrayList<Articles> articles = new ArrayList<>();
    private static final String TAG = "SL";
    SQLiteDatabase notesDb;

    public MultiUseAdapter(Context context) {
        this.context = context;
    }

    public void updateMultiUse(ArrayList<Articles> articles) {
        Log.d(TAG, "updateSports: " + articles.size());
        this.articles = articles;
        notifyDataSetChanged();
    }

    @Override
    public MultiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new MultiViewHolder(li.inflate(R.layout.item_list_multi_use, parent, false));
    }

    @Override
    public void onBindViewHolder(MultiViewHolder holder, int position) {
        holder.bindView(articles.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + articles.size());
        return articles.size();
    }

    class MultiViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDes, tvLink, tvSave;
        ImageView ivImage;

        MultiViewHolder(View itemView) {
            super(itemView);

            //Supplying Id's
            tvTitle = itemView.findViewById(R.id.tvTitleTech);
            tvDes = itemView.findViewById(R.id.tvDescriptionTech);
            ivImage = itemView.findViewById(R.id.ivImageTech);
            tvLink = itemView.findViewById(R.id.tvLink);
            tvSave = itemView.findViewById(R.id.tvSave);
            notesDb = new NotesDbHelper(context).getWritableDatabase();

        }

        void bindView(final Articles articles) {
            String des = articles.getDescription();
            if (des == null) des = "Visit ->";
            String urlImage = articles.getUrlToImage();

            tvLink.setClickable(true);
            tvLink.setMovementMethod(LinkMovementMethod.getInstance());
            String text = "<a href='' > LINK </a>";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                tvLink.setText(Html.fromHtml(text, Html.FROM_HTML_OPTION_USE_CSS_COLORS));
            }


            if (articles.getUrl() != null && articles.getUrl().length() > 6) {
                tvLink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setMark(false);
                        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
                        customTabsIntent.launchUrl(context, Uri.parse(articles.getUrl()));
                    }
                });
            }

            tvSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Saved to Notes", Toast.LENGTH_SHORT).show();

                    String title_sub = articles.getTitle();
                    String body_sub = articles.getDescription() + "\n\nLINK:\n" + articles.getUrl();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                    // Create a calendar object that will convert the date and time value in milliseconds to date.
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    String date = formatter.format(calendar.getTime());
                    if (title_sub.isEmpty()) title_sub = "Title";

                    long notesId = NotesTable.insertNotes(notesDb,
                            new Notes(title_sub, body_sub, date)
                    );
                }
            });


            tvTitle.setText(articles.getTitle());
            tvDes.setText(des);
            Log.d(TAG, "bindView: " + urlImage);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.index);
            requestOptions.error(R.drawable.index);
            requestOptions.centerCrop();
            Glide.with(context).load(urlImage).apply(requestOptions).into(ivImage);
        }
    }
}
