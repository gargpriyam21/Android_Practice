package com.example.neera.friendsquiz.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.neera.friendsquiz.Data.Questions;
import com.example.neera.friendsquiz.HistoryDB.HistoryDBHelper;
import com.example.neera.friendsquiz.HistoryDB.Model.HistoryData;
import com.example.neera.friendsquiz.HistoryDB.Tables.HistoryTable;
import com.example.neera.friendsquiz.MainActivity;
import com.example.neera.friendsquiz.R;
import com.github.lzyzsd.circleprogress.DonutProgress;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Activity_Quiz extends AppCompatActivity {

    Button btnChoice1, btnChoice2, btnChoice3, btnChoice4, btnPlayAgain, btnQuit, btn, btnCorrect;
    DonutProgress pbScore;
    TextView tvScore, tvQuestion, tvProgressText;
    Random r;
    Handler handler = new Handler();
    private Questions questions = new Questions();
    private int Counter = 0;
    private int Score = 0;
    private boolean isCorrect = false;
    private String Answer;
    private int QuestionLength = questions.Question.length;
    private ArrayList<Integer> random = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        r = new Random();

        btnChoice1 = (Button) findViewById(R.id.btnChoice1);
        btnChoice2 = (Button) findViewById(R.id.btnChoice2);
        btnChoice3 = (Button) findViewById(R.id.btnChoice3);
        btnChoice4 = (Button) findViewById(R.id.btnChoice4);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        tvScore = (TextView) findViewById(R.id.tvScore);

        tvScore.setText("Score: " + Score);

        updateQuestion(URandom(QuestionLength));

        View.OnClickListener onButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.btnChoice1:
                        if (btnChoice1.getText() == Answer) {
                            Score++;
                            tvScore.setText("Score: " + Score);
                            isCorrect = true;
                        }
                        btn = btnChoice1;
                        Counter++;
                        break;
                    case R.id.btnChoice2:
                        if (btnChoice2.getText() == Answer) {
                            Score++;
                            tvScore.setText("Score: " + Score);
                            isCorrect = true;
                        }
                        btn = btnChoice2;
                        Counter++;
                        break;
                    case R.id.btnChoice3:
                        if (btnChoice3.getText() == Answer) {
                            Score++;
                            tvScore.setText("Score: " + Score);
                            isCorrect = true;
                        }
                        btn = btnChoice3;
                        Counter++;
                        break;
                    case R.id.btnChoice4:
                        if (btnChoice4.getText() == Answer) {
                            Score++;
                            tvScore.setText("Score: " + Score);
                            isCorrect = true;
                        }
                        btn = btnChoice4;
                        Counter++;
                        break;
                }
                setButton(btn, isCorrect);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (Counter != 5) {
                            btn.setBackground(getResources().getDrawable(R.drawable.button_normal));
                            updateQuestion(URandom(QuestionLength));

                        } else {
                            random = new ArrayList<>();
                            btn.setBackground(getResources().getDrawable(R.drawable.button_normal));
                            gameOver();
                        }
                    }
                }, 500);
            }
        };

        btnChoice1.setOnClickListener(onButtonClickListener);
        btnChoice2.setOnClickListener(onButtonClickListener);
        btnChoice3.setOnClickListener(onButtonClickListener);
        btnChoice4.setOnClickListener(onButtonClickListener);

    }

    private void updateQuestion(int num) {
        isCorrect = false;
        tvQuestion.setText(questions.getQuestion(num));
        btnChoice1.setText(questions.getChoices(num, 0));
        btnChoice2.setText(questions.getChoices(num, 1));
        btnChoice3.setText(questions.getChoices(num, 2));
        btnChoice4.setText(questions.getChoices(num, 3));
        Answer = questions.getAnswer(num);
    }

    private void gameOver() {

        updateHistory(Score + "/5");

        setContentView(R.layout.view_gameover);
        btnPlayAgain = (Button) findViewById(R.id.btnPlayAgain);
        btnQuit = (Button) findViewById(R.id.btnQuit);
        pbScore = (DonutProgress) findViewById(R.id.pbScore);
        tvProgressText = (TextView) findViewById(R.id.tvProgressText);
        tvProgressText.setText("Score:\n" + Score + "/5");
        pbScore.setProgress(Score * 20);

        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("play", 1);
                startActivity(i);
                finish();
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setButton(Button btn, boolean isCorrect) {
        if (isCorrect) {
            btn.setBackground(getResources().getDrawable(R.drawable.button_correct));
        } else {
            btn.setBackground(getResources().getDrawable(R.drawable.button_wrong));
            if (btnChoice1.getText().equals(Answer)) {
                btnCorrect = btnChoice1;
            } else if (btnChoice2.getText().equals(Answer)) {
                btnCorrect = btnChoice2;
            } else if (btnChoice3.getText().equals(Answer)) {
                btnCorrect = btnChoice3;
            } else if (btnChoice4.getText().equals(Answer)) {
                btnCorrect = btnChoice4;
            }
            btnCorrect.setBackground(getResources().getDrawable(R.drawable.button_correct));
            handler.postDelayed(new Runnable() {
                public void run() {
                    btnCorrect.setBackground(getResources().getDrawable(R.drawable.button_normal));
                }
            }, 500);
        }
    }

    private int URandom(int length) {
        int num = r.nextInt(length);
        for (int i = 0; i < random.size(); i++) {
            if (random.get(i) == num) {
                num = r.nextInt(length);
                i = -1;
            }
        }
        random.add(num);
        return num;
    }

    private void updateHistory(String Score) {
        Date curDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        String Date = dateFormat.format(curDate);

        SQLiteDatabase historyDb = new HistoryDBHelper(Activity_Quiz.this).getWritableDatabase();
        Activity_History.history = HistoryTable.getHistory(historyDb);

        HistoryTable.insertHistory(
                historyDb,
                new HistoryData(
                        Score,
                        Date
                )
        );

        Activity_History.history = HistoryTable.getHistory(historyDb);
    }
}
