package com.daelim;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InitActivity extends AppCompatActivity {
    private InitActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        activity = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button calc = findViewById(R.id.bt_calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CalActivity.class);
                startActivity(intent);
            }
        });
        Button next = findViewById(R.id.bt_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, NextActivity.class);
                startActivity(intent);
            }
        });
        Button survey = findViewById(R.id.bt_survey);
        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        data.getStringExtra("data");
    }
}
