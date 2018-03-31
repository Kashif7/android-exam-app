package com.example.kashif.examapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    private TextView questionCount;
    private Button btnAction;
    private RadioGroup radioGroup;
    private RadioButton answer1;
    private RadioButton answer2;
    private RadioButton answer3;
    private RadioButton answer4;
    private boolean isAnswered;
    private boolean isSubmitted;
    private boolean isAnsweredAll;
    Question currentQuestion;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        index = 0;
        questions = new ArrayList<>();

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
                        Log.d("the question text", questions.get(0).getQuestionText());
                    }
                    initialize();
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
        tvQuestionText = findViewById(R.id.tvQuestionText);
        questionCount = findViewById(R.id.tvQuestionPos);
        radioGroup = findViewById(R.id.RG1);
        answer1 = findViewById(R.id.rbAnswerOne);
        answer2 = findViewById(R.id.rbAnswerTwo);
        answer3 = findViewById(R.id.rbAnswerThree);
        answer4 = findViewById(R.id.rbAnswerFour);

        btnAction = findViewById(R.id.btnAction);
        btnAction.setEnabled(false);

        Log.d("DB#@*$&(#&$(","inside intialize");
        currentQuestion = questions.get(index);
        Log.d("DB#@*$&(#&$(","text set");

        int count = index+1;
        questionCount.setText(""+count+"/"+questions.size());

        tvQuestionText.setText(currentQuestion.getQuestionText());
        answer1.setText(currentQuestion.getAnswerOptionOne());
        answer2.setText(currentQuestion.getAnswerOptionTwo());
        answer3.setText(currentQuestion.getAnswerOptionThree());
        answer4.setText(currentQuestion.getAnswerOptionFour());


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuestion.setUsersAnswer(1);
                btnAction.setText("submit");
                btnAction.setEnabled(true);
                isAnswered = true;

                if (questions.size()-1 == index) {
                    btnAction.setText("Finish");
                    isAnsweredAll = true;
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAnswered = true;
                btnAction.setText("submit");
                btnAction.setEnabled(true);
                currentQuestion.setUsersAnswer(2);

                if (questions.size()-1 == index) {
                    btnAction.setText("Finish");
                    isAnsweredAll = true;
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAnswered = true;
                btnAction.setText("submit");
                btnAction.setEnabled(true);
                currentQuestion.setUsersAnswer(3);

                if (questions.size()-1 == index) {
                    btnAction.setText("Finish");
                    isAnsweredAll = true;
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAnswered = true;
                btnAction.setText("submit");
                btnAction.setEnabled(true);
                currentQuestion.setUsersAnswer(4);

                if (questions.size()-1 == index) {
                    btnAction.setText("Finish");
                    isAnsweredAll = true;
                    Log.d("the last question", "last question");
                }
            }
        });

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnsweredAll) {
                    Toast.makeText(getApplicationContext(), "jfiejeifje", Toast.LENGTH_SHORT);
                    Intent intent = new Intent(ExamActivity.this,ExamResultActivity.class);
                    intent.putExtra("ANSWERS_QUESTIONS",questions);
                    startActivity(intent);
                } else if (isSubmitted) {
                    index++;
                    int count = index+1;
                    questionCount.setText(""+count+"/"+questions.size());
                    isSubmitted = false;
                    btnAction.setText("Submit");
                    radioGroup.clearCheck();
                    btnAction.setEnabled(false);

                    currentQuestion = questions.get(index);

                    tvQuestionText.setText(currentQuestion.getQuestionText());
                    answer1.setText(currentQuestion.getAnswerOptionOne());
                    answer2.setText(currentQuestion.getAnswerOptionTwo());
                    answer3.setText(currentQuestion.getAnswerOptionThree());
                    answer4.setText(currentQuestion.getAnswerOptionFour());
                }else if (isAnswered) {
                    btnAction.setText("Go to Next");

                    if (currentQuestion.getUsersAnswer() == currentQuestion.getCorrectAnswer()) {
                    }

                    isSubmitted = true;
                }
            }
        });
    }


    @Override
    public void onBackPressed() {Toast.makeText(this,"Please Logout!",Toast.LENGTH_SHORT).show();

    }
}
