package com.interimapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import models.Contact;
import models.Employeur;

public class Inscription2Publisher extends AppCompatActivity {
    private EditText nomView,prenomView,telephoneView,emailView;
    private ImageView btnNext;
    private String nom, prenom,telephone,email;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference usersRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2_publisher);
        Intent intent = getIntent();
        Employeur employeur =(Employeur) intent.getSerializableExtra("employeur");
    }
    private void initializeCompenents() {
        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();
        Intent intent = getIntent();
        Employeur employeur =(Employeur) intent.getSerializableExtra("employeur");
        nomView = findViewById(R.id.nom);
        prenomView = findViewById(R.id.prenom);
        telephoneView = findViewById(R.id.tel);
        emailView = findViewById(R.id.mail1);
        btnNext = findViewById(R.id.next);
        usersRef = FirebaseDatabase.getInstance().getReference().child("employeur");
        btnNext.setOnClickListener(View -> {
            nom = nomView.getText().toString();
            prenom = prenomView.getText().toString();
            email = emailView.getText().toString();
            telephone = telephoneView.getText().toString();
            Contact contact2 = new Contact(nom, prenom, telephone, email, "");
            employeur.setContact2(contact2);
            firebaseAuth.createUserWithEmailAndPassword(employeur.getEmail1(), employeur.getMdp())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                if (firebaseUser != null) {
                                    String userId = firebaseUser.getUid();
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
                                                                    Intent intent = new Intent(Inscription2Publisher.this, Connexion.class);
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
      });
}
}

