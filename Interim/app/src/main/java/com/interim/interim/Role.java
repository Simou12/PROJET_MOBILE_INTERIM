package com.interim.interim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.interim.R;

public class Role extends AppCompatActivity {

    private Button interimaire;
    private Button employeur;
    private Button agence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        interimaire = findViewById(R.id.bntInterim);
        employeur=findViewById(R.id.btnEmplyeur);
        agence=findViewById(R.id.btnAgence);

        interimaire.setOnClickListener(View ->{
            Intent intent = new Intent(Role.this, Inscription1Interimaire.class);
            startActivity(intent);
        });
        employeur.setOnClickListener(View ->{
            Intent intent = new Intent(Role.this, Inscription1Publisher.class);
            startActivity(intent);
        });

    }
}