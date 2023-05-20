package com.interimapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.interimapplication.databinding.ActivityMesEmploisBinding;

public class MesEmplois extends Drawer_base {
    ActivityMesEmploisBinding activityMesEmploisBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMesEmploisBinding = ActivityMesEmploisBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_mes_emplois);
        allocatedTitle("Mes emplois");
    }
}