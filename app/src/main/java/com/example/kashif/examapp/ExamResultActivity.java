package com.example.kashif.examapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kashif.examapp.data.model.Question;

import java.util.ArrayList;

public class ExamResultActivity extends AppCompatActivity {
    private ArrayList<Question> answeredQuestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result);

        answeredQuestions = (ArrayList<Question>) getIntent().getSerializableExtra("ANSWERS_QUESTIONS");
    }
}
