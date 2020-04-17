package com.naing.intentandactivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String KEY_ACTIVITY = "activity";
    public static int REQUEST_CODE = 0;

    private TextView tvResult;
    private TextInputEditText editText;
    private MediaPlayer music;
    private boolean isMusicPlayerStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvPlayMusic = findViewById(R.id.tvPlayMusic);
        tvResult = findViewById(R.id.tvResult);
        editText = findViewById(R.id.edText);
        Button btnSA = findViewById(R.id.btnSA);
        Button btnSAResult = findViewById(R.id.btnSAFR);

        tvPlayMusic.setOnClickListener(this);
        btnSA.setOnClickListener(this);
        btnSAResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvPlayMusic:
                music = MediaPlayer.create(getApplicationContext(), R.raw.sayso);
                music.start();
                isMusicPlayerStarted = true;
                break;
            case R.id.btnSA:
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(KEY_ACTIVITY, editText.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.btnSAFR:
                Intent intent1 = new Intent(MainActivity.this, NextActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString(KEY_ACTIVITY, editText.getText().toString());
                intent1.putExtras(bundle1);
                startActivityForResult(intent1, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            tvResult.setText(data.getStringExtra(KEY_ACTIVITY));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (music != null) {
            music.stop();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //TODO music reset
        if (isMusicPlayerStarted) {
            music = MediaPlayer.create(getApplicationContext(), R.raw.sayso);
            music.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isMusicPlayerStarted = false;
    }
}
