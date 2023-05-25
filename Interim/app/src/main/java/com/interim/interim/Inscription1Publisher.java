package com.interim.interim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.interim.R;

import java.util.ArrayList;

public class Inscription1Publisher extends AppCompatActivity {

    private EditText nomView,departView,sousDepartView, numEntiteView, contact1View, contact2View;
    private ImageView btnNext;
    private String nom, depart,sousDepart, numEntite,contact1,contact2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription1_publisher);

        nomView = findViewById(R.id.nom);
        departView = findViewById(R.id.depart);
        sousDepartView = findViewById(R.id.sousDepart);
        numEntiteView = findViewById(R.id.numEntite);
        contact1View = findViewById(R.id.contact1);
        contact2View = findViewById(R.id.contact2);
        btnNext = findViewById(R.id.next);


        btnNext.setOnClickListener(View -> {
            nom = nomView.getText().toString();
            depart = departView.getText().toString();
            sousDepart = sousDepartView.getText().toString();
            numEntite = numEntiteView.getText().toString();
            contact1 = contact1View.getText().toString();
            contact2 = contact2View.getText().toString();


            if(!nom.equals("") && !numEntite.equals("") ){
                ArrayList<String> listInfo=new ArrayList<String>();
                listInfo.add(nom);
                listInfo.add(depart);
                listInfo.add(sousDepart);
                listInfo.add(numEntite);
                listInfo.add(contact1);
                listInfo.add(contact2);
                Intent intent=new Intent(Inscription1Publisher.this, Inscription2Publisher.class);
                intent.putExtra("listInfo", listInfo);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Veuillez remplir tous les champs de saisi SVP", Toast.LENGTH_SHORT).show();
                if(nom.equals("")) nomView.setBackgroundResource(R.drawable.error);
                if(numEntite.equals("")) numEntiteView.setBackgroundResource(R.drawable.error);
            }
        });
    }
}