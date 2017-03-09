package com.zgd.gaussblur;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

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
                break;
            case R.id.btn_to_local_blurred:
                break;
            case R.id.btn_to_dynamic_blurred:
                break;
            case R.id.btn_to_slidemenu_blurred:
                break;
            default:
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}

