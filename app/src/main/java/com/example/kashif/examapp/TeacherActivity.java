package com.example.kashif.examapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.MalformedJsonException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kashif.examapp.data.model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

public class TeacherActivity extends AppCompatActivity {
    private EditText questionString;
    private String jsonString;
    private Button add;
    private Gson gson;
    FirebaseDatabase db;
    DatabaseReference ref;
    Long noOfQuestions;
    Long newIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("exam1");

        initialize();
    }

    private void initialize() {
        questionString = findViewById(R.id.question);
        add = findViewById(R.id.add);
        gson = new Gson();

        jsonString = questionString.getText().toString();
        jsonString = "{questionText:Iamawesome," +
                "answerOptionOne:feffkefe," +
                "answerOptionTwo:ddmdmd," +
                "answerOptionThree:ejeifejfeif," +
                "answerOptionFour:ffijefjiewf," +
                "correctAnswer:" + 1 + "}";

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            Log.d("DB#@*$&(#&$(", "GOING INSIDE");
                            noOfQuestions = dataSnapshot.getChildrenCount();
                            Log.d("dvkdokd", "no of questions" + noOfQuestions);
                            Question question = gson.fromJson(jsonString, Question.class);
                            newIndex = noOfQuestions+1;
                            ref.child("q" + newIndex).setValue(question);
                            Log.d("DB#@*$&(#&$(", "went inside");
                        } else {
                            Log.d("DB#@*$&(#&$(", "NOT GOING INSIDE");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
