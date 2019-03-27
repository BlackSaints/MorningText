package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.adapter.CommonAdapter;
import com.example.sh.morningtext.bean.IconBean;

import java.util.LinkedList;

public class GridViewActivity extends AppCompatActivity {

    LinkedList<IconBean> mData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        GridView gridView = findViewById(R.id.gridview);
        initData();
        CommonAdapter adapter = new CommonAdapter(mData,R.layout.item_grid_view) {
            @Override
            public void bindView(ViewHolder viewHolder, Object item) {
                IconBean bean = (IconBean) item;
                viewHolder.setText(bean.getName(),R.id.grid_name);
                viewHolder.setImageResource(R.id.grid_img,bean.getId());
            }
        };

        gridView.setAdapter(adapter);
    }

    private void initData() {
        mData = new LinkedList<>();
        for (int i = 0; i <9; i++) {
            IconBean bean = new IconBean();
            bean.setId(R.drawable.ic_launcher_background);
            bean.setName("GridView"+i);
            mData.add(bean);
        }
    }


}
