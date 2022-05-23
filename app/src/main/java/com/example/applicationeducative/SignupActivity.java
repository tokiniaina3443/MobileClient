package com.example.applicationeducative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.google.android.material.textfield.TextInputLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


import cz.msebera.android.httpclient.Header;

public class SignupActivity extends AppCompatActivity {
    private static AsyncHttpClient client;
    Button callLogin, signto;
    TextInputLayout semail, spassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);;

        callLogin = findViewById(R.id.logintobtn);

        callLogin.setOnClickListener((view) -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });


        client = new AsyncHttpClient();

        semail = findViewById(R.id.email);
        spassword = findViewById(R.id.password);
        signto = findViewById(R.id.signto);

        signto.setOnClickListener((view) -> {
            RequestParams params = new RequestParams();
            params.put("email", semail.getEditText().getText().toString());
            params.put("password", spassword.getEditText().getText().toString());
            client.post("https://app-mobilechild.herokuapp.com/api/register/", params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }
            });
        });
    }
}