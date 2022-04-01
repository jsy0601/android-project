package com.daelim;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {
    private SplashActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        activity = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(activity, InitActivity.class));
                finish();
            }
        },2000);
        super.onStart();
    }
}
