package com.naing.actiontest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
                Intent intent = new Intent(MainActivity.this, CallPhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.rdEmail:
                break;
            case R.id.rdVideo:
                break;
            case R.id.rdPicture:
                sendPicsFromDrawable();
                break;
            case R.id.rdMemory:
                break;

        }
    }

    private void sendPicsFromDrawable() {
        String path = "android.resource://com.naing.actiontest/drawable/profile";
        Log.d("TAG", path);
        Uri uri = Uri.parse(path);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.putExtra(Intent.EXTRA_TEXT, "Sending from Emulator!");
        intent.setType("image/*");
        startActivity(Intent.createChooser(intent, "Choose App!"));
    }

}
