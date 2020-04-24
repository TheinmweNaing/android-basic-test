package com.naing.languagetest.kotlin

import android.app.Application
import android.content.Context
import android.util.Log
import com.naing.languagetest.LocaleManager

class App : Application() {

    companion object {
        lateinit var localeManager: LocaleManager
    }

    override fun attachBaseContext(base: Context?) {
        Log.d("TAG-APP_K", " attachBase")
        localeManager = LocaleManager(base)
        super.attachBaseContext(localeManager.setLocale(base))
    }
}