package com.naing.likeandunlike;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResult;
    private AppCompatImageView imgLike;
    private AppCompatImageView imgUnlike;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLike = findViewById(R.id.imageLike);
        imgUnlike = findViewById(R.id.imageUnlike);
        txtResult = findViewById(R.id.txtResult);
        if (num == 0) {
            txtResult.setText(String.format(getString(R.string.txt_like), String.valueOf(num)));
        }

        Button btnLike = findViewById(R.id.btnLike);
        Button btnUnlike = findViewById(R.id.btnUnlike);

        btnLike.setOnClickListener(this);
        btnUnlike.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLike:
                num++;
                txtResult.setText(String.format(getString(R.string.txt_like), String.valueOf(num)));
                imgLike.setVisibility(View.VISIBLE);
                imgUnlike.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnUnlike:
                num--;
                if (num < 0) num = 0;
                txtResult.setText(String.format(getString(R.string.txt_like), String.valueOf(num)));
                imgLike.setVisibility(View.INVISIBLE);
                imgUnlike.setVisibility(View.VISIBLE);
                break;
        }
    }
}
