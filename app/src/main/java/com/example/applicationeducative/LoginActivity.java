package com.example.applicationeducative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.applicationeducative.Home;
import com.google.android.material.textfield.TextInputLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.Objects;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends AppCompatActivity {
    private static AsyncHttpClient client;
    Button callSignUp,loginBtn;
    TextInputLayout semail, spassword;

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



        client = new AsyncHttpClient();

        semail = findViewById(R.id.email);
        spassword = findViewById(R.id.password);

        loginBtn.setOnClickListener((view) -> {
            RequestParams params = new RequestParams();
            params.put("email", Objects.requireNonNull(semail.getEditText()).getText().toString());
            params.put("password", Objects.requireNonNull(spassword.getEditText()).getText().toString());
            client.post("https://app-mobilechild.herokuapp.com/api/authenticate/", params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    if (statusCode == 200) {
                        Intent intent = new Intent(LoginActivity.this, Home.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(LoginActivity.this, "Veuillez verifier vos donnes",
                                Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Toast.makeText(LoginActivity.this, "Veuillez verifier vos donnes",
                            Toast.LENGTH_LONG).show();
                }
            });

        });
    }
}