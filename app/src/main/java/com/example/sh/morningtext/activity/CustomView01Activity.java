package com.example.sh.morningtext.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.databinding.ActivityAppbarlayoutBinding;
import com.example.sh.morningtext.databinding.ActivityCustomview01Binding;
import com.example.sh.morningtext.fragment.CustomViewFragment;

import java.util.ArrayList;
import java.util.List;

public class CustomView01Activity extends MBaseActivity {

    private ActivityCustomview01Binding binding;
    private List<String> titles;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_customview01);

        initData();

        binding.viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return titles.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        binding.tablayout.setupWithViewPager(binding.viewpager);
    }

    private void initData() {

        titles = new ArrayList<>();
        titles.add("view01");
        titles.add("view02");

        fragments = new ArrayList<>();
        fragments.add(new CustomViewFragment().setLayId(R.layout.frg_cv01));
        fragments.add(new CustomViewFragment().setLayId(R.layout.frg_circle));
    }
}
