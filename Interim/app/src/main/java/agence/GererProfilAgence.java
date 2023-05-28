package agence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interim.CurrentUserManager;
import com.example.interim.Drawer_base;
import com.example.interim.R;
import com.example.interim.databinding.ActivityGererEmployeurProfilBinding;
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

import models.Agence;
import models.Employeur;
import models.Interimaire;

public class GererProfilAgence extends Drawer_base {

    EditText nomView, adresseView, telView,emailView, ancienMdpView, nvMdpView;
    TextView nomtxt, adrestxt, teltxt,emailtxt,mdptxt,numNational;
    String nom, adresse,tel, email,ancienMdp, nvMdp;
    Button valider;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    private DatabaseReference employeurRef;

    ActivityGererEmployeurProfilBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityGererEmployeurProfilBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Gérer mon profile");

        nomView=findViewById(R.id.nom);
        adresseView=findViewById(R.id.adresse);
        telView=findViewById(R.id.tel);
        emailView=findViewById(R.id.email);
        ancienMdpView=findViewById(R.id.ancienMdp);
        nvMdpView=findViewById(R.id.mdp);
        valider=findViewById(R.id.valider);

        nomtxt = findViewById(R.id.nomEntreprise);
        adrestxt = findViewById(R.id.adresseText);
        teltxt = findViewById(R.id.telephone);
        emailtxt = findViewById(R.id.emailText);
        mdptxt = findViewById(R.id.mdpText);
        numNational = findViewById(R.id.numNational);

        //remplir les champs d'avance
        employeurRef = FirebaseDatabase.getInstance().getReference().child("agence");
        employeurRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot interimairSnap : snapshot.getChildren()){
                    Agence candidat = interimairSnap.getValue(Agence.class);
                    if(candidat.getEmail1().equals(userEmail)){
                        nomtxt.setText(candidat.getNom());
                        nomView.setText(candidat.getNom());

                        numNational.setText(candidat.getNumEntreprise());

                        adrestxt.setText(candidat.getAdresse());
                        adresseView.setText(candidat.getAdresse());

                        teltxt.setText(candidat.getTelephone1());

                        emailtxt.setText(candidat.getEmail1());
                        emailView.setText(candidat.getEmail1());

                        ancienMdpView.setText(candidat.getMdp());
                        mdptxt.setText(candidat.getMdp());

                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });


        valider.setOnClickListener(View -> {
            Toast.makeText(GererProfilAgence.this, "Votre profil à été mis à jours!", Toast.LENGTH_SHORT).show();
            nom=nomView.getText().toString();
            adresse=adresseView.getText().toString();
            tel=telView.getText().toString();
            email=emailView.getText().toString();
            ancienMdp=ancienMdpView.getText().toString();
            nvMdp=nvMdpView.getText().toString();

            Query query = employeurRef.orderByChild("email").equalTo(userEmail);
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                        // Get the person ID
                        String personId = dataSnapshot.getKey();

                        // Get a reference to the specific person using their ID
                        DatabaseReference personRef = employeurRef.child(personId);

                        Map<String, Object> updates = new HashMap<>();
                        updates.put("nom", nom);
                        updates.put("adresse", adresse);
                        updates.put("telephone1", tel);
                        updates.put("email1", email);
                        updates.put("mdp", nvMdp);

                        personRef.updateChildren(updates)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(GererProfilAgence.this, "Votre profil à été mis à jours!", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(GererProfilAgence.this, "Mise à jour échouée!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        });


    }
}