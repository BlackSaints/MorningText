package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.adapter.CommonAdapter;
import com.example.sh.morningtext.weight.ToastManger;

import java.util.LinkedList;

public class ToastActivity extends MBaseActivity {

    public LinkedList<String> mData;
    public String[] strs = {"默认用法","修改字体大小","带图片的Toast","自定义布局Toast"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mData = new LinkedList<>();
        initData();
        ListView mListVeiw = (ListView) find(R.id.listview_toast);
        CommonAdapter<String> adapter = new CommonAdapter<String>(mData,R.layout.item_listview_common) {
            @Override
            public void bindView(ViewHolder viewHolder, String item) {
                viewHolder.setText(item,R.id.tv_mes);
            }
        };

        mListVeiw.setAdapter(adapter);

        mListVeiw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(ToastActivity.this,strs[position],Toast.LENGTH_SHORT).show();
                }else if(position == 1){
                    ToastManger.toast(strs[1],ToastActivity.this);
                }else if(position == 2){
                    ToastManger.toastIcon(strs[2],R.drawable.ic_dashboard_black_24dp,ToastActivity.this);
                }else if(position == 3){
                    ToastManger.show(strs[2],ToastActivity.this);
                }
            }
        });


    }

    private void initData() {
        mData = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            mData.add(strs[i]);
        }
    }
}
