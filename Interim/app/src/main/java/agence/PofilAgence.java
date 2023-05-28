package agence;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.interim.AddOffre;
import com.example.interim.AnnonceEmployeur;
import com.example.interim.CurrentUserManager;
import com.example.interim.Dialogue;
import com.example.interim.Drawer_base;
import com.example.interim.Historiques;
import com.example.interim.MainActivity;
import com.example.interim.MesOffres;
import com.example.interim.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.interim.databinding.ActivityEmployeurProfilBinding;

import models.Employeur;

public class PofilAgence extends Drawer_base {

    TextView  nom,role;
    ImageView gestionCand,offrePubliee, ajouterOffreView,deconnexion;
    ActivityEmployeurProfilBinding activityEmployeurProfilBinding;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEmployeurProfilBinding = ActivityEmployeurProfilBinding.inflate(getLayoutInflater());
        setContentView(activityEmployeurProfilBinding.getRoot());
        allocatedTitle("Mon profil");

        nom = findViewById(R.id.userName);
        gestionCand = findViewById(R.id.candidaturesEmp);
        offrePubliee = findViewById(R.id.offreEmp);
        role = findViewById(R.id.roleEmp);
        role.setText("Agence");
        deconnexion = findViewById(R.id.deconnexionEmp);

        DatabaseReference employeeRef = FirebaseDatabase.getInstance().getReference("agence");
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

        ajouterOffreView = findViewById(R.id.ajoutOffreEmp);
        ajouterOffreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PofilAgence.this, AddOffre.class);
                startActivity(intent);
            }
        });

        //initializeComponents();

        deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PofilAgence.this, MainActivity.class));
            }
        });


        gestionCand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOverflowMenu(view);
            }
        });

        offrePubliee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOverflowMenu2(view);
                /*Intent intent = new Intent(EmployeurProfil.this,MesOffres.class);
                startActivity(intent);*/
            }
        });
    }
    private void initializeComponents() {
        ajouterOffreView=findViewById(R.id.ajoutOffreEmp);
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

    private void showOverflowMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
        popupMenu.inflate(R.menu.overflow_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.enCours:
                        Intent intent1 = new Intent(PofilAgence.this, AnnonceEmployeur.class);
                        intent1.putExtra("choix","enCours");
                        startActivity(intent1);
                        return true;
                    case R.id.acceptee:
                        Intent intent2 = new Intent(PofilAgence.this, AnnonceEmployeur.class);
                        intent2.putExtra("choix","acceptee");
                        startActivity(intent2);
                        return true;
                    case R.id.refusee:
                        Intent intent3 = new Intent(PofilAgence.this, AnnonceEmployeur.class);
                        intent3.putExtra("choix","refusee");
                        startActivity(intent3);
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

    private void showOverflowMenu2(View v) {
        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
        popupMenu.inflate(R.menu.hiso);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.enCours:
                        Intent intent = new Intent(PofilAgence.this, MesOffres.class);
                        startActivity(intent);
                        return true;
                    case R.id.passe:
                        Intent intent2 = new Intent(PofilAgence.this, Historiques.class);
                        startActivity(intent2);
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }
}