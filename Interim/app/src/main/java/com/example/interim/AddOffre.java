package com.example.interim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interim.databinding.ActivityAddOffreBinding;

public class AddOffre extends Drawer_base //implements Dialogue.DialogListener
{
    ImageView addOffreView, addAll;
    Uri fileUri;
    TextView fichier;
    ActivityAddOffreBinding act;
    Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityAddOffreBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Ajout offre");

        fichier = findViewById(R.id.offres);
        addOffreView = findViewById(R.id.imageAddOffre);
        addOffreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initializeCompenents();
            }
        });

        addAll = findViewById(R.id.imageAddOffres);
        addAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFile();
            }
        });

        valider = findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddOffre.this, "Vos offres ont été publiées avec succès!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initializeCompenents() {
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

    private void selectFile(){
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && data.getData() != null && data != null) {
            fileUri = data.getData();

            //displaying the file name in the TextView
            String fileName = getFileName(fileUri);
            addAll.setVisibility(View.GONE);
            fichier.setText("Mes_offres.pdf");
        }
    }

    @SuppressLint("Range")
    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }
        }
        if (result == null) {
            result = uri.getPath();
            int slashIndex = result.lastIndexOf('/');
            if (slashIndex != -1) {
                result = result.substring(slashIndex + 1);
            }
        }
        return result;
    }
}