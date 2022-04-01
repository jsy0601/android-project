package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ResearchActivity extends AppCompatActivity {

    private CheckBox cb_a, cb_b, cb_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);

        cb_a = findViewById(R.id.cb_a);
        cb_b = findViewById(R.id.cb_b);
        cb_c = findViewById(R.id.cb_c);

        cb_a.setChecked(true);

        Button bt_next = findViewById(R.id.bt_next);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("!!!", "cb_a : " + cb_a.isChecked());
                Log.e("!!!", "cb_b : " + cb_b.isChecked());
                Log.e("!!!", "cb_c : " + cb_c.isChecked());

                String str = "";
                if (cb_a.isChecked()) {
                    str = str + "사과";
                }
                if (cb_b.isChecked()) {
                    if (str.length() > 0) {
                        str = str + ", 배";
                    } else {
                        str = str + "배";
                    }
                }
                if (cb_c.isChecked()) {
                    if (str.length() > 0) {
                        str = str + ", 귤";
                    } else {
                        str = str + "귤";
                    }
                }

                Intent intent = new Intent(ResearchActivity.this, ResearchNextActivity.class);
                intent.putExtra("data", str);
                startActivity(intent);
                finish();
            }
        });
    }
}