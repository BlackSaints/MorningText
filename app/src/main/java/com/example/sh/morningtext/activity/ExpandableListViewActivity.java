package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.adapter.MExpandablelvAdapter;
import com.example.sh.morningtext.bean.GroupBean;
import com.example.sh.morningtext.bean.ItemBean;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

public class ExpandableListViewActivity extends AppCompatActivity {

    private List<GroupBean> mGroupData;
    private List<List<ItemBean>> mItemData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        initData();
        ExpandableListAdapter adapter = new MExpandablelvAdapter(mGroupData,mItemData,this);
        ExpandableListView expandableListView = findViewById(R.id.expandview);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(ExpandableListViewActivity.this, mItemData.get(groupPosition).get(childPosition).getItemName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void initData() {
        mGroupData = new ArrayList<>();
        mItemData = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            GroupBean groupBean = new GroupBean();
            groupBean.setGroupName("Group"+i);
            mGroupData.add(groupBean);
        }

        for (int i = 0; i < mGroupData.size(); i++) {
            List<ItemBean> itemBeans = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                ItemBean bean = new ItemBean();
                if(j == 0){
                    bean.setIcon(R.drawable.ic_home_black_24dp);
                }else{
                    bean.setIcon(R.drawable.ic_dashboard_black_24dp);
                }
                bean.setItemName("Item"+j);
                itemBeans.add(bean);
            }
            mItemData.add(itemBeans);
        }

    }
}
