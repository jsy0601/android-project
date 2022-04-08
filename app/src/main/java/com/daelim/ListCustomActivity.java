package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.daelim.Data.ListData;

import java.util.ArrayList;

public class ListCustomActivity extends AppCompatActivity {

    private ArrayList<ListData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_custom);
        list = new ArrayList<ListData>();
        list.add(new ListData("똘망", "1234-5678", true));
        list.add(new ListData("누렁", "9999-9999", false));
        list.add(new ListData("보리","3333-3333", false));
        ListView lv_data = findViewById(R.id.lv_data);
        lv_data.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                view = getLayoutInflater().inflate(R.layout.list_custom_item, viewGroup, false);

                TextView name = view.findViewById(R.id.tv_name);
                TextView phone = view.findViewById(R.id.tv_phone);
                ImageView image = view.findViewById(R.id.iv_image);

                name.setText(list.get(i).getName());
                phone.setText(list.get(i).getPhone());
                if(list.get(i).isB()){
                    image.setImageResource(R.drawable.dog1);
                }else {
                    image.setImageResource(R.drawable.dog2);
                }
                return view;
            }
        });
    }
}