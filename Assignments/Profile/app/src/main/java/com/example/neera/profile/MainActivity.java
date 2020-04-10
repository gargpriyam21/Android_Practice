package com.example.neera.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCall, btnEmail, btnfb;
    TextView tvnumber, tvid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = (Button) findViewById(R.id.btnCall);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnfb = (Button) findViewById(R.id.btnfb);
        tvnumber = (TextView) findViewById(R.id.tvnumber);
        tvid = (TextView) findViewById(R.id.tvid);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = tvnumber.getText().toString();
                number = "tel:" + number;

                Intent i_dialer = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
                startActivity(i_dialer);

            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:" + tvid.getText().toString()));
                startActivity(i);
            }
        });

        btnfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.facebook.com/priyamgarg21";

                Intent i_browser = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i_browser);

            }
        });
    }
}
