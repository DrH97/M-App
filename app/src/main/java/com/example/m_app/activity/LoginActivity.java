package com.example.m_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.m_app.R;

public class LoginActivity extends AppCompatActivity {

  Button btn_login_signup, btn_login_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_login_signup = findViewById(R.id.btn_login_signup);
        {
            btn_login_signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                }
            });
        }
        btn_login_login = findViewById(R.id.btn_login_login);

        {
            ///login logic here............

            btn_login_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            });
        }


    }


}
