package com.example.interim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;;
import android.widget.ImageView;

public class AddOffre extends AppCompatActivity //implements Dialogue.DialogListener
{
    ImageView addOffreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offre);
        initializeCompenents();
    }

    private void initializeCompenents() {
        addOffreView = findViewById(R.id.imageAddOffre);
        addOffreView.setOnClickListener(View -> {
            openDialog();
        });
    }
    public void openDialog(){
        Dialogue dialogue=new Dialogue();
        dialogue.show(getSupportFragmentManager(),"Dialogue");
    }
    public void applyTexts(String nomOffre, String refOffre,String contratType, String dateDeb, String dateFin,String remHoraire,String remMensuelle, String description  ){

    }
}