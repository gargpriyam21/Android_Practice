package com.example.neera.episodegenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public static Integer Episode, Season;
    Button btnGenerate;
    TextView tvSeason, tvEpisode;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = new Random();

        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        tvEpisode = (TextView) findViewById(R.id.tvEpisode);
        tvSeason = (TextView) findViewById(R.id.tvSeason);


        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Generate();
                tvSeason.setText(String.valueOf(Season));
                tvEpisode.setText(String.valueOf(Episode));
            }
        });


    }

    public final void Generate() {
        Season = r.nextInt(10) + 1;

        switch (Season) {
            case 1:
                Episode = r.nextInt(24) + 1;
                break;
            case 2:
                Episode = r.nextInt(24) + 1;
                break;
            case 3:
                Episode = r.nextInt(25) + 1;
                break;
            case 4:
                Episode = r.nextInt(24) + 1;
                break;
            case 5:
                Episode = r.nextInt(24) + 1;
                break;
            case 6:
                Episode = r.nextInt(25) + 1;
                break;
            case 7:
                Episode = r.nextInt(24) + 1;
                break;
            case 8:
                Episode = r.nextInt(24) + 1;
                break;
            case 9:
                Episode = r.nextInt(24) + 1;
                break;
            case 10:
                Episode = r.nextInt(18) + 1;
                break;
        }
    }
}
