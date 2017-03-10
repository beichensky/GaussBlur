package com.zgd.gaussblur.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.zgd.gaussblur.R;
import com.zgd.gaussblur.view.BlurredView;

/**
 * 展示动态高斯模糊的界面
 */
public class DynamicBlurredActivity extends Activity {
    private BlurredView blurredView;
    private SeekBar mSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_blur);
        initViews();
        initListener();
    }

    private void initListener() {
        mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @SuppressLint("NewApi")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                blurredView.setBlurredLevel(progress);
            }
        });
    }

    private void initViews() {
        blurredView = (BlurredView) findViewById(R.id.blurredview_dynamic_blur);
        mSeekBar = (SeekBar) findViewById(R.id.seekbar_dynamic_blur);
    }

}
