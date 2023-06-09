package agence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.interim.R;

import java.util.ArrayList;

import models.Agence;
import models.Employeur;

public class Inscription0Agence extends AppCompatActivity {
    private EditText nomEmpView,departementView,sDepartementView, numNationalView,lienView,adresseView;
    private ImageView btnNext;
    private String nomEmp, departement,sDepartement,numNational,lien,adresse;
    private Agence agence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription0_agence);
        initializeCompenents();
    }

    private void initializeCompenents() {
        nomEmpView = findViewById(R.id.nomEmployeur);
        departementView = findViewById(R.id.departement);
        sDepartementView = findViewById(R.id.sDepartement);
        numNationalView=findViewById(R.id.numNational);
        lienView=findViewById(R.id.lien);
        btnNext = findViewById(R.id.next);
        adresseView=findViewById(R.id.adresse);

        btnNext.setOnClickListener(View -> {
            nomEmp = nomEmpView.getText().toString();
            departement = departementView.getText().toString();
            sDepartement = sDepartementView.getText().toString();
            numNational = numNationalView.getText().toString();
            lien=lienView.getText().toString();
            adresse=adresseView.getText().toString();

            if(!nomEmp.equals("") && !numNational.equals("")  ){
                nomEmpView.setBackgroundResource(R.drawable.edit_background);
                numNationalView.setBackgroundResource(R.drawable.edit_background);
                agence=new Agence(nomEmp,departement,sDepartement,numNational,adresse,lien);
                Intent intent=new Intent(Inscription0Agence.this, Inscription1Agence.class);
                intent.putExtra("agence", agence);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Veuillez remplir les champs de saisi obligatoires SVP", Toast.LENGTH_SHORT).show();
                if(nomEmp.equals("")) nomEmpView.setBackgroundResource(R.drawable.error);
                if(numNational.equals("")) numNationalView.setBackgroundResource(R.drawable.error);
            }
        });
    }
}