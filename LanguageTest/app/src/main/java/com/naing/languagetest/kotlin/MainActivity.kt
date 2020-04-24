package com.naing.languagetest.kotlin

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.naing.languagetest.R
import com.naing.languagetest.databinding.ActivityMainBinding
import com.naing.languagetest.kotlin.LocaleManager.Companion.LANGUAGE_EN
import com.naing.languagetest.kotlin.LocaleManager.Companion.LANGUAGE_JA

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(App.localeManager.setLocale(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        resetActivityTitle(this)

        binding.btnClick.setOnClickListener(this)
        binding.btnChangeJP.setOnClickListener(this)
        binding.btnChangeEng.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", binding.textView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.textView.text = savedInstanceState.getString("text")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnClick -> binding.textView.text = getString(R.string.txt_android)
            R.id.btnChangeJP -> setNewLocale(LANGUAGE_JA)
            R.id.btnChangeEng -> setNewLocale(LANGUAGE_EN)
        }
    }

    fun setNewLocale(language: String) {
        App.localeManager.setNewLocale(this, language)
        finish()
        startActivity(intent)
    }

    fun resetActivityTitle(activity: Activity) {
        try {
            val info = activity.packageManager.getActivityInfo(activity.componentName, PackageManager.GET_META_DATA)
            if (info.labelRes != 0) {
                activity.setTitle(info.labelRes)
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }
}