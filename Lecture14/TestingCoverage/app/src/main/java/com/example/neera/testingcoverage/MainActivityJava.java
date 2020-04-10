package com.example.neera.testingcoverage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityJava extends AppCompatActivity {


    EditText etKm, etMin;
    TextView tvResult;
    Button btnCalcFare;

    static Float calcFare(Float km, int min) {
        return 50 + ((km > 5) ? ((km - 5) * 12) : 0) + ((min > 15) ? (min - 15) : 0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etKm = (EditText) findViewById(R.id.etKm);
        etMin = (EditText) findViewById(R.id.etMin);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalcFare = (Button) findViewById(R.id.btnCalcFare);


        btnCalcFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText((calcFare(Float.parseFloat(etKm.getText().toString()), Integer.parseInt(etMin.getText().toString()))).toString());
            }
        });


    }
}
