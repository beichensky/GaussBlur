package com.zgd.gaussblur.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.zgd.gaussblur.R;
import com.zgd.gaussblur.utils.BlurBitmapUtil;

/**
 * 展示普通高斯模糊的界面
 */
public class NormalBlurredActivity extends Activity {

    private ImageView mIv;
    private Button mChangeBtn;
    private boolean mShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_blur);

        initViews();
        initListeners();
    }

    private void initListeners() {
        mChangeBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!mShow) {
                    mIv.buildDrawingCache();
                    Bitmap sentBitmap = mIv.getDrawingCache();
                    mIv.setImageBitmap(BlurBitmapUtil.blurBitmap(NormalBlurredActivity.this, sentBitmap, 20.0f));
                    mChangeBtn.setText("取消高斯模糊");
                    mShow = true;
                } else {
                    Log.e("tag", "1");
                    mIv.setImageResource(R.drawable.pic);
                    mChangeBtn.setText(R.string.normal_blur_btn_text);
                    Log.e("tag", "2");
                    mShow = false;
                }
            }
        });
    }

    private void initViews() {
        mIv = (ImageView) findViewById(R.id.iv_normal_blur);
        mChangeBtn = (Button) findViewById(R.id.btn_normal_blurred);
    }

}
