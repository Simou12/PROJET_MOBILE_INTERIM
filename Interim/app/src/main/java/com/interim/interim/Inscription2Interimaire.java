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

import models.Interimaire;

public class Inscription2Interimaire extends AppCompatActivity {

    private EditText telephoneView,emailView, mdpView,mdpConfirmView;
    private String email,mdp,mdpConfirm,telephone;
    private Button btnValider;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference usersRef;
    List<String > listInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2_interimaire);

        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();

        telephoneView = findViewById(R.id.tel);
        emailView = findViewById(R.id.email);
        mdpView = findViewById(R.id.mdp);
        mdpConfirmView=findViewById(R.id.mdpConfirm);
        btnValider = findViewById(R.id.valider);
        Intent intent = getIntent();
        listInfo =(List<String>) intent.getSerializableExtra("listInfo");


        // Get a reference to the "users" node
        usersRef = FirebaseDatabase.getInstance().getReference().child("interimaire");

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve user input from the form fields
                email = emailView.getText().toString().trim();
                mdp = mdpView.getText().toString().trim();
                mdpConfirm = mdpConfirmView.getText().toString().trim();
                telephone = telephoneView.getText().toString().trim();
                String nom = listInfo.get(0);
                String prenom = listInfo.get(1);
                String dateNaissance = listInfo.get(2);


                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(mdp) || TextUtils.isEmpty(nom)) {
                    Toast.makeText(Inscription2Interimaire.this, "Veuillez remplir les champs!", Toast.LENGTH_SHORT).show();
                }


                firebaseAuth.createUserWithEmailAndPassword(email, mdp)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                    if (firebaseUser != null) {
                                        String userId = firebaseUser.getUid();

                                        Interimaire interimaire = new Interimaire(nom, prenom, dateNaissance, telephone, email, mdp);

                                        usersRef.child(userId).setValue(interimaire)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            // Registration successful
                                                            Log.d(TAG, "Registration successful!");
                                                            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                @Override
                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                    if(task.isSuccessful()){
                                                                        Toast.makeText(Inscription2Interimaire.this, "Email de vérification envoyé!", Toast.LENGTH_SHORT).show();
                                                                        Intent intent = new Intent(Inscription2Interimaire.this, Connexion.class);
                                                                        startActivity(intent);
                                                                    }else {
                                                                        Toast.makeText(Inscription2Interimaire.this, "Email de vérification na pas été envoyé!", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                }
                                                            });
                                                        } else {
                                                            // Registration failed
                                                            Log.d(TAG, "Registration failed: " + task.getException().getMessage());
                                                            Toast.makeText(Inscription2Interimaire.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    }
                                } else {
                                    // Registration failed
                                    Log.d(TAG, "Registration failed2: " + task.getException().getMessage());
                                    Toast.makeText(Inscription2Interimaire.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

}

