package com.example.interim;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import agence.Inscription0Agence;
import models.Gestionnaire;

public class Role extends AppCompatActivity {

    private Button interimaire;
    private Button employeur;
    private Button agence;
    private Button gestionnaire;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference usersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        interimaire = findViewById(R.id.bntInterim);
        employeur=findViewById(R.id.btnEmplyeur);
        agence=findViewById(R.id.btnAgence);
        gestionnaire = findViewById(R.id.btnGestionnaire);

        interimaire.setOnClickListener(View ->{
            Intent intent = new Intent(Role.this, Inscription1Interimaire.class);
            startActivity(intent);
        });
        employeur.setOnClickListener(View ->{
            Intent intent = new Intent(Role.this, Inscription0Publisher.class);
            startActivity(intent);
        });
        agence.setOnClickListener(View ->{
            Intent intent = new Intent(Role.this, Inscription0Agence.class);
            startActivity(intent);
        });

        usersRef = FirebaseDatabase.getInstance().getReference().child("gestionnaire");
        gestionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.createUserWithEmailAndPassword("jobspot42@gmail.com", "azertyui")
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                    if (firebaseUser != null) {
                                        String userId = firebaseUser.getUid();
                                        Gestionnaire ges = new Gestionnaire("jobspot42@gmail.com","azertyui");
                                        usersRef.child(userId).setValue(ges)
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
                                                                        //Toast.makeText(Inscription2Publisher.this, "Email de vérification envoyé!", Toast.LENGTH_SHORT).show();
                                                                    } else {
                                                                        //Toast.makeText(Role.this, "Email de vérification n'a pas été envoyé!", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                }
                                                            });
                                                        } else {
                                                            // Registration failed
                                                            Log.d(TAG, "Registration failed: " + task.getException().getMessage());
                                                            //Toast.makeText(Role.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    }
                                } else {
                                    // Registration failed
                                    Log.d(TAG, "Registration failed2: " + task.getException().getMessage());
                                    //Toast.makeText(Role.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}