package com.gionee.amisystem.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.gionee.amisystem.utils.Utils;

public class CellPagerAdapter extends PagerAdapter {
    private static final String TAG = "CellPagerAdapter";

    private Context mContext;
    public CellPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return Utils.isAppInstalled()? 2:1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        FrameLayout item;
        if(getCount() == 1 || position == 1){
            item =  new HomeFragment(mContext);
        }else {
            item = new YourPageFragment(mContext);
        }
        container.addView(item,position);
        return item;
    }
}