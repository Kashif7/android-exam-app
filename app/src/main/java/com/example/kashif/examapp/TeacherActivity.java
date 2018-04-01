package com.example.kashif.examapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonString = questionString.getText().toString();
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            Log.d("DB#@*$&(#&$(", "GOING INSIDE");
                            noOfQuestions = dataSnapshot.getChildrenCount();
                            Log.d("dvkdokd", "no of questions" + noOfQuestions);
                            Question question = gson.fromJson(jsonString, Question.class);
                            newIndex = noOfQuestions + 1;
                            ref.child("q" + newIndex).setValue(question);
                            createAlert();
                            questionString.setText("");
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

    private void createAlert() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(TeacherActivity.this);
        builder1.setMessage("Your question was successfully added");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
}
