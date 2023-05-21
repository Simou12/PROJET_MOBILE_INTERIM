package com.interimapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProfilEmployeur extends AppCompatActivity {

    TextView ajouterOffreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_employeur);
    }
    private void initializeComponents() {
        ajouterOffreView=findViewById(R.id.addOffre);
        ajouterOffreView.setOnClickListener(View -> {
            Intent intent=new Intent(ProfilEmployeur.this,AddOffreEmp.class);
            startActivity(intent);
        });
    }

}