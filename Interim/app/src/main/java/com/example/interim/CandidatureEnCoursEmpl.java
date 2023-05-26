package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.interim.databinding.ActivityCandidatureEnCoursEmplBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import annonceEmployeurRecyclerView.AnnonceEmployeurAdapter;
import candidatureEnCoursEmplRecyclerView.CandidatEmplAdapter;
import candidatureEnCoursEmplRecyclerView.ItemCandidatureEmpl;
import models.Candidature;

public class CandidatureEnCoursEmpl extends Drawer_base implements OnItemClickListener {

    RecyclerView recyclerView;
    ArrayList<ItemCandidatureEmpl> listCandidaturesItem;
    ActivityCandidatureEnCoursEmplBinding act;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    TextView aucune;
    String choix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityCandidatureEnCoursEmplBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());

        Intent intent = getIntent();
        String refAnnonce = intent.getStringExtra("refAnnonce");
        choix = intent.getStringExtra("casChoisis");

        if (choix.equals("enCours")){
            allocatedTitle("Candidatures en Cours");
        }else if (choix.equals("acceptee")){
            allocatedTitle("Candidatures acceptées");
        }else {
            allocatedTitle("Candidatures rejetées");
        }

        listCandidaturesItem = new ArrayList<>();

        //candidature en cours
        if(choix.equals("enCours")){
            DatabaseReference candRef = FirebaseDatabase.getInstance().getReference("candidatures");
            candRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Candidature candidature = dataSnapshot.getValue(Candidature.class);
                        if(candidature.getRefAnnonce().equals(refAnnonce) && candidature.getEmployeur().equals(userEmail) && candidature.getStatus().equals("en attente")){
                            ItemCandidatureEmpl item = new ItemCandidatureEmpl(candidature.getNomCandidat(),candidature.getPrenomCandidat(),candidature.getEmail(),candidature.getDate());
                            listCandidaturesItem.add(item);
                        }
                    }
                    afficher(listCandidaturesItem);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        //candidature acceptee
        else if (choix.equals("acceptee")){
            DatabaseReference candRef = FirebaseDatabase.getInstance().getReference("candidatures");
            candRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Candidature candidature = dataSnapshot.getValue(Candidature.class);
                        if(candidature.getRefAnnonce().equals(refAnnonce) && candidature.getEmployeur().equals(userEmail) && candidature.getStatus().equals("acceptee")){
                            ItemCandidatureEmpl item = new ItemCandidatureEmpl(candidature.getNomCandidat(),candidature.getPrenomCandidat(),candidature.getEmail(),candidature.getDate());
                            listCandidaturesItem.add(item);
                        }
                    }
                    afficher(listCandidaturesItem);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        //candidature refusée
        else {
            DatabaseReference candRef = FirebaseDatabase.getInstance().getReference("candidatures");
            candRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Candidature candidature = dataSnapshot.getValue(Candidature.class);
                        if(candidature.getRefAnnonce().equals(refAnnonce) && candidature.getEmployeur().equals(userEmail) && candidature.getStatus().equals("refusee")){
                            ItemCandidatureEmpl item = new ItemCandidatureEmpl(candidature.getNomCandidat(),candidature.getPrenomCandidat(),candidature.getEmail(),candidature.getDate());
                            listCandidaturesItem.add(item);
                        }
                    }
                    afficher(listCandidaturesItem);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    private void afficher(ArrayList<ItemCandidatureEmpl> candidatures) {
        aucune = findViewById(R.id.aucune);
        if(candidatures.isEmpty() && choix.equals("enCours")){
            aucune.setText("Aucune candidature en cours pour cette offre!");
        }else if (candidatures.isEmpty() && choix.equals("acceptee")) {
            aucune.setText("Aucune candidature acceptée pour cette offre!");
        } else if (candidatures.isEmpty() && choix.equals("refusee")) {
            aucune.setText("Aucune candidature refusée pour cette offre!");
        } else {
            recyclerView = findViewById(R.id.recylerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(CandidatureEnCoursEmpl.this));
            recyclerView.setAdapter(new CandidatEmplAdapter(getApplicationContext(), candidatures, this));
        }
    }

    @Override
    public void onItemClick(int position) {
        //afficher le detail de la candidature

    }
}