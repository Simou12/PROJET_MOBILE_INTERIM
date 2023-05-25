package com.interim.interim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.interim.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChoixAbonnement extends AppCompatActivity {

    private Button unMois, indetermine,annuel, mensuel, semestriel, trimestriel;
    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_abonnement);


        FragmentChoixAbonnement firstFragment = new FragmentChoixAbonnement();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, firstFragment)
                .commit();
    }
}