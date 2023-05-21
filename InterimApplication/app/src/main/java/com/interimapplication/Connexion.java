package com.interimapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import models.Interimaire;


public class Connexion extends AppCompatActivity {
    private EditText email;
    private EditText mdp;
    private Button btnConx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_connexion);

        initializeCompenents();
    }

    private void initializeCompenents() {
        email = findViewById(R.id.email);
        mdp = findViewById(R.id.mdp);
        btnConx = findViewById(R.id.btnvalid);

        btnConx.setOnClickListener(View -> {
            String mail = email.getText().toString();
            String password = mdp.getText().toString();


        });
    }
}
