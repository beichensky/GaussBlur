package com.zgd.gaussblur.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgd.gaussblur.R;

@SuppressLint("NewApi")
public class MyDialogFragment extends Fragment {

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mydialog, null);
    }

}
