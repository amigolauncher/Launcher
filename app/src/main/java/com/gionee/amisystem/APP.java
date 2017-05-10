package com.gionee.amisystem;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/4/12.
 */

public class APP extends Application {
    private static Context sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppContext = getApplicationContext();
    }

    public static Context getAppContext(){
        return sAppContext;
    }
}
