package com.interimapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.interimapplication.databinding.ActivitySavedOffersBinding;

public class SavedOffers extends Drawer_base {

    ActivitySavedOffersBinding activitySavedOffersBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySavedOffersBinding = ActivitySavedOffersBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_saved_offers);
        allocatedTitle("Offres enregistrées");
    }
}