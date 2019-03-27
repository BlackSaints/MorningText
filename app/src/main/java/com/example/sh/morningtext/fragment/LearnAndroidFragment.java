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
import com.example.sh.morningtext.activity.DataSaveActivity;
import com.example.sh.morningtext.activity.EventActivity;
import com.example.sh.morningtext.activity.FourPartsActivity;
import com.example.sh.morningtext.activity.LinearLayoutActivity;
import com.example.sh.morningtext.activity.MDesignActivity;
import com.example.sh.morningtext.activity.MVDesignActivity;
import com.example.sh.morningtext.activity.Pic9Activity;
import com.example.sh.morningtext.activity.ThreeFrameActivity;
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

        Button btn_event = view.findViewById(R.id.btn_event);
        btn_event.setOnClickListener(this);

        Button btn_four = view.findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);

        Button btn_data_save = view.findViewById(R.id.btn_data_save);
        btn_data_save.setOnClickListener(this);

        Button btn_three_frame = view.findViewById(R.id.btn_three_frame);
        btn_three_frame.setOnClickListener(this);

        Button btn_design = view.findViewById(R.id.btn_design);
        btn_design.setOnClickListener(this);
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
            case R.id.btn_event:
                UISwitch(getActivity(), EventActivity.class);
                break;
            case R.id.btn_four:
                UISwitch(getActivity(), FourPartsActivity.class);
                break;
            case R.id.btn_data_save:
                UISwitch(getActivity(), DataSaveActivity.class);
                break;
            case R.id.btn_three_frame:
                UISwitch(getActivity(), ThreeFrameActivity.class);
                break;
            case R.id.btn_design:
                UISwitch(getActivity(), MVDesignActivity.class);
                break;
        }
    }

}
