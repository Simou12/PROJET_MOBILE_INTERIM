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

public class OffreResultatRechercheInterim extends Drawer_base {

    RecyclerView recyclerView;
    ArrayList<ItemOffre> listOffresItem;
    ArrayList<Offre> listOffres;
    ActivityOffreResultatRechercheInterimBinding act;
    AtomicInteger counter = new AtomicInteger(0);
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

        // Initialize a counter for completed Firebase callbacks
        final int totalItems = listOffres.size();


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

            /*recyclerView.setLayoutManager(new LinearLayoutManager(OffreResultatRechercheInterim.this));
            recyclerView.setAdapter(new MyAdapter(getApplicationContext(), listOffresItem));*/

            /* Recuperer le nom de l'entreprise
            String publisherEmail = offre.getPublisher();
            DatabaseReference emplRef = FirebaseDatabase.getInstance().getReference("employeur");
            emplRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot emplSnap : snapshot.getChildren()) {
                        Employeur empl = emplSnap.getValue(Employeur.class);
                        if (empl.getEmail1().equals(publisherEmail)) {
                            employeur = empl.getNom();

                            ItemOffre item = new ItemOffre(nomEmploi, employeur, reference, contrat, remuHeure, remuMois, dateDeb, dateFin, description, datePublication, adress);
                            listOffresItem.add(item);

                            // Increment the counter
                            int count = counter.incrementAndGet();

                            // Check if all callbacks have finished
                            if (count == totalItems) {
                                recyclerView.setLayoutManager(new LinearLayoutManager(OffreResultatRechercheInterim.this));
                                recyclerView.setAdapter(new MyAdapter(getApplicationContext(), listOffresItem));
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle onCancelled if needed
                }
            });*/
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(OffreResultatRechercheInterim.this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), listOffresItem));
    }


    /*
    private void fetchData(DataRetrievalCallback callback) {

        Intent intent = getIntent();
        listOffres = (ArrayList<Offre>) intent.getSerializableExtra("listOffre");
        listOffresItem=new ArrayList<>();

        int i = 0;
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

            String publisherEmail = offre.getPublisher();
            DatabaseReference emplRef = FirebaseDatabase.getInstance().getReference("employeur");
            emplRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot emplSnap : snapshot.getChildren()) {
                        Employeur empl = emplSnap.getValue(Employeur.class);
                        if (empl.getEmail1().equals(publisherEmail)) {
                            employeur = empl.getNom();
                            ItemOffre item = new ItemOffre(nomEmploi, employeur, reference, contrat, remuHeure, remuMois, dateDeb, dateFin, description, datePublication, adress);
                            listOffresItem.add(item);
                        }
                    }
                    // Notify the callback with the retrieved data
                    callback.onDataRetrieved(listOffresItem);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }*/

}