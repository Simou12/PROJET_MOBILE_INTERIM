package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.interim.databinding.ActivityEmployeurProfilBinding;

import models.Employeur;

public class EmployeurProfil extends Drawer_base {

    TextView ajouterOffreView, nom,role;
    ActivityEmployeurProfilBinding activityEmployeurProfilBinding;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEmployeurProfilBinding = ActivityEmployeurProfilBinding.inflate(getLayoutInflater());
        setContentView(activityEmployeurProfilBinding.getRoot());
        allocatedTitle("Mon profil");

        nom = findViewById(R.id.nom_utilisateur);
        role = findViewById(R.id.role);
        role.setText("Employeur");

        DatabaseReference employeeRef = FirebaseDatabase.getInstance().getReference("employeur");
        employeeRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot emplSnap : snapshot.getChildren()){
                    Employeur empl = emplSnap.getValue(Employeur.class);
                    if(empl.getEmail1().equals(userEmail)){
                        nom.setText(empl.getNom());
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        initializeComponents();
    }
    private void initializeComponents() {
        ajouterOffreView=findViewById(R.id.addOffre);
        ajouterOffreView.setOnClickListener(View -> {
            openDialog();
        });
    }

    public void openDialog(){
        Dialogue dialogue=new Dialogue();
        dialogue.show(getSupportFragmentManager(),"Dialogue");
    }
    public void applyTexts(String nomOffre, String refOffre,String contratType, String dateDeb, String dateFin,String remHoraire,String remMensuelle, String description  ){

    }
}