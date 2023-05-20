package com.interimapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import com.interimapplication.databinding.ActivityProfilBinding;

public class Profil extends Drawer_base {

    ActivityProfilBinding activityProfilBinding;
    private TextView savedOffers;
    private TextView mesCandidatures;
    private TextView mesNotifs;
    private TextView mesEmplois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProfilBinding = ActivityProfilBinding.inflate(getLayoutInflater());
        setContentView(activityProfilBinding.getRoot());
        allocatedTitle("Mon profil");

        TextView gerer = findViewById(R.id.gerer_profil);
        SpannableString content = new SpannableString("Gérer mon profil");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        gerer.setText(content);

        savedOffers = findViewById(R.id.saved_offre);
        mesCandidatures = findViewById(R.id.candidatures);
        mesNotifs = findViewById(R.id.notifs);
        mesEmplois = findViewById(R.id.emplois);

        mesCandidatures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profil.this, MesCandidatures.class));
            }
        });

        mesNotifs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profil.this, MesNotifs.class));
            }
        });

        savedOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profil.this, SavedOffers.class));
            }
        });

        mesEmplois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profil.this, MesEmplois.class));
            }
        });


    }
}