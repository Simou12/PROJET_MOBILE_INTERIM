package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;

public class Call extends AppCompatActivity {
    private static final int PERMISSION_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        Intent intent = getIntent();
        String phoneNumber =(String) intent.getSerializableExtra("num");

        if(ActivityCompat.checkSelfPermission(Call.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(Call.this,
                    new String[] {android.Manifest.permission.CALL_PHONE},PERMISSION_REQUEST);
        else{
            Uri phone=Uri.parse("tel:"+phoneNumber);
            Intent callIntent = new Intent(Intent.ACTION_CALL, phone);
            startActivity(callIntent);
        }

    }



}