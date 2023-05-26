package com.example.interim;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.interim.databinding.ActivityMesEmploisBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import annonceEmployeurRecyclerView.AnnonceEmployeurAdapter;
import annonceEmployeurRecyclerView.ItemAnnonce;
import mesEmploiRecyclerView.ItemEmploi;
import mesEmploiRecyclerView.MesEmploisAdapter;
import models.Emploi;
import models.Offre;

public class MesEmplois extends Drawer_base implements OnItemClickListener {
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    ArrayList<ItemEmploi> listEmplois;
    RecyclerView recyclerView;
    TextView aucune;
    ActivityMesEmploisBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityMesEmploisBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());

        listEmplois = new ArrayList<>();

        DatabaseReference emploiRef = FirebaseDatabase.getInstance().getReference("emploi");
        emploiRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Emploi emploi = dataSnapshot.getValue(Emploi.class);
                    if(emploi.getCandidat().equals(userEmail)){
                        ItemEmploi item = new ItemEmploi(emploi.getNomEmploi(),emploi.getEntreprise(),emploi.getAdress(),emploi.getDate());
                        listEmplois.add(item);
                    }
                }
                afficher(listEmplois);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


    }

    private void afficher(ArrayList<ItemEmploi> list) {
        aucune = findViewById(R.id.aucune);
        if(list.isEmpty()){
            aucune.setText("Vous n'avez aucun emploi!");
        }else {
            recyclerView = findViewById(R.id.recylerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(MesEmplois.this));
            recyclerView.setAdapter(new MesEmploisAdapter(getApplicationContext(), list, this));
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}