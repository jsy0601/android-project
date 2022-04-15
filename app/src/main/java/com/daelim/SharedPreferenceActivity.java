package com.daelim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPreferenceActivity extends AppCompatActivity {
    private EditText et_text;
    private Button bt_save, bt_check;
    private SharedPreferences sp;
    private AlertDialog ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        et_text = findViewById(R.id.et_text);
        bt_save = findViewById(R.id.bt_save);
        bt_check = findViewById(R.id.bt_check);

        sp = getSharedPreferences("text", MODE_PRIVATE);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor e = sp.edit();
                e.putString("key", et_text.getText().toString());
                e.commit();
                et_text.setText("");
            }
        });

        bt_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = sp.getString("key", "");
                Log.e("!!!", "" + s);
                AlertDialog.Builder ab = new AlertDialog.Builder(SharedPreferenceActivity.this);
                ab.setTitle("값 확인");
                ab.setMessage(s);
                ab.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                ad = ab.create();
                ad.show();
            }
        });
    }
}