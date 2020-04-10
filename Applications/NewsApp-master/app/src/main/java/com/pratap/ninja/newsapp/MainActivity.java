package com.pratap.ninja.newsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pratap.ninja.newsapp.activities.InfoActivity;
import com.pratap.ninja.newsapp.activities.ManageActivity;
import com.pratap.ninja.newsapp.activities.NotesActivity;
import com.pratap.ninja.newsapp.fragments.BusinessFragment;
import com.pratap.ninja.newsapp.fragments.MainFragment;
import com.pratap.ninja.newsapp.fragments.MoviesFragment;
import com.pratap.ninja.newsapp.fragments.NotesFragment;
import com.pratap.ninja.newsapp.fragments.SportsFragment;
import com.pratap.ninja.newsapp.fragments.TechFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    public static final String TAG = "CHECK";
    FragmentManager fm;
    NavigationView navigationView;
    TextView tvName, tvEmail;
    Boolean f;
    static Boolean mark = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.cmMain, new MainFragment()).commit();

        final FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mark = false;
                startActivity(new Intent(MainActivity.this, NotesActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.navNews);

    }

    public static void setMark(Boolean b){
        mark = b;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionUser) {
            startActivity(new Intent(this, ManageActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (f) {
            navigationView.setCheckedItem(R.id.navNews);
            fm.beginTransaction()
                    .replace(R.id.cmMain, new MainFragment())
                    .commit();
            f = false;
        }
        else {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Exit");
            builder.setMessage("Do you want to exit?").setPositiveButton("YES",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.super.onBackPressed();
                        }
                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    builder.setCancelable(true);
                }
            }).create().show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //Handle View Selection Here
        f = true;

        switch (item.getItemId()) {
            case R.id.navNews:
//                fm.popBackStack(TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fm.beginTransaction()
                        .replace(R.id.cmMain, new MainFragment())
                        .commit();
                f = false;
                break;
            case R.id.navSports:
                fm.beginTransaction()
                        .replace(R.id.cmMain, new SportsFragment())
//                        .addToBackStack(TAG)
                        .commit();
                break;
            case R.id.navBusiness:
                fm.beginTransaction()
                        .replace(R.id.cmMain, new BusinessFragment())
//                        .addToBackStack(TAG)
                        .commit();
                break;
            case R.id.navTech:
                fm.beginTransaction()
                        .replace(R.id.cmMain, new TechFragment())
//                        .addToBackStack(TAG)
                        .commit();
                break;
            case R.id.navBrowse:
                String url = "https://google.com";
                CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
                customTabsIntent.launchUrl(this, Uri.parse(url));
                break;
            case R.id.navNotes:
                fm.beginTransaction()
                        .replace(R.id.cmMain, new NotesFragment())
//                        .addToBackStack(TAG)
                        .commit();
                break;
            case R.id.navMovies:
                fm.beginTransaction()
                        .replace(R.id.cmMain, new MoviesFragment())
//                        .addToBackStack(TAG)
                        .commit();
                break;
            case R.id.navInfo:
                startActivity(new Intent(this, InfoActivity.class));
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        if (mark){
            navigationView.setCheckedItem(R.id.navNews);
            navigationView.setCheckedItem(R.id.navNews);
            fm.beginTransaction()
                    .replace(R.id.cmMain, new MainFragment())
                    .commit();
            f = false;
        }
        else mark = true;

        View view = navigationView.getHeaderView(0);
        tvName = view.findViewById(R.id.tvName);
        tvEmail = view.findViewById(R.id.tvEmail);

        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String nameUser = p.getString("userName", "Android Studio");
        if (nameUser.isEmpty()) nameUser = "User";
        String email = p.getString("userEmail", "Android Studio");
        if (email.isEmpty()) email = "email@email.com";
        tvName.setText(nameUser);
        tvEmail.setText(email);
        Log.d(TAG, "onResume: " +p.getString("userName", "Android Studio"));
    }
}
