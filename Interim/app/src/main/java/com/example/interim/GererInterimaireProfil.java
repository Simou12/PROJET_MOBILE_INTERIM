package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interim.databinding.ActivityGererInterimaireProfilBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import models.Interimaire;

public class GererInterimaireProfil extends Drawer_base {

    EditText nom, prenom, dateNaissance, telephone, mdp,email, ancienMdp;
    TextView nomPrenomView, dateNaissanceView, mdpView,emailView;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    ActivityGererInterimaireProfilBinding act;
    private DatabaseReference interimaireRef;
    private Button btnValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityGererInterimaireProfilBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Gérer mon profile");

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        dateNaissance = findViewById(R.id.dateNaissance);
        telephone = findViewById(R.id.tel);
        mdp = findViewById(R.id.mdp);
        email = findViewById(R.id.email);
        ancienMdp = findViewById(R.id.ancienMdp);
        btnValider = findViewById(R.id.valider);

        nomPrenomView = findViewById(R.id.nomPrenom);
        dateNaissanceView = findViewById(R.id.dateNaissanceText);
        emailView = findViewById(R.id.emailText);
        mdpView = findViewById(R.id.mdpText);

        //remplir les champs d'avance
        interimaireRef = FirebaseDatabase.getInstance().getReference().child("interimaire");
        interimaireRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot interimairSnap : snapshot.getChildren()){
                    Interimaire candidat = interimairSnap.getValue(Interimaire.class);
                    if(candidat.getEmail().equals(userEmail)){
                        nom.setText(candidat.getNom());
                        nomPrenomView.setText(candidat.getNom()+candidat.getPrenom());
                        prenom.setText(candidat.getPrenom());
                        dateNaissance.setText(candidat.getDateNaissance());
                        dateNaissanceView.setText(candidat.getDateNaissance());
                        email.setText(userEmail);
                        emailView.setText(userEmail);
                        ancienMdp.setText((candidat.getMdp()));
                        mdpView.setText(candidat.getMdp());
                        telephone.setText(candidat.getTelephone());
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = nom.getText().toString();
                String newPrenom = prenom.getText().toString();
                String newDate = dateNaissance.getText().toString();
                String newMdp = mdp.getText().toString();
                String newTel = telephone.getText().toString();


                Query query = interimaireRef.orderByChild("email").equalTo(userEmail);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                            // Get the person ID
                            String personId = dataSnapshot.getKey();

                            // Get a reference to the specific person using their ID
                            DatabaseReference personRef = interimaireRef.child(personId);

                            Map<String, Object> updates = new HashMap<>();
                            updates.put("nom", newName);
                            updates.put("prenom", newPrenom);
                            updates.put("dateNaissance", newDate);
                            updates.put("mdp", newMdp);
                            updates.put("telephone", newTel);

                            personRef.updateChildren(updates)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(GererInterimaireProfil.this, "Votre profil à été mis à jours!", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(GererInterimaireProfil.this, "Mise à jour échouée!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });



    }
}