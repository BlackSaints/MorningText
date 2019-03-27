package com.example.sh.morningtext.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.databinding.ActivityRecycleBinding;
import com.example.sh.morningtext.fragment.Recycle1Fragment;
import com.example.sh.morningtext.fragment.Recycle2Fragment;
import com.example.sh.morningtext.fragment.RecycleFragment;

import java.util.ArrayList;
import java.util.List;

public class MRecycleViewActivity extends MBaseActivity {

    private ActivityRecycleBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycle);
        initTab();
    }

    private void initTab() {
        List<String> title = new ArrayList<>();
        title.add("列表");
        title.add("网格");
        title.add("瀑布流");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecycleFragment());
        fragments.add(new Recycle1Fragment());
        fragments.add(new Recycle2Fragment());

        binding.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return title.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });

        binding.tablayout.setupWithViewPager(binding.viewPager);
    }
}
