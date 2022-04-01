package com.daelim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    private NextActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        activity = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button pre = findViewById(R.id.bt_pre);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("data", "00000");
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent();
        i.putExtra("data", "00000");
        startActivityForResult(i,5);
        setResult(RESULT_OK, i);
        finish();
    }
}
