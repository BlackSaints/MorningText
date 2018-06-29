package com.example.sh.morningtext.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.activity.BaseViewActivity;
import com.example.sh.morningtext.activity.LinearLayoutActivity;
import com.example.sh.morningtext.activity.Pic9Activity;
import com.example.sh.morningtext.base.BaseFragment;

public class LearnAndroidFragment extends BaseFragment implements View.OnClickListener{

    private static LearnAndroidFragment fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn,null);
        Button btn_9pic = view.findViewById(R.id.btn_9pic);
        btn_9pic.setOnClickListener(this);

        Button btn_linearlayout = view.findViewById(R.id.btn_linearlayout);
        btn_linearlayout.setOnClickListener(this);

        Button btn_baseview = view.findViewById(R.id.btn_baseview);
        btn_baseview.setOnClickListener(this);
        return view;
    }

    public static LearnAndroidFragment getInstance() {
        if(fragment == null){
            fragment = new LearnAndroidFragment();
        }
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_9pic:
                UISwitch(getActivity(),Pic9Activity.class);
            break;
            case R.id.btn_linearlayout:
                UISwitch(getActivity(),LinearLayoutActivity.class);
                break;
            case R.id.btn_baseview:
                UISwitch(getActivity(),BaseViewActivity.class);
                break;
        }
    }
}
