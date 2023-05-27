package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import AnnonceAnonymeRecyclerView.AnnonceAnonymeAdapter;
import annonceEmployeurRecyclerView.AnnonceEmployeurAdapter;
import models.Offre;
import toolsRecyclerView.ItemOffre;

public class AccueilAnonyme extends AppCompatActivity implements OnItemClickListener{

    RecyclerView recyclerView;
    ArrayList<ItemOffre> listOffresItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_anonyme);

        Intent intent = getIntent();
        String choix = intent.getStringExtra("choix");

        listOffresItem = new ArrayList<>();

        if(choix.equals("yes")){
            DatabaseReference offreRef = FirebaseDatabase.getInstance().getReference("offre");
            offreRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot offreSnap : snapshot.getChildren()){
                        Offre offre = offreSnap.getValue(Offre.class);
                        if(offre.getVille().equals("Montpellier")){
                            String adress = offre.getVille()+", "+offre.getPays();
                            ItemOffre item = new ItemOffre(offre.getNom(),offre.getPublisher(),offre.getRef(),offre.getTypeContrat(),Long.toString(offre.getRemunerationHoraire()),Long.toString(offre.getRemunerationMensuelle()),offre.getDateDeb(),offre.getDateFin(),offre.getDescription(),offre.getDatePublication(),adress,offre.getEntreprise());
                            listOffresItem.add(item);
                        }
                        afficher(listOffresItem);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }else {
            DatabaseReference offreRef = FirebaseDatabase.getInstance().getReference("offre");
            offreRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot offreSnap : snapshot.getChildren()){
                        Offre offre = offreSnap.getValue(Offre.class);
                        String adress = offre.getVille()+", "+offre.getPays();
                        ItemOffre item = new ItemOffre(offre.getNom(),offre.getPublisher(),offre.getRef(),offre.getTypeContrat(),Long.toString(offre.getRemunerationHoraire()),Long.toString(offre.getRemunerationMensuelle()),offre.getDateDeb(),offre.getDateFin(),offre.getDescription(),offre.getDatePublication(),adress,offre.getEntreprise());
                        listOffresItem.add(item);
                        }
                        afficher(listOffresItem);
                    }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    private void afficher(ArrayList<ItemOffre> list) {
        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(AccueilAnonyme.this));
        recyclerView.setAdapter(new AnnonceAnonymeAdapter(getApplicationContext(), list,this));
    }

    @Override
    public void onItemClick(int position) {
        //afficher le detail de l'offre
    }
}