package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import com.example.interim.databinding.ActivityInterimaireProfilBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import models.Employeur;
import models.Interimaire;

public class InterimaireProfil extends Drawer_base {

    TextView savedOffers, mesCandidatures,mesNotifs, mesEmplois, nom;
    ActivityInterimaireProfilBinding act;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityInterimaireProfilBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Mon profil");

        nom = findViewById(R.id.nom_utilisateur);

        DatabaseReference interimaireRef = FirebaseDatabase.getInstance().getReference("interimaire");
        interimaireRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot candidatSnap : snapshot.getChildren()){
                    Interimaire candidat = candidatSnap.getValue(Interimaire.class);
                    if(candidat.getEmail().equals(userEmail)){
                        nom.setText(candidat.getNom());
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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
                startActivity(new Intent(InterimaireProfil.this, MesCandidatures.class));
            }
        });

        mesNotifs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InterimaireProfil.this, MesNotifs.class));
            }
        });

        savedOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InterimaireProfil.this, SavedOffers.class));
            }
        });

        mesEmplois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InterimaireProfil.this, MesEmplois.class));
            }
        });


    }
}