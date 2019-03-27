package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.SeekBar;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.weight.SquareImageView;

public class CustomViewLayoutActivity extends MBaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlayout);
        SeekBar mSeekBar = findViewById(R.id.seekbar);
        final SquareImageView squareImageView = findViewById(R.id.square);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                squareImageView.setProgress(200+progress,200);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
