package com.pratap.ninja.newsapp.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.db.NotesDbHelper;
import com.pratap.ninja.newsapp.db.Table.NotesTable;
import com.pratap.ninja.newsapp.models.Notes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.pratap.ninja.newsapp.MainActivity.setMark;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView tvTitle ,tvDescription, tvUrl, tvAuthor, tvDate, tvSave;
        ImageView ivNewsDetails;
        final SQLiteDatabase notesDb;
        setMark(false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_news_details);

        Intent i = getIntent();
        final String title = i.getStringExtra("Title");
        final String desciption = i.getStringExtra("Description");
        String author = i.getStringExtra("Author");
        String date = i.getStringExtra("Date");
        final String url = i.getStringExtra("Url");
        String urlImage = i.getStringExtra("UrlImage");

        tvTitle = (TextView) findViewById(R.id.tvTitleDetails);
        tvDescription = (TextView) findViewById(R.id.tvDescriptionDetails);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvUrl = (TextView) findViewById(R.id.tvUrl);
        tvSave = (TextView) findViewById(R.id.tvSave);
        ivNewsDetails =  (ImageView) findViewById(R.id.ivImageDetails);
        notesDb = new NotesDbHelper(this    ).getWritableDatabase();


        tvTitle.setText(title);
        tvDescription.setText(desciption);

        tvUrl.setClickable(true);
        tvUrl.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='' > LINK </a>";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvUrl.setText(Html.fromHtml(text, Html.FROM_HTML_OPTION_USE_CSS_COLORS));
        }

        if (author != null) tvAuthor.setText(author);
            else tvAuthor.setText(R.string.Anonymous);
        if (date != null) tvDate.setText(date);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.index);
        requestOptions.error(R.drawable.index);
        requestOptions.centerCrop();
        Glide.with(this).load(urlImage).apply(requestOptions).into(ivNewsDetails);

        if (url != null && url.length() > 6) {
            tvUrl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
                    customTabsIntent.launchUrl(NewsActivity.this, Uri.parse(url));
                }
            });
        }

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(NewsActivity.this, "Saved to Notes", Toast.LENGTH_SHORT).show();

                String title_sub = title;
                String body_sub = desciption + "\n\nLINK:\n" + url;
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

    }
}
