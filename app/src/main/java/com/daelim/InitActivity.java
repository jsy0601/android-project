package com.daelim;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InitActivity extends AppCompatActivity {
    private InitActivity activity;

    private static final int REQUEST_CODE = 777; //상수값을 선언

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
                startActivityForResult(intent, REQUEST_CODE);
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
        Button list = findViewById(R.id.bt_list);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ListActivity.class);
                startActivity(intent);
            }
        });
        Button listcustom = findViewById(R.id.bt_listcustom);
        listcustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ListCustomActivity.class);
                startActivity(intent);
            }
        });
        Button sp = findViewById(R.id.bt_sharedpreference);
        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, SharedPreferenceActivity.class);
                startActivity(intent);
            }
        });
        Button call = findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:01012345678"));
                startActivity(i);
            }
        });
        Button web = findViewById(R.id.web);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, WebActivity.class);
                startActivity(intent);
            }
        });
        Button service = findViewById(R.id.service);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ServiceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Toast.makeText(activity, "NEXT 수신 성공", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(activity, "NEXT 수신 실패", Toast.LENGTH_SHORT).show();
        }

        if(requestCode == REQUEST_CODE) {
            String resultTxt = data.getStringExtra("data");
            Log.e("!!!", "" + resultTxt);
        }
    }
}
