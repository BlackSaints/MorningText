package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TableLayout;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.fragment.MCustomFragment;

import java.util.ArrayList;
import java.util.List;

public class MCustomViewActivity extends MBaseActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] title = new String[]{"圆形","矩形","点","椭圆","线","扇形","图片"};
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        fragments = new ArrayList<>();

        //圆形
        fragments.add(new MCustomFragment().setLayout(R.layout.frg_circle));
        //矩形
        fragments.add(new MCustomFragment().setLayout(R.layout.frg_rect));
        //点
        fragments.add(new MCustomFragment().setLayout(R.layout.frg_point));
        //椭圆
        fragments.add(new MCustomFragment().setLayout(R.layout.frg_oval));
        //线
        fragments.add(new MCustomFragment().setLayout(R.layout.frg_line));
        //扇形
        fragments.add(new MCustomFragment().setLayout(R.layout.frg_arc));
        //图片
        fragments.add(new MCustomFragment().setLayout(R.layout.frg_bitmap));


        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
