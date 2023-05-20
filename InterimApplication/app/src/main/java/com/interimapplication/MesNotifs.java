package com.interimapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.interimapplication.databinding.ActivityMesNotifsBinding;

public class MesNotifs extends Drawer_base {

    ActivityMesNotifsBinding activityMesNotifsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMesNotifsBinding = ActivityMesNotifsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_mes_notifs);
        allocatedTitle("Mon notifications");

    }
}