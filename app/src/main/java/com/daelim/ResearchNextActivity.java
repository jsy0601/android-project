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

public class ResearchNextActivity extends AppCompatActivity {

    private CheckBox cb_a, cb_b, cb_c;
    private String preData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research_next);

        preData = getIntent().getStringExtra("data");
        Log.e("!!!", "" + preData);

        cb_a = findViewById(R.id.cb_a);
        cb_b = findViewById(R.id.cb_b);
        cb_c = findViewById(R.id.cb_c);

        Button bt_next = findViewById(R.id.bt_next);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("!!!", "cb_a : " + cb_a.isChecked());
                Log.e("!!!", "cb_b : " + cb_b.isChecked());
                Log.e("!!!", "cb_c : " + cb_c.isChecked());

                String str = "";
                if (cb_a.isChecked()) {
                    str = str + "케찹";
                }
                if (cb_b.isChecked()) {
                    if (str.length() > 0) {
                        str = str + ", 스윗 칠리";
                    } else {
                        str = str + "스윗 칠리";
                    }
                }
                if (cb_c.isChecked()) {
                    if (str.length() > 0) {
                        str = str + ", 스윗 어니언";
                    } else {
                        str = str + "스윗 어니언";
                    }
                }
                Intent intent = new Intent(ResearchNextActivity.this, ResearchNextActivity2.class);
                intent.putExtra("data", str);
                startActivity(intent);
                finish();
            }
        });
    }
}