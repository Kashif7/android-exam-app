package com.example.kashif.examapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userName, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userName.getText().toString().equals("student1") &&
                        password.getText().toString().equals("123")) {
                    startActivity(new Intent(getApplicationContext(),
                            MainActivity.class));

                } else if (userName.getText().toString().equals("teacher1") &&
                        password.getText().toString().equals("123")) {
                    startActivity(new Intent(getApplicationContext(),
                            TeacherActivity.class));
                }
            }
        });
    }
}
