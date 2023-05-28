package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.interim.databinding.ActivityMesOffresBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import InterimaireCandidatureRecyclerView.MesCandidaturesAdapter;
import OffrePublieeRecyclerView.ItemOffrePubliee;
import OffrePublieeRecyclerView.OffrePublieeAdapter;
import models.Offre;

public class MesOffres extends Drawer_base implements OnItemClickListener {

    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    ArrayList<ItemOffrePubliee> listOffres;
    RecyclerView recyclerView;
    TextView aucune;
    ActivityMesOffresBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityMesOffresBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Mes offres");

        listOffres = new ArrayList<>();

        DatabaseReference offreRef = FirebaseDatabase.getInstance().getReference("offre");
        offreRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot offreSnapshot : snapshot.getChildren()){
                    Offre offre = offreSnapshot.getValue(Offre.class);
                    if(offre.getPublisher().equals(userEmail)){
                        ItemOffrePubliee item = new ItemOffrePubliee(offre.getNom(),offre.getDatePublication(),offre.getRef());
                        listOffres.add(item);
                    }
                }
                afficher(listOffres);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void afficher(ArrayList<ItemOffrePubliee> list) {
        if(list.isEmpty()){
            aucune = findViewById(R.id.aucune);
            aucune.setText("Vous n'avez aucune offre.");
        }else {
            recyclerView = findViewById(R.id.recylerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(MesOffres.this));
            recyclerView.setAdapter(new OffrePublieeAdapter(getApplicationContext(), list,this));
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}