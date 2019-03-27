package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.adapter.CommonAdapter;

import java.util.LinkedList;

public class SpinnerActivity extends AppCompatActivity {

    private LinkedList<String> mData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initData();
        Spinner mSpinner = findViewById(R.id.spinner);
        CommonAdapter adapter = new CommonAdapter(mData,R.layout.adapter_spinner) {
            @Override
            public void bindView(ViewHolder viewHolder, Object item) {
                String bean = (String) item;
                viewHolder.setText(bean.toString(),R.id.tv_message);
            }
        };
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerActivity.this, mData.get(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initData() {
        mData = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            mData.add("message"+i);
        }
    }
}
