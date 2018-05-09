package com.example.sh.morningtext.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.base.BaseFragment;

public class MDesignFragment extends BaseFragment {

    private static MDesignFragment fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_md,null);
        return view;
    }

    public static MDesignFragment getInstance() {
        if(fragment == null){
            fragment = new MDesignFragment();
        }
        return fragment;
    }
}
