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
import retrofit.RetrofitService;
import retrofit.UserApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

            RetrofitService retrofitService = new RetrofitService();
            UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

            Call<Interimaire> callCandidat = userApi.getCandidatByEmail(mail);
            callCandidat.enqueue(new Callback<Interimaire>() {
                @Override
                public void onResponse(Call<Interimaire> call, Response<Interimaire> response) {
                    Interimaire candidat = response.body();
                    if (candidat.equals(null)){
                        Toast.makeText(Connexion.this, "Ce compte n'existe pas!", Toast.LENGTH_SHORT).show();
                    }else {
                        startActivity(new Intent(Connexion.this,Accueil.class));
                    }
                }
                @Override
                public void onFailure(Call<Interimaire> call, Throwable t) {
                    Toast.makeText(Connexion.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
                    Log.e("Eroooor : ",t.getMessage());
                }
            });
        });
    }
}
