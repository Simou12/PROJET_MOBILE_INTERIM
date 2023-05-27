package com.example.interim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class GererEmployeurProfil extends AppCompatActivity {
EditText nomView, adresseView, telView,emailView, ancienMdpView, nvMdpView;
String nom, adresse,tel, email,ancienMdp, nvMdp;
Button valider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerer_employeur_profil);
        nomView=findViewById(R.id.nom);
        adresseView=findViewById(R.id.adresse);
        telView=findViewById(R.id.tel);
        emailView=findViewById(R.id.email);
        ancienMdpView=findViewById(R.id.ancienMdp);
        nvMdpView=findViewById(R.id.mdp);
        valider=findViewById(R.id.valider);
        valider.setOnClickListener(View -> {
            nom=nomView.getText().toString();
            adresse=adresseView.getText().toString();
            tel=telView.getText().toString();
            email=emailView.getText().toString();
            ancienMdp=ancienMdpView.getText().toString();
            nvMdp=nvMdpView.getText().toString();


        });
    }
}