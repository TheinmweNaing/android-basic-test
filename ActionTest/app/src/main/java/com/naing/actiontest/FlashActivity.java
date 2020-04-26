package com.naing.actiontest;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.naing.actiontest.databinding.FlashActivityBinding;

public class FlashActivity extends AppCompatActivity {

    private FlashActivityBinding binding;
    private MediaPlayer mp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FlashActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.tvSlide.setSelected(true);
        Typeface tf = Typeface.createFromAsset(getAssets(), "zawgyi.ttf");
        binding.tvSlide.setTypeface(tf);

        mp = MediaPlayer.create(this, R.raw.sayso);
        mp.start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mp.pause();
                    Intent intent = new Intent(FlashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }
}
