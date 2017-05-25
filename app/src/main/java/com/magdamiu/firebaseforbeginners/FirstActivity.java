package com.magdamiu.firebaseforbeginners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void btnSignIn_onClick(View view) {
        startActivity(new Intent(FirstActivity.this, GoogleSignInActivity.class));
    }

    public void btnRealtime_onClick(View view) {
        startActivity(new Intent(FirstActivity.this, RealtimeDatabaseActivity.class));
    }
}
