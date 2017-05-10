package com.gionee.amisystem.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.gionee.amisystem.R;

/**
 * Created by Administrator on 2017/4/12.
 */

public class HomeFragment extends FrameLayout{

    public HomeFragment(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.fragment_home,this);
    }
}
