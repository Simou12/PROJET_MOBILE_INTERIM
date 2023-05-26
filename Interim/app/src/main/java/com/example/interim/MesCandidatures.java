package com.example.interim;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.interim.databinding.ActivityMesCandidaturesBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import InterimaireCandidatureRecyclerView.ItemCandidature;
import InterimaireCandidatureRecyclerView.MesCandidaturesAdapter;
import models.Candidature;

public class MesCandidatures extends Drawer_base implements OnItemClickListener{

    RecyclerView recyclerView;
    ArrayList<ItemCandidature> listCandidatures;
    ActivityMesCandidaturesBinding act;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    TextView aucune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityMesCandidaturesBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Mes candidature");

        listCandidatures = new ArrayList<>();

        DatabaseReference candRef = FirebaseDatabase.getInstance().getReference("candidatures");
        candRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Candidature candidature = dataSnapshot.getValue(Candidature.class);
                    if(candidature.getEmail().equals(userEmail)){
                        String adress = candidature.getAdress();
                        ItemCandidature item = new ItemCandidature(candidature.getNomEmploi(),candidature.getEntreprise(),candidature.getRefAnnonce(),candidature.getDate(),candidature.getStatus(),adress);
                        listCandidatures.add(item);
                    }
                }
                afficher(listCandidatures);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void afficher(ArrayList<ItemCandidature> list) {
        if(list.isEmpty()){
            aucune = findViewById(R.id.aucune);
            aucune.setText("Vous n'avez aucune candidature");
        }else {
            recyclerView = findViewById(R.id.recylerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(MesCandidatures.this));
            recyclerView.setAdapter(new MesCandidaturesAdapter(getApplicationContext(), list,this));
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}