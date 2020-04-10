package com.example.neera.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnIntent;
    EditText etVar1,etVar2;
    int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etVar1 = (EditText) findViewById(R.id.etVar1);
        etVar2 = (EditText) findViewById(R.id.etVar2);
        btnIntent = (Button) findViewById(R.id.btnIntent);

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                int a = Integer.parseInt(etVar1.getText().toString());
                int b = Integer.parseInt(etVar2.getText().toString());
                c=a+b;
                Intent i =new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("result",c);
                startActivity(i);
            }
        });



    }

}
