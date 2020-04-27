package com.naing.actiontest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.naing.actiontest.databinding.ActivityCallPhoneBinding;

public class CallPhoneActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityCallPhoneBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCallPhoneBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCall.setOnClickListener(this);
        binding.btnCheckBill.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCall:
                String telNo = binding.edText.getText().toString();
                actionPhoneCall(telNo);
                break;
            case R.id.btnCheckBill:
                String billCode = Uri.encode("*124#");
                actionPhoneCall(billCode);
                break;
        }
    }

    private void actionPhoneCall(String code) {
        Log.d("TAG", code);
        Intent intentCallPhone = new Intent(Intent.ACTION_CALL);
        intentCallPhone.setData(Uri.parse("tel:" + code));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //TODO to implement app permission
            return;
        }
        startActivity(intentCallPhone);
    }
}
