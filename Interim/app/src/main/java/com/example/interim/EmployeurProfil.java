package com.example.interim;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
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

    TextView ajouterOffreView, nom,role, gestionCand,offrePubliee;
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
        gestionCand = findViewById(R.id.gestionCand);
        offrePubliee = findViewById(R.id.mesOffres);
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


        gestionCand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOverflowMenu(view);
            }
        });

        offrePubliee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmployeurProfil.this,MesOffres.class);
                startActivity(intent);
            }
        });
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

    private void showOverflowMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
        popupMenu.inflate(R.menu.overflow_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.enCours:
                        Intent intent1 = new Intent(EmployeurProfil.this, AnnonceEmployeur.class);
                        intent1.putExtra("choix","enCours");
                        startActivity(intent1);
                        return true;
                    case R.id.acceptee:
                        Intent intent2 = new Intent(EmployeurProfil.this, AnnonceEmployeur.class);
                        intent2.putExtra("choix","acceptee");
                        startActivity(intent2);
                        return true;
                    case R.id.refusee:
                        Intent intent3 = new Intent(EmployeurProfil.this, AnnonceEmployeur.class);
                        intent3.putExtra("choix","refusee");
                        startActivity(intent3);
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }
}