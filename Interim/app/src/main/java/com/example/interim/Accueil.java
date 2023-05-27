package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interim.databinding.ActivityAccueilBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import models.Offre;

public class Accueil extends Drawer_base {

    ActivityAccueilBinding activityAccueilBinding;
    private TextView plus, moins, ajouter;
    private EditText loc, periode, contrat, employeur;
    SearchView search;
    ArrayList<Offre> listOffresFinal=new ArrayList<Offre>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAccueilBinding = ActivityAccueilBinding.inflate(getLayoutInflater());
        setContentView(activityAccueilBinding.getRoot());
        allocatedTitle("Accueil");

        loc = findViewById(R.id.loc);
        periode = findViewById(R.id.periode);
        contrat = findViewById(R.id.typeContrat);
        employeur = findViewById(R.id.employeur);
        moins = findViewById(R.id.moins);
        ajouter = findViewById(R.id.ajouter);
        plus = findViewById(R.id.plus);
        search = findViewById(R.id.search);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loc.setVisibility(View.VISIBLE);
                periode.setVisibility(View.VISIBLE);
                contrat.setVisibility(View.VISIBLE);
                employeur.setVisibility(View.VISIBLE);
                plus.setVisibility(View.GONE);
                moins.setVisibility(View.VISIBLE);
                ajouter.setText("Supprimer les filtres");
            }
        });

        moins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loc.setVisibility(View.GONE);
                periode.setVisibility(View.GONE);
                contrat.setVisibility(View.GONE);
                employeur.setVisibility(View.GONE);
                plus.setVisibility(View.VISIBLE);
                moins.setVisibility(View.GONE);
                ajouter.setText("Ajouter un filtre");
            }
        });

        DatabaseReference offreRef = FirebaseDatabase.getInstance().getReference("offre");
        ArrayList<Offre> listOffres = new ArrayList<Offre>();



        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String recherche = query;
                String location = loc.getText().toString();
                String period = periode.getText().toString();
                String contr = contrat.getText().toString();
                String empl = employeur.getText().toString();

                if(TextUtils.isEmpty(recherche)){
                    Toast.makeText(Accueil.this, "Rentrez un nom d'un post!", Toast.LENGTH_SHORT).show();
                } else if (!TextUtils.isEmpty(recherche) && TextUtils.isEmpty(location) && TextUtils.isEmpty(period) && TextUtils.isEmpty(contr) && TextUtils.isEmpty(empl)) {
                    offreRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int totalChildren = (int) snapshot.getChildrenCount();
                            int counter = 0;
                            for(DataSnapshot offreSnap : snapshot.getChildren()){
                                Offre offre = offreSnap.getValue(Offre.class);
                                listOffres.add(offre);

                                counter++;
                                if (counter == totalChildren) {
                                    startMyActivity(listOffres,recherche);
                                }
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });

    }

    private void startMyActivity(ArrayList<Offre> listOffres, String recherche) {

        for(Offre of : listOffres){
            if(of.getNom().equals(recherche)){
                listOffresFinal.add(of);
            }
        }
        Intent intent = new Intent(Accueil.this,OffreResultatRechercheInterim.class);
        intent.putExtra("listOffre", listOffresFinal);
        startActivity(intent);
    }
}
