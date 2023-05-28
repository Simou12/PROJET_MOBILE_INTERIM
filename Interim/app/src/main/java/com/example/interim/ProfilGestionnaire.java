package com.example.interim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfilGestionnaire extends AppCompatActivity {
ImageView newInscriptionView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_gestionnaire);
        newInscriptionView=findViewById(R.id.ajoutOffreEmp);
        newInscriptionView.setOnClickListener(View->{
            Intent intent=new Intent(this,GestionnaireNewInscriptions.class);
            startActivity(intent);
        });
    }
}