package com.example.interim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import GestionnaireRecyclerView.ItemNewInscription;
import GestionnaireRecyclerView.NewInscriptionAdapter;
import toolsRecyclerView.MyAdapter;

public class GestionnaireNewInscriptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionnaire_new_inscriptions);
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);

        List<ItemNewInscription> items = new ArrayList<ItemNewInscription>();
        items.add(new ItemNewInscription("Atos","Employeur"," 12 rue albert, Montpellier","serviceatos6@gmail.com","0667656434","Numéro national : 000123","","","Inscrit le : 28/05/2023",R.id.accepter,R.id.refuser,R.drawable.calendrier,R.drawable.place,R.drawable.gmail,R.drawable.smartphone));
        items.add(new ItemNewInscription("AgencyInterim","Agence"," 13 rue boutonnet, Montpellier","jobspot42@gmail.com","0666656433","Numéro national : 000111","","","Inscrit le : 28/05/2023",R.id.accepter,R.id.refuser,R.drawable.calendrier,R.drawable.place,R.drawable.gmail,R.drawable.smartphone));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NewInscriptionAdapter(getApplicationContext(),items));
    }
}