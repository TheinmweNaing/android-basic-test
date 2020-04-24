package com.naing.languagetest.kotlin

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.preference.PreferenceManager
import android.util.Log
import java.util.*

class LocaleManager {

    companion object {
        val LANGUAGE_JA = "ja"
        val LANGUAGE_EN = "en"
        val LANGUAGE_KEY = "language_key"
    }

    var prefs: SharedPreferences? = null

    fun LocaleManager(context: Context?) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setLocale(c: Context): Context? {
        return updateResources(c, getLanguage())
    }

    fun setNewLocale(c: Context, language: String): Context? {
        persistLanguage(language)
        return updateResources(c, language)
    }

    fun getLanguage(): String? {
        return prefs?.getString(LANGUAGE_KEY, LANGUAGE_EN)
    }

    private fun persistLanguage(language: String) {
        // use commit() instead of apply(), because sometimes we kill the application process
        // immediately that prevents apply() from finishing
        prefs?.edit()?.putString(LANGUAGE_KEY, language)?.commit()
    }

    private fun updateResources(context: Context, language: String?): Context? {
        var context = context
        Log.d("TAG-Language", language)
        val locale = Locale(language)
        Locale.setDefault(locale)
        val res = context.resources
        val config = Configuration(res.configuration)
        config.setLocale(locale)
        Log.d("TAG", config.locale.displayLanguage)
        context = context.createConfigurationContext(config)
        return context
    }
}