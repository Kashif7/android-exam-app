package com.example.kashif.examapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.kashif.examapp.data.model.Question;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ExamResultActivity extends AppCompatActivity {
    private ArrayList<Question> answeredQuestions;
    private int correctCount;
    private int markPerQuestion;
    private int marks;
    private Button viewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result);

        markPerQuestion = 1;
        correctCount = 0;

        answeredQuestions = (ArrayList<Question>) getIntent().getSerializableExtra("ANSWERS_QUESTIONS");

        initialize();
    }

    private void initialize() {
        for (Question question: answeredQuestions) {
            if (question.getCorrectAnswer() == question.getUsersAnswer()) {
                correctCount += correctCount;
            }
        }

        marks = correctCount * markPerQuestion;
        Log.d("sfuwhwf", ""+marks);

        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
