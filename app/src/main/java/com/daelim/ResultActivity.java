package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private String preData1, preData2, preData3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        preData3 = getIntent().getStringExtra("cheese");
        Log.e("!!!", "" + preData3);


        preData1 = getIntent().getStringExtra("bread");
        TextView tv_bread = findViewById(R.id.tv_bread);
        tv_bread.setText(preData1);
        preData2 = getIntent().getStringExtra("sauce");
        TextView tv_sauce = findViewById(R.id.tv_sauce);
        tv_sauce.setText(preData2);
        preData3 = getIntent().getStringExtra("cheese");
        TextView tv_cheese = findViewById(R.id.tv_cheese);
        tv_cheese.setText(preData3);
    }
}