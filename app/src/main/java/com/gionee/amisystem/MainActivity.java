package com.gionee.amisystem;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gionee.amisystem.view.CellPagerAdapter;
import com.gionee.amisystem.view.YourPageFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ViewPager mViewPager;
    boolean mEnableYourPage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new CellPagerAdapter(this));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                try {
                    Log.d(TAG, "onPageSelected: position = " +position);
                    if(mEnableYourPage){
                        YourPageFragment view = (YourPageFragment) mViewPager.getChildAt(0);
                        view.onYourPageSelected(position == 0 ? true : false);
                        Log.d(TAG, "onPageSelected: " +(position == 0 ? true : false));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mEnableYourPage = mViewPager.getAdapter().getCount() == 2;

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mEnableYourPage){
            try {
                YourPageFragment view = (YourPageFragment) mViewPager.getChildAt(0);
                view.onResume();
                Log.d(TAG, "onResume: ");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mEnableYourPage){
            try {
                YourPageFragment view = (YourPageFragment) mViewPager.getChildAt(0);
                view.onPause();
                Log.d(TAG, "onPause: ");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mEnableYourPage){
            try {
                YourPageFragment view = (YourPageFragment) mViewPager.getChildAt(0);
                view.onDestroy();
                Log.d(TAG, "onDestroy: ");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
