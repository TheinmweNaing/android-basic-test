package com.naing.languagetest;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class App extends Application {

    public static LocaleManager localeManager;

    @Override
    protected void attachBaseContext(Context base) {
        Log.v("TAG-APP", "attachBaseContext");
        localeManager = new LocaleManager(base);
        super.attachBaseContext(localeManager.setLocale(base));
    }
}
