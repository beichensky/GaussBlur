package com.zgd.gaussblur.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;

import com.zgd.gaussblur.R;
import com.zgd.gaussblur.fragment.MyDialogFragment;
import com.zgd.gaussblur.utils.BlurBitmapUtil;

/**
 * 展示动态高斯模糊的界面
 */
public class LocalBlurredActivity extends Activity {

    private Button mBtn;
    private View mLocalBlurRootView, mFragmentRootView;
    private MyDialogFragment mFragment;
    private boolean mShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_blur);

        initViews();
        initListener();
    }

    private void initListener() {
        mBtn.setOnClickListener(new OnClickListener() {

            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                if (mShow) {
                    if (mFragment != null) {
                        ft.remove(mFragment).commit();
                    }
                    mFragmentRootView.setVisibility(View.INVISIBLE);
                    mBtn.setText(R.string.local_blur_show_dialog);
                } else {
                    if (mFragment == null) {
                        mFragment = new MyDialogFragment();
                    }
                    ft.add(R.id.fragment_mydialog_root, mFragment).commit();
                    ViewTreeObserver vto = mLocalBlurRootView.getViewTreeObserver();
                    vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

                        @Override
                        public void onGlobalLayout() {
                            mLocalBlurRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            BlurBitmapUtil.blur(mLocalBlurRootView, mFragmentRootView, 5, 8);
                        }
                    });
                    mBtn.setText("取消对话框");
                    mFragmentRootView.setVisibility(View.VISIBLE);
                }
                mShow = !mShow;
            }
        });
    }

    private void initViews() {
        mLocalBlurRootView = findViewById(R.id.local_blur_root);
        mBtn = (Button) findViewById(R.id.btn_local_blur);
        mFragmentRootView = findViewById(R.id.fragment_mydialog_root);
    }

}
