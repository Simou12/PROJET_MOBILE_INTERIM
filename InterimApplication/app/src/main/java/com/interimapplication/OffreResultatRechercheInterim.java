package com.interimapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import toolsRecyclerView.ItemOffre;
import toolsRecyclerView.MyAdapter;

public class OffreResultatRechercheInterim extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ItemOffre> listOffres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offre_resultat_recherche_interim);
        listOffres=new ArrayList<>();
        /*TODO ajouter les informations récupérer dans cette liste, pour chaque offre il faut créer un objet ItemOffre avec les infos de chaque offre
        */
        recyclerView=findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),listOffres));
    }
}