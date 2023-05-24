package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import models.Abonnement;

public class ChoixAbonnement extends AppCompatActivity {

    private Button unMois, indetermine,annuel, mensuel, semestriel, trimestriel;
    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_abonnement);


        FragmentChoixAbonnement firstFragment = new FragmentChoixAbonnement();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, firstFragment)
                .commit();
    }
}