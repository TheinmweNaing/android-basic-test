package com.naing.toastmessgejava;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton btn2 = findViewById(R.id.btn_two);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Two", Toast.LENGTH_LONG).show();
            }
        });

        AppCompatButton btn3 = findViewById(R.id.btn_three);
        btn3.setOnClickListener(new Click());

        AppCompatButton btn4 = findViewById(R.id.btn_four);
        AppCompatButton btn5 = findViewById(R.id.btn_five);

        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    public void showToastMessage(View v) {
        Toast.makeText(getApplicationContext(), "Button One", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_four:
                Toast.makeText(getApplicationContext(), "Button Four", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_five:
                Toast.makeText(getApplicationContext(), "Button Five", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private class Click implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Button Three", Toast.LENGTH_LONG).show();
        }
    }
}
