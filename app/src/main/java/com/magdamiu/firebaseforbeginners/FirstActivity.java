package com.magdamiu.firebaseforbeginners;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class FirstActivity extends AppCompatActivity {

    private ImageView firebaseImageView;
    private static final String FIREBASE_IMAGE_URL = "https://1.bp.blogspot.com/-YIfQT6q8ZM4/Vzyq5z1B8HI/AAAAAAAAAAc/UmWSSMLKtKgtH7CACElUp12zXkrPK5UoACLcB/s1600/image00.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        firebaseImageView = (ImageView) findViewById(R.id.iv_firebase);
        //set the image from the url using Picasso library
        Picasso.with(FirstActivity.this)
                .load(FIREBASE_IMAGE_URL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(firebaseImageView);
    }

    public void btnSignIn_onClick(View view) {
        startActivity(new Intent(FirstActivity.this, GoogleSignInActivity.class));
    }

    public void btnRealtime_onClick(View view) {
        startActivity(new Intent(FirstActivity.this, RealtimeDatabaseActivity.class));
    }
}
