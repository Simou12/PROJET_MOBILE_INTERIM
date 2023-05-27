package com.example.interim;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.example.interim.databinding.ActivityPostuleBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.time.LocalDate;

import models.Candidature;
import models.Interimaire;

public class Postule extends Drawer_base {

    ActivityPostuleBinding activityPostuleBinding;
    private EditText nom, prenom, dateNaissance,lettreMotivation, nationalite;
    private ImageView envoyer;
    TextView cv;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    private DatabaseReference candidatureRef;
    private DatabaseReference interimaireRef;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageReference;
    private static final int FILE_REQUEST_CODE = 1;
    String cvUriString;
    Uri fileUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPostuleBinding = ActivityPostuleBinding.inflate(getLayoutInflater());
        setContentView(activityPostuleBinding.getRoot());
        allocatedTitle("Postuler");

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        dateNaissance = findViewById(R.id.dateNaissance);
        lettreMotivation = findViewById(R.id.motivation);
        envoyer = findViewById(R.id.next);
        cv = findViewById(R.id.cv);
        nationalite = findViewById(R.id.nationnalite);

        candidatureRef = FirebaseDatabase.getInstance().getReference().child("candidatures");
        String candidatureKey = candidatureRef.push().getKey();
        cvUriString = candidatureKey+".pdf";
        Uri cvUri = Uri.parse(cvUriString);

        //remplir les champs d'avance
        interimaireRef = FirebaseDatabase.getInstance().getReference().child("interimaire");
        interimaireRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot interimairSnap : snapshot.getChildren()){
                    Interimaire candidat = interimairSnap.getValue(Interimaire.class);
                    if(candidat.getEmail().equals(userEmail)){
                        nom.setText(candidat.getNom());
                        prenom.setText(candidat.getPrenom());
                        dateNaissance.setText(candidat.getDateNaissance());
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        //telecharger le cv
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*StorageReference resumeRef = storageReference.child("CVs/" + candidatureKey + ".pdf");
                UploadTask uploadTask = resumeRef.putFile(cvUri);*/
                selectFile();
            }
        });


        //soumettre la candidature
        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nom.getText().toString();
                String firstName = prenom.getText().toString();
                String birthDay = dateNaissance.getText().toString();
                String lettre = lettreMotivation.getText().toString();
                String nationnalite = nationalite.getText().toString();
                Intent intent = getIntent();
                String offreRef = intent.getStringExtra("offreRef");
                String employeur = intent.getStringExtra("employeur");
                String nomEmploi = intent.getStringExtra("emploi");
                String adress = intent.getStringExtra("adress");
                String entreprise = intent.getStringExtra("entreprise");

                //recuperer la date actuelle
                LocalDate currentDate = null;
                int day=0,month=0,year=0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    currentDate = LocalDate.now();
                    day = currentDate.getDayOfMonth();
                    month = currentDate.getMonthValue();
                    year = currentDate.getYear();
                }
                String dateCandidature = ""+day+"-"+month+"-"+year;

                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(firstName) || TextUtils.isEmpty(birthDay)){
                    Toast.makeText(view.getContext(), "Veuillez remplir tous les champs!", Toast.LENGTH_SHORT).show();
                }else{
                    saveFile();
                    Candidature candidature = new Candidature(name,firstName,offreRef,employeur,dateCandidature,"en attente",cvUriString,nomEmploi,adress,userEmail,entreprise,nationnalite, birthDay,lettre);
                    candidatureRef.child(candidatureKey).setValue(candidature);
                    Toast.makeText(view.getContext(), "Candidature soumise!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveFile() {
        storageReference = storage.getReference("CVs/popo");
        storageReference.putFile(fileUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(Postule.this, "File uploaded successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Postule.this, "File upload failed: ", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void selectFile(){
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,100);
    }

    /*private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(Intent.createChooser(intent, "Select a PDF file"), FILE_REQUEST_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Please install a file manager app.", Toast.LENGTH_SHORT).show();
        }
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && data.getData() != null && data != null) {
            fileUri = data.getData();

            //displaying the file name in the TextView
            String fileName = getFileName(fileUri);
            cv.setText(fileName);
        }
    }

    @SuppressLint("Range")
    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }
        }
        if (result == null) {
            result = uri.getPath();
            int slashIndex = result.lastIndexOf('/');
            if (slashIndex != -1) {
                result = result.substring(slashIndex + 1);
            }
        }
        return result;
    }
}