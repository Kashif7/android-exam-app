package com.example.kashif.examapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kashif.examapp.data.model.Question;
import com.example.kashif.examapp.ui.adapter.ExamResultDetailAdapter;

import java.util.ArrayList;

public class ExamResultDetailActivity extends AppCompatActivity {

    private ArrayList<Question> answeredQuestions;
    private RecyclerView recyclerView;
    private ExamResultDetailAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result_detail);

        answeredQuestions = (ArrayList<Question>) getIntent().getSerializableExtra("ANSWERS_QUESTIONS");

        recyclerView = findViewById(R.id.recycler_view);

        mAdapter = new ExamResultDetailAdapter(answeredQuestions);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
