package com.example.neera.activity_main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.acl.LastOwnerException;

public class MainActivity extends AppCompatActivity {

    EditText etFirstName,etLastName;
    Button btnAdd;
    TextView tvFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        btnAdd = (Button) findViewById(R.id.btAdd);
        tvFullName = (TextView) findViewById(R.id.tvFullName);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int firstName = Integer.parseInt(etFirstName.getText().toString());
                int lastname = Integer.parseInt(etLastName.getText().toString());

                int fullName = firstName + lastname;

                tvFullName.setText(Integer.toString(fullName));
            }
        });


    }
}
