package com.example.kashif.examapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kashif.examapp.data.model.Question;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ExamResultActivity extends AppCompatActivity {
    private ArrayList<Question> answeredQuestions;
    private int correctCount;
    private int markPerQuestion;
    private int marks;
    private int totalMarks;
    private String marksString;

    private Button finish;
    private TextView finalMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result);

        markPerQuestion = 1;
        correctCount = 0;

        answeredQuestions = (ArrayList<Question>) getIntent().getSerializableExtra("ANSWERED_QUESTIONS");

        initialize();
    }

    private void initialize() {
        finalMarks = findViewById(R.id.marks);
        finish = findViewById(R.id.finish);

        for (Question question : answeredQuestions) {
            if (question.getCorrectAnswer() == question.getUsersAnswer()) {
                Log.d("correct answer", ""+question.getUsersAnswer());
                correctCount++;
            }
        }

        marks = correctCount * markPerQuestion;
        totalMarks = answeredQuestions.size() * markPerQuestion;
        Log.d("sfuwhwf", "" + marks);

        marksString = "You have "+marks+" out of "+totalMarks;

        finalMarks.setText(marksString);


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),
                        LoginActivity.class));
            }
        });

    }
}
