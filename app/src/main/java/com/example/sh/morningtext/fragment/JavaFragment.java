package com.example.sh.morningtext.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.base.BaseFragment;

public class JavaFragment extends BaseFragment {

    private static JavaFragment fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java,null);
        return view;
    }

    public static JavaFragment getInstance() {
        if(fragment == null){
            fragment = new JavaFragment();
        }
        return fragment;
    }
}
