package com.example.interim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.interim.Inscription2Interimaire;
import com.example.interim.R;

import java.util.ArrayList;


public class Inscription1Interimaire extends AppCompatActivity {

    private EditText nomView,prenomView,dateNaissanceView,adressView;
    private ImageView btnNext;
    private String nom, prenom,dateNaissance,adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription1_interimaire);

        initializeCompenents();
    }


    private void initializeCompenents() {
        nomView = findViewById(R.id.nom);
        prenomView = findViewById(R.id.prenom);
        dateNaissanceView = findViewById(R.id.dateNaissance);
        btnNext = findViewById(R.id.next);
        adressView = findViewById(R.id.adresse);

        btnNext.setOnClickListener(View -> {
            nom = nomView.getText().toString();
            prenom = prenomView.getText().toString();
            dateNaissance = dateNaissanceView.getText().toString();
            adress = adressView.getText().toString();

            if(!nom.equals("") && !prenom.equals("") && !dateNaissance.equals("") && !adress.equals("") ){
                if(nom.equals("")) nomView.setBackgroundResource(R.drawable.edit_background);
                if(prenom.equals("")) prenomView.setBackgroundResource(R.drawable.edit_background);
                if(dateNaissance.equals("")) dateNaissanceView.setBackgroundResource(R.drawable.edit_background);
                if(adress.equals("")) adressView.setBackgroundResource(R.drawable.edit_background);
                ArrayList<String> listInfo=new ArrayList<String>();
                listInfo.add(nom);
                listInfo.add(prenom);
                listInfo.add(dateNaissance);
                listInfo.add(adress);
                Intent intent=new Intent(Inscription1Interimaire.this, Inscription2Interimaire.class);
                intent.putExtra("listInfo", listInfo);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Veuillez remplir tous les champs de saisi SVP", Toast.LENGTH_SHORT).show();
                if(nom.equals("")) nomView.setBackgroundResource(R.drawable.error);
                if(prenom.equals("")) prenomView.setBackgroundResource(R.drawable.error);
                if(dateNaissance.equals("")) dateNaissanceView.setBackgroundResource(R.drawable.error);
                if(adress.equals("")) adressView.setBackgroundResource(R.drawable.error);
            }
        });

    }
}
