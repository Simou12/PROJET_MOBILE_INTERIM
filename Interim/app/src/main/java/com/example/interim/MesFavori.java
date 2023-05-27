package com.example.interim;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.databinding.ActivityMesFavoriBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import models.Favoris;
import toolsRecyclerView.ItemOffre;
import toolsRecyclerView.MyAdapter;

public class MesFavori extends Drawer_base{

    RecyclerView recyclerView;
    ArrayList<ItemOffre> listOffresItem;
    TextView aucune;
    ActivityMesFavoriBinding act;
    private String nomEmploi,employeur,entreprise,reference,contrat,remuHeure,remuMois,dateDeb,dateFin,description,datePublication,adress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityMesFavoriBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Mes favoris");

        recyclerView=findViewById(R.id.recylerView);
        listOffresItem = new ArrayList<>();

        DatabaseReference favorisRef = FirebaseDatabase.getInstance().getReference("favoris");
        favorisRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Favoris fav = dataSnapshot.getValue(Favoris.class);
                    if(fav.getCandidatEmail().equals(userEmail)){
                        nomEmploi = fav.getNom();
                        employeur = fav.getPublisher();
                        reference = fav.getRef();
                        contrat = fav.getTypeContrat();
                        remuHeure = Long.toString(fav.getRemunerationHoraire());
                        remuMois = Long.toString(fav.getRemunerationHoraire());
                        dateDeb = fav.getDateDeb();
                        dateFin = fav.getDateFin();
                        description = fav.getDescription();
                        datePublication = fav.getDatePublication();
                        adress = fav.getAdress();
                        entreprise = fav.getEntreprise();
                        ItemOffre item = new ItemOffre(nomEmploi, employeur, reference, contrat, remuHeure, remuMois, dateDeb, dateFin, description, datePublication, adress,entreprise);
                        listOffresItem.add(item);
                    }
                }
                afficher(listOffresItem);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void afficher(ArrayList<ItemOffre> list) {
        aucune = findViewById(R.id.aucune);
        if(list.isEmpty()){
            aucune.setText("Vous n'avez aucune offre enregistrée!");
        }else {
            recyclerView = findViewById(R.id.recylerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(MesFavori.this));
            recyclerView.setAdapter(new MyAdapter(getApplicationContext(), list));
        }
    }

}