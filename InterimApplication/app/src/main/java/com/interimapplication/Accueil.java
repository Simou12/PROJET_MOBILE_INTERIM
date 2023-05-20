package com.interimapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.interimapplication.databinding.ActivityAccueilBinding;
import com.interimapplication.databinding.ActivityDrawerBaseBinding;

public class Accueil extends Drawer_base {

    ActivityAccueilBinding activityAccueilBinding;
    private TextView plus;
    private TextView loc;
    private TextView periode;
    private TextView contrat;
    private TextView employeur;
    private TextView moins;
    private TextView ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAccueilBinding = ActivityAccueilBinding.inflate(getLayoutInflater());
        setContentView(activityAccueilBinding.getRoot());
        allocatedTitle("Accueil");

        loc = findViewById(R.id.loc);
        periode = findViewById(R.id.periode);
        contrat = findViewById(R.id.typeContrat);
        employeur = findViewById(R.id.employeur);
        moins = findViewById(R.id.moins);
        ajouter = findViewById(R.id.ajouter);

        plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loc.setVisibility(View.VISIBLE);
                periode.setVisibility(View.VISIBLE);
                contrat.setVisibility(View.VISIBLE);
                employeur.setVisibility(View.VISIBLE);
                plus.setVisibility(View.GONE);
                moins.setVisibility(View.VISIBLE);
                ajouter.setText("Supprimer les filtres");
            }
        });

        moins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loc.setVisibility(View.GONE);
                periode.setVisibility(View.GONE);
                contrat.setVisibility(View.GONE);
                employeur.setVisibility(View.GONE);
                plus.setVisibility(View.VISIBLE);
                moins.setVisibility(View.GONE);
                ajouter.setText("Ajouter un filtre");
            }
        });

    }
}