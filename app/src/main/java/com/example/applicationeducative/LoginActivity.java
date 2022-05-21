package com.example.applicationeducative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.widget.Button;

import com.example.applicationeducative.Home;

public class LoginActivity extends AppCompatActivity {

    Button callSignUp,loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        callSignUp = findViewById(R.id.signuptobtn);
        loginBtn = findViewById(R.id.loginbtn);

        callSignUp.setOnClickListener((view) -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
        });

        loginBtn.setOnClickListener((view) -> {
            Intent intent = new Intent(LoginActivity.this, Home.class);
            startActivity(intent);
            finish();
        });
    }
}