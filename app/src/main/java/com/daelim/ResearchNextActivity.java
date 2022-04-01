package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ResearchNextActivity extends AppCompatActivity {

    private RadioGroup rg_content;
    private RadioButton rb_1, rb_2;

    private String preData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research_next);

        preData = getIntent().getStringExtra("data");
        Log.e("!!!", "" + preData);

        rb_1 = findViewById(R.id.rb_1);
        rb_2 = findViewById(R.id.rb_2);
        rg_content = findViewById(R.id.rg_content);

        rb_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResearchNextActivity.this, "rb_1 : " + rb_1.isChecked()+ ", rb_2 : " + rb_1.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        rg_content.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_3:
                        Toast.makeText(ResearchNextActivity.this, "도보를 선택했습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_4:
                        Toast.makeText(ResearchNextActivity.this, "자전거를 선택했습니다.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}