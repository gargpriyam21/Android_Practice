package com.example.neera.pcalculator;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PCalculator extends AppCompatActivity {

    EditText etEnterText;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEquals, buttonDot, buttonClear;
    TextView twAnswer;

    Double ValueOne = Double.NaN;
    Double ValueTwo;

    char ch;

    private void Calculate() {
        if (!Double.isNaN(ValueOne)) {
            ValueTwo = Double.parseDouble(etEnterText.getText().toString());
            etEnterText.setText(null);

            if (ch == '+') {
                ValueOne = ValueOne + ValueTwo;
            } else if (ch == '-') {
                ValueOne = ValueOne - ValueTwo;
            } else if (ch == '*') {
                ValueOne = ValueOne * ValueTwo;
            } else if (ch == '/') {
                ValueOne = ValueOne / ValueTwo;
            }

        } else {
            ValueOne = Double.parseDouble(etEnterText.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcalculator);

        etEnterText = (EditText) findViewById(R.id.EnterText);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonEquals = (Button) findViewById(R.id.buttonEquals);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        twAnswer = (TextView) findViewById(R.id.twAnswer);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + "9");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEnterText.setText(etEnterText.getText() + ".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
                ch = '+';
                twAnswer.setText(Double.toString(ValueOne) + "+");
                etEnterText.setText(null);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
                ch = '-';
                twAnswer.setText(Double.toString(ValueOne) + "-");
                etEnterText.setText(null);
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
                ch = '*';
                twAnswer.setText(Double.toString(ValueOne) + "*");
                etEnterText.setText(null);
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
                ch = '/';
                twAnswer.setText(Double.toString(ValueOne) + "/");
                etEnterText.setText(null);
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();

                twAnswer.setText(twAnswer.getText().toString() + Double.toString(ValueTwo) + "=" + Double.toString(ValueOne));
                ValueOne = Double.NaN;
                ch = ' ';

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twAnswer.setText(null);
            }
        });


    }
}
