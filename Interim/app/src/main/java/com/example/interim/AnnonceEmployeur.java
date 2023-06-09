package com.example.interim;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.interim.databinding.ActivityAnnonceEmployeurBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

import annonceEmployeurRecyclerView.AnnonceEmployeurAdapter;
import annonceEmployeurRecyclerView.ItemAnnonce;
import models.Offre;

public class AnnonceEmployeur extends Drawer_base implements OnItemClickListener{

    RecyclerView recyclerView;
    ArrayList<ItemAnnonce> listAnnonces;
    ActivityAnnonceEmployeurBinding act;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    TextView aucune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityAnnonceEmployeurBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Mes offres");

        listAnnonces = new ArrayList<>();

        DatabaseReference candRef = FirebaseDatabase.getInstance().getReference("offre");
        candRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Offre offre = dataSnapshot.getValue(Offre.class);
                    if(offre.getPublisher().equals(userEmail)){
                        ItemAnnonce item = new ItemAnnonce(offre.getNom(),offre.getRef());
                        listAnnonces.add(item);
                    }
                }
                afficher(listAnnonces);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void afficher(ArrayList<ItemAnnonce> annonces) {
        if(annonces.isEmpty()){
            aucune = findViewById(R.id.aucune);
            aucune.setText("Vous n'avez aucune annonce publiée");
        }else {
            recyclerView = findViewById(R.id.recylerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(AnnonceEmployeur.this));
            recyclerView.setAdapter(new AnnonceEmployeurAdapter(getApplicationContext(), annonces, this));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent1 = getIntent();
        String choix = intent1.getStringExtra("choix");
        if(choix.equals("enCours")){
            Intent intent = new Intent(AnnonceEmployeur.this, CandidatureEnCoursEmpl.class);
            intent.putExtra("refAnnonce",listAnnonces.get(position).getRefAnnonce());
            intent.putExtra("casChoisis",choix);
            startActivity(intent);
        } else if (choix.equals("acceptee")) {
            Intent intent = new Intent(AnnonceEmployeur.this, CandidatureAccepteEmpl.class);
            intent.putExtra("refAnnonce",listAnnonces.get(position).getRefAnnonce());
            intent.putExtra("casChoisis",choix);
            startActivity(intent);
        }else{
            Intent intent = new Intent(AnnonceEmployeur.this, CandidatureAccepteEmpl.class);
            intent.putExtra("refAnnonce",listAnnonces.get(position).getRefAnnonce());
            intent.putExtra("casChoisis",choix);
            startActivity(intent);
        }

    }
}