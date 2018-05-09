package com.example.sh.morningtext.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.base.BaseFragment;

public class LearnAndroidFragment extends BaseFragment{

    private static LearnAndroidFragment fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn,null);
        return view;
    }

    public static LearnAndroidFragment getInstance() {
        if(fragment == null){
            fragment = new LearnAndroidFragment();
        }
        return fragment;
    }
}
