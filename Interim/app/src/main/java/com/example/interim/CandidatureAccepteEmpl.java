package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.interim.databinding.ActivityCandidatureAccepteEmplBinding;
import com.example.interim.databinding.ActivityCandidatureEnCoursEmplBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import candidatureAccepteEmpl.CandidatureAccepteEmplAdapter;
import candidatureEnCoursEmplRecyclerView.CandidatEmplAdapter;
import candidatureEnCoursEmplRecyclerView.ItemCandidatureEmpl;
import models.Candidature;

public class CandidatureAccepteEmpl extends Drawer_base implements OnItemClickListener {

    RecyclerView recyclerView;
    ArrayList<ItemCandidatureEmpl> listCandidaturesItem;
    ActivityCandidatureAccepteEmplBinding act;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    TextView aucune;
    String choix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityCandidatureAccepteEmplBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Candidature acceptées");

        listCandidaturesItem = new ArrayList<>();

        Intent intent = getIntent();
        String refAnnonce = intent.getStringExtra("refAnnonce");
        choix = intent.getStringExtra("casChoisis");

        if(choix.equals("acceptee")){
            allocatedTitle("Candidature acceptées");
        }if(choix.equals("refusee")){
            allocatedTitle("Candidature refusées");
        }

        if(choix.equals("acceptee")) {
            DatabaseReference candRef = FirebaseDatabase.getInstance().getReference("candidatures");
            candRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Candidature candidature = dataSnapshot.getValue(Candidature.class);
                        if (candidature.getRefAnnonce().equals(refAnnonce) && candidature.getEmployeur().equals(userEmail) && candidature.getStatus().equals("acceptee") || candidature.getStatus().equals("accept candidat") || candidature.getStatus().equals("refus candidat")) {
                            ItemCandidatureEmpl item = new ItemCandidatureEmpl(candidature.getNomCandidat(), candidature.getPrenomCandidat(), candidature.getEmail(), candidature.getDate(), candidature.getNationalite(), candidature.getAdress(), candidature.getDateNaissance(), candidature.getLettre(), candidature.getRefAnnonce());
                            listCandidaturesItem.add(item);
                        }
                    }
                    afficher(listCandidaturesItem);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }else {
            //candidatures refusees
            DatabaseReference candRef = FirebaseDatabase.getInstance().getReference("candidatures");
            candRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Candidature candidature = dataSnapshot.getValue(Candidature.class);
                        if(candidature.getRefAnnonce().equals(refAnnonce) && candidature.getEmployeur().equals(userEmail) && candidature.getStatus().equals("refusee")){
                            ItemCandidatureEmpl item = new ItemCandidatureEmpl(candidature.getNomCandidat(),candidature.getPrenomCandidat(),candidature.getEmail(),candidature.getDate(),candidature.getNationalite(),candidature.getAdress(),candidature.getDateNaissance(),candidature.getLettre(),candidature.getRefAnnonce());
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
       if (candidatures.isEmpty() && choix.equals("acceptee")) {
            aucune.setText("Aucune candidature acceptée pour cette offre!");
        } else if (candidatures.isEmpty() && choix.equals("refusee")) {
           aucune.setText("Aucune candidature refusée pour cette offre!");
       } else {
            recyclerView = findViewById(R.id.recylerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(CandidatureAccepteEmpl.this));
            recyclerView.setAdapter(new CandidatureAccepteEmplAdapter(getApplicationContext(), candidatures, this));
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}