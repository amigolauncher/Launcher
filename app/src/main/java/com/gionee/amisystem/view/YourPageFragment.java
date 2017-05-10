package com.gionee.amisystem.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.gionee.amisystem.R;
import com.gionee.amisystem.utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/4/12.
 */

public class YourPageFragment extends FrameLayout implements View.OnClickListener {
    private View mYourPageView;

    public YourPageFragment(@NonNull Context context) {
        super(context);

        View rootView = LayoutInflater.from(context).inflate(R.layout.fragment_yourpage, this);
        rootView.findViewById(R.id.load_yourpage).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mYourPageView = Utils.getYourPage();
        if (mYourPageView != null) {
            removeAllViews();

            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
            addView(mYourPageView, lp);
        } else {
            Toast.makeText(getContext(), "load failed", Toast.LENGTH_SHORT).show();
        }
    }


    public void onResume() {
        if (mYourPageView != null) {
            callOnMethod(mYourPageView, "onResume");
        }
    }

    public void onPause() {
        if (mYourPageView != null) {
            callOnMethod(mYourPageView, "onPause");
        }
    }

    public void onDestroy() {
        if (mYourPageView != null) {
            callOnMethod(mYourPageView, "onDestroy");
        }
    }

    public void onYourPageSelected(boolean selected) {
        if (mYourPageView != null) {
            callOnMethod(mYourPageView, "onYourPageSelected", new Class[]{Boolean.TYPE}, selected);
        }
    }

    private void callOnMethod(Object object, String methodName) {
        callOnMethod(object, methodName, null, null);
    }

    private void callOnMethod(Object object, String methodName, Class<?>[] parameterTypes, Object... args) {
        if (object != null) {
            try {
                Method method = object.getClass().getMethod(methodName, parameterTypes);
                method.invoke(object, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
