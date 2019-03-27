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
import com.example.sh.morningtext.activity.ACYActivity;
import com.example.sh.morningtext.activity.CustomView01Activity;
import com.example.sh.morningtext.activity.CustomViewLayoutActivity;
import com.example.sh.morningtext.activity.FourPartsActivity;
import com.example.sh.morningtext.activity.HorProgressbarActivity;
import com.example.sh.morningtext.activity.MCustomViewActivity;
import com.example.sh.morningtext.activity.MDesignActivity;
import com.example.sh.morningtext.activity.ServiceActivity;
import com.example.sh.morningtext.adapter.BaseViewAdapter;
import com.example.sh.morningtext.base.BaseFragment;

public class MDesignFragment extends BaseFragment {

    private static MDesignFragment fragment;
    private ListView mListView;
    Class[] acy = {MCustomViewActivity.class,MDesignActivity.class,CustomView01Activity.class,CustomViewLayoutActivity.class,HorProgressbarActivity.class};
    String[] names = {"自定义View","MD","自定义View01","自定义View-布局","Demo-横向进度条"};

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

    public static MDesignFragment getInstance() {
        if(fragment == null){
            fragment = new MDesignFragment();
        }
        return fragment;
    }
}
