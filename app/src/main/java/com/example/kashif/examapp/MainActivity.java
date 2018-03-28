package com.example.kashif.examapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "we are in the main activity",
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
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        Map<String,Object> map = (Map<String,Object>) ds.getValue();
                        Toast.makeText(MainActivity.this, map.get("_answer").toString(), Toast.LENGTH_SHORT).show();
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
}
