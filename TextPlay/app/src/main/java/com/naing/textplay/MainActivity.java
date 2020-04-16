package com.naing.textplay;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatToggleButton;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private TextInputEditText edText;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edText);
        tvResult = findViewById(R.id.tvResult);
        Button btnCommand = findViewById(R.id.btnCommand);
        AppCompatToggleButton btnToggle = findViewById(R.id.btnToggle);

        btnCommand.setOnClickListener(this);
        btnToggle.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Random ran = new Random();
        String text = edText.getText().toString();
        tvResult.setText(text);

        //set random text size
        tvResult.setTextSize(ran.nextInt(70));
        //set random text color
        tvResult.setTextColor(Color.rgb(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)));
        //set random text gravity
        switch (ran.nextInt(3)) {
            case 0:
                tvResult.setGravity(Gravity.START);
                break;
            case 1:
                tvResult.setGravity(Gravity.END);
                break;
            case 2:
                tvResult.setGravity(Gravity.CENTER_HORIZONTAL);
                break;
        }
        //check text content and change gravity
        switch (text.toLowerCase()) {
            case "left":
            case "start":
                tvResult.setGravity(Gravity.START);
                break;
            case "right":
            case "end":
                tvResult.setGravity(Gravity.END);
                break;
            case "center":
                tvResult.setGravity(Gravity.CENTER_HORIZONTAL);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            edText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            edText.setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }
}
