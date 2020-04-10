package com.example.neera.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bsh.EvalError;
import bsh.Interpreter;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEquals, buttonDot, buttonClear;
    TextView twAnswer, twEnterText;

    /*Double ValueOne = Double.NaN;
    Double ValueTwo;
    Double Answer = Double.NaN;

    char ch;

    private void Calculate() {
        if (!Double.isNaN(ValueOne)) {
            ValueTwo = Double.parseDouble(twEnterText.getText().toString());
            //twAnswer.setText(twAnswer.getText().toString() + ch + Double.toString(ValueTwo));
            if (ch == '+') {
                ValueOne = ValueOne + ValueTwo;
            } else if (ch == '-') {
                ValueOne = ValueOne - ValueTwo;
            } else if (ch == '*') {
                ValueOne = ValueOne * ValueTwo;
            } else if (ch == '/') {
                ValueOne = ValueOne / ValueTwo;
            } else {
            }
            Answer = ValueOne;
            twEnterText.setText(null);
        } else {
            ValueOne = Double.parseDouble(twEnterText.getText().toString());
            twEnterText.setText(null);
            //twAnswer.setText(Double.toString(ValueOne) + ch);
        }

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twEnterText = findViewById(R.id.EnterText);
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


        View.OnClickListener onButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button0:
                        twEnterText.setText(twEnterText.getText() + "0");
                        break;

                    case R.id.button1:
                        twEnterText.setText(twEnterText.getText() + "1");
                        break;

                    case R.id.button2:
                        twEnterText.setText(twEnterText.getText() + "2");
                        break;

                    case R.id.button3:
                        twEnterText.setText(twEnterText.getText() + "3");
                        break;

                    case R.id.button4:
                        twEnterText.setText(twEnterText.getText() + "4");
                        break;

                    case R.id.button5:
                        twEnterText.setText(twEnterText.getText() + "5");
                        break;

                    case R.id.button6:
                        twEnterText.setText(twEnterText.getText() + "6");
                        break;

                    case R.id.button7:
                        twEnterText.setText(twEnterText.getText() + "7");
                        break;

                    case R.id.button8:
                        twEnterText.setText(twEnterText.getText() + "8");
                        break;

                    case R.id.button9:
                        twEnterText.setText(twEnterText.getText() + "9");
                        break;

                    case R.id.buttonDot:
                        twEnterText.setText(twEnterText.getText() + ".");
                        break;

                    case R.id.buttonAdd:
                        twEnterText.setText(twEnterText.getText() + "+");
                       /* Calculate();
                        ch = '+';
                        if (Double.isNaN(Answer)) {

                        } else {
                            twAnswer.setText(Double.toString(Answer));
                        }*/
                        break;

                    case R.id.buttonSub:
                        twEnterText.setText(twEnterText.getText() + "-");
                        /*Calculate();
                        ch = '-';
                        if (Double.isNaN(Answer)) {

                        } else {
                            twAnswer.setText(Double.toString(Answer));
                        }*/
                        break;

                    case R.id.buttonMul:
                        twEnterText.setText(twEnterText.getText() + "*");
                        /*Calculate();
                        ch = '*';
                        if (Double.isNaN(Answer)) {

                        } else {
                            twAnswer.setText(Double.toString(Answer));
                        }*/
                        break;

                    case R.id.buttonDiv:
                        twEnterText.setText(twEnterText.getText() + "/");
                        /*Calculate();
                        ch = '/';
                        if (Double.isNaN(Answer)) {

                        } else {
                            twAnswer.setText(Double.toString(Answer));
                        }*/
                        break;

                    case R.id.buttonEquals:
                        Interpreter interpreter = new Interpreter();
                        try {
                            interpreter.eval("result = " + twEnterText.getText());
                            twAnswer.setText(interpreter.get("result").toString());
                        } catch (EvalError evalError) {
                            evalError.printStackTrace();
                        }
                        break;

                    case R.id.buttonClear:
                        twAnswer.setText(null);
                        twEnterText.setText(null);
                        //ValueOne = Double.NaN;
                        //Answer = Double.NaN;
                        break;
                }
            }
        };

        button0.setOnClickListener(onButtonClickListener);
        button1.setOnClickListener(onButtonClickListener);
        button2.setOnClickListener(onButtonClickListener);
        button3.setOnClickListener(onButtonClickListener);
        button4.setOnClickListener(onButtonClickListener);
        button5.setOnClickListener(onButtonClickListener);
        button6.setOnClickListener(onButtonClickListener);
        button7.setOnClickListener(onButtonClickListener);
        button8.setOnClickListener(onButtonClickListener);
        button9.setOnClickListener(onButtonClickListener);
        buttonDot.setOnClickListener(onButtonClickListener);
        buttonAdd.setOnClickListener(onButtonClickListener);
        buttonSub.setOnClickListener(onButtonClickListener);
        buttonMul.setOnClickListener(onButtonClickListener);
        buttonDiv.setOnClickListener(onButtonClickListener);
        buttonEquals.setOnClickListener(onButtonClickListener);
        buttonClear.setOnClickListener(onButtonClickListener);

        /*button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + "9");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twEnterText.setText(twEnterText.getText() + ".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
                ch = '+';
                twAnswer.setText(Double.toString(ValueOne) + "+");
                twEnterText.setText(null);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
                ch = '-';
                twAnswer.setText(Double.toString(ValueOne) + "-");
                twEnterText.setText(null);
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
                ch = '*';
                twAnswer.setText(Double.toString(ValueOne) + "*");
                twEnterText.setText(null);
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
                ch = '/';
                twAnswer.setText(Double.toString(ValueOne) + "/");
                twEnterText.setText(null);
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
        });*/

        /*Interpreter interpreter = new Interpreter();
            try {
                interpreter.eval("result = (7+21*6)/(32-27)");
                twAnswer.setText(interpreter.get("result").toString());
            } catch (EvalError evalError) {
                evalError.printStackTrace();
            }*/


    }

}
