package com.example.activityplugin;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.activityplugin.manager.HookManager;

/**
 * <b>Project:</b> PluginDemo <br>
 * <b>Create Date:</b> 2017/10/27 <br>
 * <b>Author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        long start = System.currentTimeMillis();
        HookManager.getManager().init();
        Log.i("qy", "hook use time:" + (System.currentTimeMillis() - start));
    }
}
