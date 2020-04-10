package com.pratap.ninja.newsapp.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pratap.ninja.newsapp.R;

public class ManageActivity extends AppCompatActivity {

    EditText etName, etEmail;
    SharedPreferences preferences;
    public static final String TAG = "SP";
    Button btchange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etName = (EditText) findViewById(R.id.etName);
        btchange = (Button) findViewById(R.id.btChange);

        btchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("userName", etName.getText().toString());
                editor.putString("userEmail", etEmail.getText().toString());
                editor.apply();
                Toast.makeText(ManageActivity.this, "Changes Applied", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
