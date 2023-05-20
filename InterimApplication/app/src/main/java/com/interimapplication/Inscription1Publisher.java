package com.interimapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import models.Contact;
import models.Employeur;

public class Inscription1Publisher extends AppCompatActivity {
    private EditText nomView,prenomView,telephoneView,emailView, mdpView,mdpConfirmView;;
    private ImageView btnNext;
    private String nom, prenom,telephone,email,mdp,mdpConfirm;
    String validMDP = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    String mailValid= "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription1_publisher);
        initializeCompenents();
    }
    private void initializeCompenents() {
        Intent intent = getIntent();
        Employeur employeur =(Employeur) intent.getSerializableExtra("employeur");
        nomView = findViewById(R.id.nom);
        prenomView = findViewById(R.id.prenom);
        telephoneView = findViewById(R.id.tel);
        emailView = findViewById(R.id.mail1);
        mdpView = findViewById(R.id.mdp);
        mdpConfirmView=findViewById(R.id.mdpConfirm);
        btnNext = findViewById(R.id.next);

        btnNext.setOnClickListener(View -> {
            nom = nomView.getText().toString();
            prenom = prenomView.getText().toString();
            email = emailView.getText().toString();
            mdp = mdpView.getText().toString();
            telephone = telephoneView.getText().toString();
            mdpConfirm=mdpConfirmView.getText().toString();


            if(!nom.equals("") && !prenom.equals("") && !email.equals("") && !telephone.equals("") && !mdp.equals("") && !mdpConfirm.equals("") ){
                nomView.setBackgroundResource(R.drawable.edit_background);
                prenomView.setBackgroundResource(R.drawable.edit_background);
                telephoneView.setBackgroundResource(R.drawable.edit_background);
                if(mdp.matches(validMDP) && email.matches(mailValid) && mdp.equals(mdpConfirm)) {
                    mdpView.setBackgroundResource(R.drawable.edit_background);
                    mdpConfirmView.setBackgroundResource(R.drawable.edit_background);
                    emailView.setBackgroundResource(R.drawable.edit_background);
                    Contact contact1 = new Contact(nom, prenom, telephone, email, mdp);
                    employeur.setContac1(contact1);
                    employeur.setEmail1(email);
                    employeur.setTelephone1(telephone);
                    employeur.setMdp(mdp);
                    Intent intent2 = new Intent(Inscription1Publisher.this, Inscription2Publisher.class);
                    intent2.putExtra("employeur", employeur);
                    startActivity(intent2);
                }else {
                    if(!mdp.matches(validMDP)){
                        mdpView.setBackgroundResource(R.drawable.error);
                        Toast.makeText(Inscription1Publisher.this, "Mot de passe doit être de taille 8 et composé de MAJ, MIN de chiffre(s) ", Toast.LENGTH_SHORT).show();
                    }else  mdpView.setBackgroundResource(R.drawable.edit_background);
                    if(!email.matches(mailValid)){
                        emailView.setBackgroundResource(R.drawable.error);
                        Toast.makeText(Inscription1Publisher.this, "Adresse mail invalide", Toast.LENGTH_SHORT).show();
                    }else  emailView.setBackgroundResource(R.drawable.edit_background);
                    if(!mdp.equals(mdpConfirm)){
                        mdpConfirmView.setBackgroundResource(R.drawable.error);
                        Toast.makeText(Inscription1Publisher.this, "Mot de passe non confirmé", Toast.LENGTH_SHORT).show();
                    }else mdpConfirmView.setBackgroundResource(R.drawable.edit_background);
                }
            }else{
                Toast.makeText(this, "Veuillez remplir tous les champs de saisi SVP", Toast.LENGTH_SHORT).show();
                if (nom.equals("")) nomView.setBackgroundResource(R.drawable.error);
                if (prenom.equals("")) prenomView.setBackgroundResource(R.drawable.error);
                if (email.equals("")) emailView.setBackgroundResource(R.drawable.error);
                if (telephone.equals("")) telephoneView.setBackgroundResource(R.drawable.error);
                if (mdp.equals("")) mdpView.setBackgroundResource(R.drawable.error);
            }
        });
    }
}