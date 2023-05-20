package com.interimapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.interimapplication.databinding.ActivityMesCandidaturesBinding;
import com.interimapplication.databinding.ActivityProfilBinding;

public class MesCandidatures extends Drawer_base {

    ActivityMesCandidaturesBinding activityMesCandidaturesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMesCandidaturesBinding = ActivityMesCandidaturesBinding.inflate(getLayoutInflater());
        setContentView(activityMesCandidaturesBinding.getRoot());
        allocatedTitle("Mes candidatures");
    }
}