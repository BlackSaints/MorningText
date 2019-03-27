package com.example.sh.morningtext.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.databinding.ActivityToolbarBinding;
import com.example.sh.morningtext.weight.ToastManger;

public class MToolbarActivity extends MBaseActivity{

    private ActivityToolbarBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_toolbar);

        binding.toolbar.inflateMenu(R.menu.navigation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        ToastManger.show(menuItem.getTitle().toString(),MToolbarActivity.this);
                        break;
                }

                return false;
            }
        });
    }
}
