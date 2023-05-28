package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.interim.databinding.ActivityHistoriquesBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import OffrePublieeRecyclerView.ItemOffrePubliee;
import OffrePublieeRecyclerView.OffrePublieeAdapter;
import histoRecyclerView.HistoAdapter;
import models.HistoriqueOffre;
import models.Offre;

public class Historiques extends Drawer_base implements OnItemClickListener {

    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    ArrayList<ItemOffrePubliee> listOffres;
    RecyclerView recyclerView;
    TextView aucune;
    ActivityHistoriquesBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityHistoriquesBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Offres supprimées");

        listOffres = new ArrayList<>();

        DatabaseReference offreRef = FirebaseDatabase.getInstance().getReference("histoOffreEmpl");
        offreRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot offreSnapshot : snapshot.getChildren()){
                    HistoriqueOffre offre = offreSnapshot.getValue(HistoriqueOffre.class);
                    if(offre.getPublisher().equals(userEmail)){
                        ItemOffrePubliee item = new ItemOffrePubliee(offre.getNomEmploi(),offre.getDatePublication(),offre.getRef());
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

    @Override
    public void onItemClick(int position) {

    }

    private void afficher(ArrayList<ItemOffrePubliee> list) {
        if(list.isEmpty()){
            aucune = findViewById(R.id.aucune);
            aucune.setText("Vous n'avez aucune offre supprimée.");
        }else {
            recyclerView = findViewById(R.id.recylerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(Historiques.this));
            recyclerView.setAdapter(new HistoAdapter(getApplicationContext(), list,this));
        }
    }
}