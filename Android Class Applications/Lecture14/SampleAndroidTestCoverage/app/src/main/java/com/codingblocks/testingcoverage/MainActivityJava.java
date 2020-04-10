package com.codingblocks.testingcoverage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityJava extends AppCompatActivity {
    EditText etKm, etMin;
    TextView tvResult;
    Button btnCalcFare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etKm = (EditText) findViewById(R.id.etKm);
        etMin = (EditText) findViewById(R.id.etMin);
        btnCalcFare = (Button) findViewById(R.id.btnCalcFare);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnCalcFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText(
                        String.valueOf(
                                calcFare(
                                        Float.valueOf(etKm.getText().toString()),
                                        Integer.valueOf(etMin.getText().toString())
                                )
                        )
                );
            }
        });
    }

    static float calcFare (float km, int min) {
        return 0 +
                ((km > 5) ? (km - 5) * 12 : 0) +
                ((min > 15) ? (min - 15) : 0);
    }
}
