package com.naing.fragmentlessonone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView1;
    private TextView textView2;
    private int counter1 = 0;
    private int counter2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOne = findViewById(R.id.btnOne);
        Button btnTwo = findViewById(R.id.btnTwo);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        if (btn.getText().equals(getString(R.string.btn_one))) {
            counter1++;
            String count = counter1 > 1 ? " times." : " time.";
            textView1.setText(getString(R.string.txt_one, String.valueOf(counter1)).concat(count));
        } else {
            counter2++;
            String count = counter2 > 1 ? " times." : " time.";
            textView2.setText(getString(R.string.txt_two, String.valueOf(counter2)).concat(count));
        }
    }
}
