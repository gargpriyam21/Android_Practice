package com.example.neera.intentprctise;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    EditText Input;
    Button btGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Input = (EditText) findViewById(R.id.input);
        btGo = (Button) findViewById(R.id.btgo);

        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent i = new Intent(Intent.ACTION_SENDTO);
//                i.setData(Uri.parse("mailto:"+Input.getText().toString()));
//                i.putExtra(Intent.EXTRA_EMAIL, Input.getText().toString());
//                i.putExtra(Intent.EXTRA_SUBJECT, "Time Pass");

//                Intent i = new Intent(Intent.ACTION_SENDTO);
//                i.setData(Uri.parse("smsto:"+Input.getText().toString()));
//                i.putExtra("sms_body", "hello"  );
//                startActivity(i);

            }
        });
    }
}
