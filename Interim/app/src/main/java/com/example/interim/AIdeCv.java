package com.example.interim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AIdeCv extends AppCompatActivity {
Button btnShowExemple;
    Dialog myDialog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aide_cv);
        btnShowExemple = findViewById(R.id.exemplecv);
        btnShowExemple.setOnClickListener(View -> {
            myDialog = new Dialog(this);
        });
    }
        public void ShowPopup(View v) {
            myDialog.setContentView(R.layout.image_cv);
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();
        }
}