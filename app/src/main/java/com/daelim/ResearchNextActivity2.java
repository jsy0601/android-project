package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ResearchNextActivity2 extends AppCompatActivity {

    private RadioGroup rg_content;
    private RadioButton rb_1, rb_2, rb_3;
    private String str;
    private String preData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research_next2);

        preData = getIntent().getStringExtra("data");
        Log.e("!!!", "" + preData);

        rb_1 = findViewById(R.id.rb_1);
        rb_2 = findViewById(R.id.rb_2);
        rb_3 = findViewById(R.id.rb_3);
        rg_content = findViewById(R.id.rg_content);
        rg_content.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_1:
                        Toast.makeText(ResearchNextActivity2.this, "아메리칸 치즈를 선택했습니다.", Toast.LENGTH_SHORT).show();
                        str = rb_1.getText().toString();
                        break;
                    case R.id.rb_2:
                        Toast.makeText(ResearchNextActivity2.this, "모차렐라 치즈를 선택했습니다.", Toast.LENGTH_SHORT).show();
                        str = rb_2.getText().toString();
                        break;
                    case R.id.rb_3:
                        Toast.makeText(ResearchNextActivity2.this, "치즈 제외를 선택했습니다.", Toast.LENGTH_SHORT).show();
                        str = rb_3.getText().toString();
                        break;
                }
            }
        });

        Button bt_result = findViewById(R.id.bt_result);
        bt_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResearchNextActivity2.this, ResultActivity.class);
                intent.putExtra("data", str);
                startActivity(intent);
                finish();
            }
        });
    }
}