package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.adapter.MAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity{

    private ListView mListview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        List<String> strs = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strs.add("长江"+i+"号");
        }
        mListview = findViewById(R.id.listview);
        MAdapter adapter = new MAdapter(strs,this);
        TextView headView = new TextView(this);
        headView.setText("表头");
        mListview.addHeaderView(headView);
        mListview.setAdapter(adapter);

        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "长江"+position+"号", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
