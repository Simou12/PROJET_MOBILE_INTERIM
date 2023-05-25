package com.interim.interim;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.interim.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.interim.databinding.ActivityEmployeurProfilBinding;

import models.Employeur;

public class EmployeurProfil extends Drawer_base {

    ImageView ajouterOffreView, mesOffres, candidatures, gestionProfil, deconnxion, listNoir;
    TextView nom,role;
    ActivityEmployeurProfilBinding activityEmployeurProfilBinding;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEmployeurProfilBinding = ActivityEmployeurProfilBinding.inflate(getLayoutInflater());
        setContentView(activityEmployeurProfilBinding.getRoot());
        allocatedTitle("Mon profil");
        mesOffres=findViewById(R.id.offreEmp);
        candidatures=findViewById(R.id.candidaturesEmp);
        gestionProfil=findViewById(R.id.gestProfilEmp);
        deconnxion=findViewById(R.id.deconnexionEmp);
        listNoir=findViewById(R.id.listNoirEmp);
        nom = findViewById(R.id.userName);
        role = findViewById(R.id.roleEmp);
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