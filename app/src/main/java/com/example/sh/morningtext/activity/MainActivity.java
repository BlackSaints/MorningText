package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.fragment.JavaFragment;
import com.example.sh.morningtext.fragment.LearnAndroidFragment;
import com.example.sh.morningtext.fragment.MDesignFragment;

public class  MainActivity extends AppCompatActivity {

    private MDesignFragment mdFragment;
    private LearnAndroidFragment learFragment;
    private JavaFragment javaFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private int lastFragment = 0;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(lastFragment != 0){
                        switchFragment(lastFragment,0);
                    }
                    return true;
                case R.id.navigation_dashboard:
                    if(lastFragment != 1){
                        switchFragment(lastFragment,1);
                    }
                    return true;
                case R.id.navigation_notifications:
                    if(lastFragment != 2){
                        switchFragment(lastFragment,2);
                    }
                    return true;
            }
            return false;
        }

    };

    private void switchFragment(int lastIndex, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastIndex]);
        if(!fragments[index].isAdded()){
            transaction.add(R.id.lay_content,fragments[index]);
        }
        lastFragment = index;
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

    private Fragment[] fragments;

    private void hideFragments() {
        if(mdFragment.isAdded()){
            transaction.hide(mdFragment);
        }
        if(learFragment.isAdded()){
            transaction.hide(learFragment);
        }
        if(javaFragment.isAdded()){
            transaction.hide(javaFragment);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initFragments();

    }

    private void initFragments() {
        mdFragment = MDesignFragment.getInstance();
        learFragment = LearnAndroidFragment.getInstance();
        javaFragment = JavaFragment.getInstance();

        fragments = new Fragment[]{mdFragment,learFragment,javaFragment};
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.lay_content,mdFragment);
        transaction.commit();

    }

}
