package com.naing.intentandactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.naing.intentandactivity.MainActivity.KEY_ACTIVITY;

public class NextActivity extends AppCompatActivity {

    private TextView tvChoose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        TextView tvShowText = findViewById(R.id.tvShowText);
        tvChoose = findViewById(R.id.tvChoose);
        RadioGroup radioGroup = findViewById(R.id.rdGroup);
        Button btnFinish = findViewById(R.id.btnFinish);

        //get bundle for activity
        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString(KEY_ACTIVITY);
        tvShowText.setText(text);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbAndroid:
                        tvChoose.setText(String.format(getString(R.string.txt_choose), "Android"));
                        break;
                    case R.id.rbSwift:
                        tvChoose.setText(String.format(getString(R.string.txt_choose), "Swift"));
                        break;
                    case R.id.rbJava:
                        tvChoose.setText(String.format(getString(R.string.txt_choose), "Java"));
                        break;
                }
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY_ACTIVITY, tvChoose.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
