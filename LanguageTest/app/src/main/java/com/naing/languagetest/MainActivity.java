package com.naing.languagetest;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.naing.languagetest.databinding.ActivityMainBinding;

import static android.content.pm.PackageManager.GET_META_DATA;
import static com.naing.languagetest.LocaleManager.LANGUAGE_EN;
import static com.naing.languagetest.LocaleManager.LANGUAGE_JA;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(App.localeManager.setLocale(newBase));
        Log.d("TAG", "attachBaseContext");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        resetActivityTitle(this);

        binding.btnClick.setOnClickListener(this);
        binding.btnChangeJP.setOnClickListener(this);
        binding.btnChangeEng.setOnClickListener(this);
        Log.d("TAG", "OnCreate");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TAG", "onSave");
        outState.putString("text", binding.textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("TAG", "onRestore");
        binding.textView.setText(savedInstanceState.getString("text"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnClick:
                binding.textView.setText(getString(R.string.txt_android));
                break;
            case R.id.btnChangeJP:
                setNewLocale(LANGUAGE_JA);
                break;
            case R.id.btnChangeEng:
                setNewLocale(LANGUAGE_EN);
                break;
        }
    }

    private void setNewLocale(String language) {

        App.localeManager.setNewLocale(this, language);
       /* Activity activity = MainActivity.this;
        Intent intent = new Intent();
        intent.setClass(activity, activity.getClass());
        activity.startActivity(intent);*/
        finish();
        startActivity(getIntent());

    }

    private void resetActivityTitle(Activity activity) {
        try {
            ActivityInfo info = activity.getPackageManager().getActivityInfo(activity.getComponentName(), GET_META_DATA);
            if (info.labelRes != 0) {
                activity.setTitle(info.labelRes);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
