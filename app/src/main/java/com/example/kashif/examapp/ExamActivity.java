package com.example.kashif.examapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kashif.examapp.data.model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ExamActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference ref;
    ArrayList<Question> questions;
    private TextView tvQuestionText;
    private Button btnAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        initialize();

        Toast.makeText(ExamActivity.this, "we are in the main activity",
                Toast.LENGTH_LONG).show();

        //database reference
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("exam1");


        Log.v("DB","GOT THE REFERENCE &*#&(#&$(@*$&#(*$&#(*$&#($&");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Log.d("DB#@*$&(#&$(","GOING INSIDE");
                    for(DataSnapshot childDatasnapShot : dataSnapshot.getChildren()){
                        Question question = childDatasnapShot.getValue(Question.class);
                        questions.add(question);
                    }
                }else{
                    Log.d("DB#@*$&(#&$(","NOT GOING INSIDE");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void initialize() {
        questions = new ArrayList<>();
        tvQuestionText = findViewById(R.id.tvQuestionText);
        btnAction = findViewById(R.id.btnAction);

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                switch (view.getId()){
//                    case R.id.btnAction:
//
//                        break;
//                }
//                Update user answer
//                Question currentQuestion = questions.get(0);
//                currentQuestion.setUsersAnswer(1);
                tvQuestionText.setText("Text New");

                Intent intent = new Intent(ExamActivity.this,ExamResultActivity.class);
                intent.putExtra("ANSWERS_QUESTIONS",questions);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Please Logout!",Toast.LENGTH_SHORT);
    }
}
