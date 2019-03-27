package com.example.sh.morningtext.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.activity.CustomView01Activity;
import com.example.sh.morningtext.activity.CustomViewLayoutActivity;
import com.example.sh.morningtext.activity.HorProgressbarActivity;
import com.example.sh.morningtext.activity.JavaNumberTypeActivity;
import com.example.sh.morningtext.adapter.BaseViewAdapter;
import com.example.sh.morningtext.base.BaseFragment;

public class JavaFragment extends BaseFragment {

    private static JavaFragment fragment;

    private ListView mListView;
    Class[] acy = {JavaNumberTypeActivity.class};
    String[] names = {"数据类型"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_event,null);

        mListView = (ListView) view.findViewById(R.id.event_listview);
        BaseViewAdapter adapter = new BaseViewAdapter(names,R.layout.adapter_baseview) {
            @Override
            public void bindView(BaseViewHolder viewHolder, Object item) {
                TextView mTextView = (TextView) viewHolder.getView(R.id.tv_baseview);
                mTextView.setText(item.toString());
            }
        };

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(),acy[position]));
            }
        });
        return view;
    }

    public static JavaFragment getInstance() {
        if(fragment == null){
            fragment = new JavaFragment();
        }
        return fragment;
    }
}
