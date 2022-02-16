package com.example.quizappriinvest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView oA, oB, oC, oD;
    private TextView qNR, question, score;
    private TextView ch1, ch2;
    int currentindex;
    int mscore = 0;
    int qn = 1;
    ProgressBar progressBar;

    int currentQuestion, coA, coB, coC, coD;

    private Answers[] questions = new Answers[]
            {
                    new Answers(R.string.question_0_A,R.string.question_0_B, R.string.question_0_C,R.string.question_0_D,R.string.question_0, R.string.question_0_answer),
                    new Answers(R.string.question_1_A,R.string.question_1_B, R.string.question_1_C,R.string.question_1_D,R.string.question_1, R.string.question_1_answer),
                    new Answers(R.string.question_2_A,R.string.question_2_B, R.string.question_2_C,R.string.question_2_D,R.string.question_2,R.string.question_2_answer),
                    new Answers(R.string.question_3_A,R.string.question_3_B, R.string.question_3_C,R.string.question_3_D,R.string.question_3, R.string.question_3_answer),
                    new Answers(R.string.question_4_A,R.string.question_4_B, R.string.question_4_C,R.string.question_4_D,R.string.question_4,R.string.question_4_answer),
                    new Answers(R.string.question_5_A,R.string.question_5_B, R.string.question_5_C,R.string.question_5_D,R.string.question_5, R.string.question_5_answer),
                    new Answers(R.string.question_6_A,R.string.question_6_B, R.string.question_6_C,R.string.question_6_D,R.string.question_6, R.string.question_6_answer),
                    new Answers(R.string.question_7_A,R.string.question_7_B, R.string.question_7_C,R.string.question_7_D,R.string.question_7, R.string.question_7_answer),
                    new Answers(R.string.question_8_A,R.string.question_8_B, R.string.question_8_C,R.string.question_8_D,R.string.question_8, R.string.question_8_answer),
                    new Answers(R.string.question_9_A,R.string.question_9_B, R.string.question_9_C,R.string.question_9_D,R.string.question_9, R.string.question_9_answer),

            };

    final int Progress_Bar = (int) Math.ceil(100/questions.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oA=findViewById(R.id.optionA);
        oB=findViewById(R.id.optionB);
        oC=findViewById(R.id.optionC);
        oD=findViewById(R.id.optionD);

        question=findViewById(R.id.question);
        score = findViewById(R.id.score);
        qNR=findViewById(R.id.QNumber);

        ch1 = findViewById(R.id.selectoption);
        ch2=findViewById(R.id.correct);

        progressBar = findViewById(R.id.progressbar);

        currentQuestion = questions[currentindex].getqID();
        question.setText(currentQuestion);
        coA = questions[currentindex].getoA();
        oA.setText(coA);
        coB = questions[currentindex].getoB();
        oB.setText(coB);
        coC = questions[currentindex].getoC();
        oC.setText(coC);
        coD = questions[currentindex].getoD();
        oD.setText(coD);

        oA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(coA);
                updateQuestion();

            }
        });
        oB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(coB);
                updateQuestion();

            }
        });
        oC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(coC);
                updateQuestion();

            }
        });
        oD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(coD);
                updateQuestion();

            }
        });
    }

    private void checkAnswer(int selection) {

        int correctans = questions[currentindex].getaID();
        ch1.setText(selection);
        ch2.setText(correctans);

        String one = ch1.getText().toString().trim();
        String two = ch2.getText().toString().trim();
        if (one.equals(two)) {
            Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
            mscore = mscore + 1;
        }
        else{
            Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();

        }
    }

    @SuppressLint("SetTextI18n")
    private void updateQuestion() {

        currentindex = (currentindex+1)%questions.length;

        if(currentindex==0){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score: " + mscore + " out of "+questions.length + " were right!");
            alert.setPositiveButton("Close App", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    score.setText("Score: " +mscore+ "/"+questions.length);
                    qNR.setText("Question: " + qn + "/" + questions.length );
                }
            });
            alert.show();
        }

        currentQuestion = questions[currentindex].getqID();
        question.setText(currentQuestion);
        coA = questions[currentindex].getoA();
        oA.setText(coA);
        coB = questions[currentindex].getoB();
        oB.setText(coB);
        coC = questions[currentindex].getoC();
        oC.setText(coC);
        coD = questions[currentindex].getoD();
        oD.setText(coD);

        qn =qn+1;
        if(qn<=questions.length){
            qNR.setText("Question: " + qn + "/" + questions.length );
        }
        score.setText("Score: " +mscore+ "/"+questions.length);
        progressBar.incrementProgressBy(Progress_Bar);
    }
}