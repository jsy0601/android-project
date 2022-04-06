package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ResearchActivity extends AppCompatActivity {

    private RadioGroup rg_content;
    private RadioButton rb_1, rb_2, rb_3;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);

        rb_1 = findViewById(R.id.rb_1);
        rb_2 = findViewById(R.id.rb_2);
        rb_3 = findViewById(R.id.rb_3);
        rg_content = findViewById(R.id.rg_content);
        rg_content.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_1:
                        Toast.makeText(ResearchActivity.this, "화이트를 선택했습니다.", Toast.LENGTH_SHORT).show();
                        str = rb_1.getText().toString();
                        break;
                    case R.id.rb_2:
                        Toast.makeText(ResearchActivity.this, "파마산 오레가노를 선택했습니다.", Toast.LENGTH_SHORT).show();
                        str = rb_2.getText().toString();
                        break;
                    case R.id.rb_3:
                        Toast.makeText(ResearchActivity.this, "휘트를 선택했습니다.", Toast.LENGTH_SHORT).show();
                        str = rb_3.getText().toString();
                        break;
                }
            }
        });

        Button bt_next = findViewById(R.id.bt_next);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResearchActivity.this, ResearchNextActivity.class);
                intent.putExtra("bread", str);
                startActivity(intent);
                finish();
            }
        });
    }
}