package com.example.neera.openapps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etLink, etNumber;
    Button btBrowser, btDialer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLink = (EditText) findViewById(R.id.etLink);
        etNumber = (EditText) findViewById(R.id.etNumber);
        btBrowser = (Button) findViewById(R.id.btBrowser);
        btDialer = (Button) findViewById(R.id.btDialer);

        btBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = etLink.getText().toString();
                if (!url.startsWith("https://")) {
                    url = "https://" + url;
                }

                Intent i_browser = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i_browser);
                etLink.setText(null);
            }
        });

        btDialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = etNumber.getText().toString();
                number = "tel:" + number;

                Intent i_dialer = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
                startActivity(i_dialer);
                etNumber.setText(null);
            }
        });


    }
}
