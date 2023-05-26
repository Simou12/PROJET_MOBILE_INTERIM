package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.interim.databinding.ActivityOffreResultatRechercheInterimBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import models.Employeur;
import models.Offre;
import toolsRecyclerView.ItemOffre;
import toolsRecyclerView.MyAdapter;

public class OffreResultatRechercheInterim extends Drawer_base{

    RecyclerView recyclerView;
    ArrayList<ItemOffre> listOffresItem;
    ArrayList<Offre> listOffres;
    ActivityOffreResultatRechercheInterimBinding act;
    private String nomEmploi,employeur,entreprise,reference,contrat,remuHeure,remuMois,dateDeb,dateFin,description,datePublication,adress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityOffreResultatRechercheInterimBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Offres");

        recyclerView=findViewById(R.id.recylerView);

        Intent intent = getIntent();
        listOffres = (ArrayList<Offre>) intent.getSerializableExtra("listOffre");

        listOffresItem = new ArrayList<>();


        for (Offre offre : listOffres) {
            nomEmploi = offre.getNom();
            reference = offre.getRef();
            contrat = offre.getTypeContrat();
            remuHeure = Long.toString(offre.getRemunerationHoraire());
            remuMois = Long.toString(offre.getRemunerationMensuelle());
            dateDeb = offre.getDateDeb();
            dateFin = offre.getDateFin();
            description = offre.getDescription();
            datePublication = offre.getDatePublication();
            adress = offre.getVille() + ", " + offre.getPays();
            entreprise  = offre.getEntreprise();
            employeur = offre.getPublisher();


            ItemOffre item = new ItemOffre(nomEmploi, employeur, reference, contrat, remuHeure, remuMois, dateDeb, dateFin, description, datePublication, adress,entreprise);
            listOffresItem.add(item);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(OffreResultatRechercheInterim.this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), listOffresItem));
    }

}