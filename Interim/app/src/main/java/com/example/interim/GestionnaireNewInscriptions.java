package com.example.interim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.interim.databinding.ActivityGestionnaireNewInscriptionsBinding;

import java.util.ArrayList;
import java.util.List;

import GestionnaireRecyclerView.ItemNewInscription;
import GestionnaireRecyclerView.NewInscriptionAdapter;
import toolsRecyclerView.MyAdapter;

public class GestionnaireNewInscriptions extends Drawer_base {

    private ActivityGestionnaireNewInscriptionsBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityGestionnaireNewInscriptionsBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Nouvelles inscriptions");

        RecyclerView recyclerView = findViewById(R.id.recyclerView2);

        List<ItemNewInscription> items = new ArrayList<ItemNewInscription>();
        items.add(new ItemNewInscription("Atos","Employeur"," 12 rue albert, Montpellier",
                "serviceatos6@gmail.com","0667656434","Numéro national : 000123",
                "RH","Recrutement","Inscrit le : 28/05/2023",R.id.accepter,R.id.refuser,R.drawable.place,R.drawable.gmail,R.drawable.smartphone));


        /*items.add(new ItemNewInscription("AgencyInterim","Agence"," 13 rue boutonnet, Montpellier","guermoucheasma0@gmail.com",
                "0666656433","Numéro national : 000111","RH","Recrutement","Inscrit le : 28/05/2023",R.id.accepter,R.id.refuser,R.drawable.place,R.drawable.gmail,R.drawable.smartphone));*/

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NewInscriptionAdapter(getApplicationContext(),items));
    }
}