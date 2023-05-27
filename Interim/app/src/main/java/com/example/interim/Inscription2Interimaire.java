package com.example.interim;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    String email,mdp,mdpConfirm,telephone;
    private Button btnValider;
    Interimaire candidat;
    String validMDP = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    String mailValid= "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";
    private FirebaseAuth firebaseAuth;
    private DatabaseReference usersRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription2_interimaire);
        initializeComponents();
    }

    private void initializeComponents() {
        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();
        telephoneView = findViewById(R.id.tel);
        emailView = findViewById(R.id.email);
        mdpView = findViewById(R.id.mdp);
        mdpConfirmView=findViewById(R.id.mdpConfirm);
        btnValider = findViewById(R.id.valider);
        Intent intent = getIntent();
        List<String > listInfo =(List<String>) intent.getSerializableExtra("listInfo");
        usersRef = FirebaseDatabase.getInstance().getReference().child("interimaire");
        btnValider.setOnClickListener(View -> {
            email = emailView.getText().toString();
            mdp = mdpView.getText().toString();
            telephone = telephoneView.getText().toString();
            mdpConfirm=mdpConfirmView.getText().toString();

            if(!email.equals("") && !telephone.equals("") && !mdp.equals("") && !mdpConfirm.equals("")){
                telephoneView.setBackgroundResource(R.drawable.edit_background);
                if(mdp.matches(validMDP) && email.matches(mailValid) && mdp.equals(mdpConfirm)){
                    mdpView.setBackgroundResource(R.drawable.edit_background);
                    mdpConfirmView.setBackgroundResource(R.drawable.edit_background);
                    emailView.setBackgroundResource(R.drawable.edit_background);
                    candidat = new Interimaire(listInfo.get(0), listInfo.get(1), listInfo.get(2), telephone, email, mdp,listInfo.get(3));
                    firebaseAuth.createUserWithEmailAndPassword(email, mdp)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                        if (firebaseUser != null) {
                                            String userId = firebaseUser.getUid();
                                            candidat = new Interimaire(listInfo.get(0), listInfo.get(1), listInfo.get(2), telephone, email, mdp,listInfo.get(3));

                                            usersRef.child(userId).setValue(candidat)
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
                }else {
                    if(!mdp.matches(validMDP)){
                        mdpView.setBackgroundResource(R.drawable.error);
                        Toast.makeText(Inscription2Interimaire.this, "Mot de passe doit être de taille 8 et composé de MAJ, MIN de chiffre(s) ", Toast.LENGTH_SHORT).show();
                    }else  mdpView.setBackgroundResource(R.drawable.edit_background);
                    if(!email.matches(mailValid)){
                        emailView.setBackgroundResource(R.drawable.error);
                        Toast.makeText(Inscription2Interimaire.this, "Adresse mail invalide", Toast.LENGTH_SHORT).show();
                    }else  emailView.setBackgroundResource(R.drawable.edit_background);
                    if(!mdp.equals(mdpConfirm)){
                        mdpConfirmView.setBackgroundResource(R.drawable.error);
                        Toast.makeText(Inscription2Interimaire.this, "Mot de passe non confirmé", Toast.LENGTH_SHORT).show();
                    }else mdpConfirmView.setBackgroundResource(R.drawable.edit_background);
                }
            }else {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                if(email.equals(""))   emailView.setBackgroundResource(R.drawable.error);
                if(telephone.equals(""))   telephoneView.setBackgroundResource(R.drawable.error);
                if(mdp.equals(""))   mdpView.setBackgroundResource(R.drawable.error);
                if(mdpConfirm.equals(""))  mdpConfirmView.setBackgroundResource(R.drawable.error);
            }
        });

    }
}
