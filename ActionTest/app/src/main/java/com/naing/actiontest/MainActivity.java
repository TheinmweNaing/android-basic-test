package com.naing.actiontest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.naing.actiontest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.rdGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rdCallPhone:
                createActivity(MainActivity.this, CallPhoneActivity.class);
                /*Intent intent = new Intent(MainActivity.this, CallPhoneActivity.class);
                startActivity(intent);*/
                break;
            case R.id.rdEmail:
                break;
            case R.id.rdVideo:
                break;
            case R.id.rdPicture:
                break;
            case R.id.rdMemory:
                break;

        }
    }

    private void createActivity(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        startActivity(intent);
    }
}
