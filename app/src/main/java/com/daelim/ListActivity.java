package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lv_data = findViewById(R.id.lv_data);
        ArrayList<String> data = new ArrayList<>();
        data.add("abc");
        data.add("가나다");
        data.add("1234");
        data.add("하하하");
        data.add("호호호");
        data.add("ㅋㅋㅋㅋㅋㅋ");
        data.add("ㅋㅋㅋㅋ");
        data.add("ㅋㅋ");
        data.add("ㅋ");
        data.add("ㅋㅋㅋㅋㅋㅋㅋ");
        lv_data.setAdapter(new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, data));
    }
}