package com.zgd.gaussblur;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.zgd.gaussblur.activity.DynamicBlurredActivity;
import com.zgd.gaussblur.activity.LocalBlurredActivity;
import com.zgd.gaussblur.activity.NormalBlurredActivity;
import com.zgd.gaussblur.activity.SlideMenuBlurredActivity;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.btn_to_normal_blurred).setOnClickListener(this);
        findViewById(R.id.btn_to_local_blurred).setOnClickListener(this);
        findViewById(R.id.btn_to_dynamic_blurred).setOnClickListener(this);
        findViewById(R.id.btn_to_slidemenu_blurred).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_to_normal_blurred:
                intent = new Intent(this, NormalBlurredActivity.class);
                break;
            case R.id.btn_to_local_blurred:
                intent = new Intent(this, LocalBlurredActivity.class);
                break;
            case R.id.btn_to_dynamic_blurred:
                intent = new Intent(this, DynamicBlurredActivity.class);
                break;
            case R.id.btn_to_slidemenu_blurred:
                intent = new Intent(this, SlideMenuBlurredActivity.class);
                break;
            default:
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}

