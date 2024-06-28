package com.app.trainbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {
    private TextView mTitle;
    Button  signup,signin;
    private ImageView img;
    private AlphaAnimation fadeout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);
        fadeout = new AlphaAnimation(0.0f, 1.0f);
//        mTitle = (TextView) findViewById(R.id.title);
        img = (ImageView) findViewById(R.id.imgg);
        img.startAnimation(fadeout);
//        mTitle.startAnimation(fadeout);

        fadeout.setDuration(6000);

        fadeout.setFillAfter(true);


        signin = findViewById(R.id.login);
        signup = findViewById(R.id.register);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), register.class);
                startActivity(intent);

            }
        });
    }
}