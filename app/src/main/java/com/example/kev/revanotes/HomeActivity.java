package com.example.kev.revanotes;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
        ImageView splashimg;
        private static int SPLASH_TIME_OUT=700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Animation up= AnimationUtils.loadAnimation(this,R.anim.up_to_down);

        splashimg=findViewById(R.id.splash);
        splashimg.setAnimation(up);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent=new Intent(HomeActivity.this,MainActivity.class);
                startActivity(homeintent);
                finish();
            }

        },SPLASH_TIME_OUT);


    }
}

