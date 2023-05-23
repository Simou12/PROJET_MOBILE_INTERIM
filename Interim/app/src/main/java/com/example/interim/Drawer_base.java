package com.example.interim;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import models.Employeur;
import models.Interimaire;


public class Drawer_base extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    String role = "";


    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base,null);
        FrameLayout container = drawerLayout.findViewById(R.id.activity_container);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.menu_drawer_open,R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()){
            case R.id.home :
                startActivity(new Intent(this,Accueil.class));
                overridePendingTransition(0,0);
                break;
            case R.id.profil :
                // Check "employee" table
                DatabaseReference employeeRef = FirebaseDatabase.getInstance().getReference("employeur");
                employeeRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        boolean employeeExist = false;
                        for (DataSnapshot employeeSnapshot : snapshot.getChildren()){
                            Employeur empl = employeeSnapshot.getValue(Employeur.class);
                            if(empl.getEmail1().equals(userEmail)){
                                employeeExist = true;
                                break;
                            }
                        }
                        if(employeeExist){
                            startActivity(new Intent(Drawer_base.this,EmployeurProfil.class));
                            overridePendingTransition(0,0);
                        }else{
                            DatabaseReference interimaireRef = FirebaseDatabase.getInstance().getReference("interimaire");
                            interimaireRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    boolean interimaireExist = false;
                                    for (DataSnapshot interimaireSnapshot : snapshot.getChildren()){
                                        Interimaire inter = interimaireSnapshot.getValue(Interimaire.class);
                                        if(inter.getEmail().equals(userEmail)){
                                            interimaireExist = true;
                                            break;
                                        }
                                    }
                                    if(interimaireExist){
                                        startActivity(new Intent(Drawer_base.this,InterimaireProfil.class));
                                        overridePendingTransition(0,0);
                                    }
                                }
                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                break;

            case R.id.deconect:
                startActivity(new Intent(this,MainActivity.class));
                overridePendingTransition(0,0);
                break;
            /*case R.id.candidatures:
                startActivity(new Intent(this,MesCandidatures.class));
                overridePendingTransition(0,0);
                break;*/
        }
        return false;
    }

    protected void allocatedTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    public String checkProfilEmployee(){
        // Check "employee" table
        DatabaseReference employeeRef = FirebaseDatabase.getInstance().getReference("employeur");
        employeeRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean employeeExist = false;
                for (DataSnapshot employeeSnapshot : snapshot.getChildren()){
                    Employeur empl = employeeSnapshot.getValue(Employeur.class);
                    if(empl.getEmail1().equals(userEmail)){
                        employeeExist = true;
                        role = "employeur";
                        break;
                    }
                }
                if(!employeeExist){
                    role = checkProfilInterimaire();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return role;

        /*Query employeeQuery = employeeRef.orderByChild("email1").equalTo(userEmail);
        employeeQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    role = "employeur";
                }else{
                    // Check "interimaire" table
                    DatabaseReference candidateRef = FirebaseDatabase.getInstance().getReference().child("interimaire");
                    Query candidateQuery = candidateRef.orderByChild("email").equalTo(userEmail);
                    candidateQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                role = "interimaire";
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
    }

    public String checkProfilInterimaire(){
        DatabaseReference employeeRef = FirebaseDatabase.getInstance().getReference("interimaire");
        employeeRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean interimaireExist = false;
                for (DataSnapshot interimaireSnapshot : snapshot.getChildren()){
                    Interimaire inter = interimaireSnapshot.getValue(Interimaire.class);
                    if(inter.getEmail().equals(userEmail)){
                        interimaireExist = true;
                        role = "interimaire";
                        break;
                    }
                }
                if(!interimaireExist){
                    role = "aucun";
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return role;
    }
}