package com.interim.interim;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.interim.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import models.Employeur;

public class Inscription2Publisher extends AppCompatActivity {

    private EditText tel1View,tel2View,adressView, email1View,email2View, mdpView,lienView;
    private String tel1,tel2,email1,email2,mdp,adress,lien;
    private Button btnValider;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference usersRef;
    List<String > listInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2_publisher);

        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();

        tel1View = findViewById(R.id.tel1);
        tel2View = findViewById(R.id.tel2);
        email1View = findViewById(R.id.email1);
        email2View = findViewById(R.id.email2);
        mdpView = findViewById(R.id.mdp);
        adressView = findViewById(R.id.adress);
        lienView = findViewById(R.id.lien);
        btnValider = findViewById(R.id.valider);
        Intent intent = getIntent();
        listInfo =(List<String>) intent.getSerializableExtra("listInfo");

        // Get a reference to the "users" node
        usersRef = FirebaseDatabase.getInstance().getReference().child("employeur");

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve user input from the form fields
                email1 = email1View.getText().toString().trim();
                email2 = email2View.getText().toString().trim();
                mdp = mdpView.getText().toString().trim();
                tel1 = tel1View.getText().toString().trim();
                tel2 = tel2View.getText().toString().trim();
                adress = adressView.getText().toString().trim();
                lien = lienView.getText().toString().trim();
                String nom = listInfo.get(0);
                String depart = listInfo.get(1);
                String sousDepart = listInfo.get(2);
                String numEntite = listInfo.get(3);
                String contact1 = listInfo.get(4);
                String contact2 = listInfo.get(5);

                if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(mdp) || TextUtils.isEmpty(adress)) {
                    Toast.makeText(Inscription2Publisher.this, "Veuillez renseigner les champs obligatoires!", Toast.LENGTH_SHORT).show();
                }else {
                    firebaseAuth.createUserWithEmailAndPassword(email1, mdp)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                        if (firebaseUser != null) {
                                            String userId = firebaseUser.getUid();

                                            Employeur employeur = new Employeur( nom, depart,  sousDepart,  numEntite,  contact1,  contact2, adress,  tel1,  tel2, email1, email2, mdp, lien);

                                            usersRef.child(userId).setValue(employeur)
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                // Registration successful
                                                                Log.d(TAG, "Registration successful!");
                                                                firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                        if (task.isSuccessful()) {
                                                                            Toast.makeText(Inscription2Publisher.this, "Email de vérification envoyé!", Toast.LENGTH_SHORT).show();
                                                                            Intent intent = new Intent(Inscription2Publisher.this, ChoixAbonnement.class);
                                                                            startActivity(intent);
                                                                        } else {
                                                                            Toast.makeText(Inscription2Publisher.this, "Email de vérification n'a pas été envoyé!", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    }
                                                                });
                                                            } else {
                                                                // Registration failed
                                                                Log.d(TAG, "Registration failed: " + task.getException().getMessage());
                                                                Toast.makeText(Inscription2Publisher.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    });
                                        }
                                    } else {
                                        // Registration failed
                                        Log.d(TAG, "Registration failed2: " + task.getException().getMessage());
                                        Toast.makeText(Inscription2Publisher.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });


    }
}