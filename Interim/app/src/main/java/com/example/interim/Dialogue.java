package com.example.interim;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;

import models.Offre;



public class Dialogue extends AppCompatDialogFragment {
    private EditText nomOffreView, refOffreView, remHorraireView, remMensuelleView, dateDebContratView, dateFinContratView, descriptionView, villeView, paysView,nomEntreprise;
    private Button butValider;
    private Spinner contratView;
    private String nomOffre,entreprise, refOffre, contrat, remHorraire, remMensuelle, dateDeb, dateFin, description, ville, pays;
    // private DialogListener listener;
    private AlertDialog dialog;
    String validDate = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/\\\\d{4}$";
    private DatabaseReference offreRef;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        offreRef = FirebaseDatabase.getInstance().getReference().child("offre");
        builder.setView(view)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        nomOffre = nomOffreView.getText().toString();
                        refOffre = refOffreView.getText().toString();
                        contrat = contratView.getSelectedItem().toString();
                        remHorraire = remHorraireView.getText().toString();
                        remMensuelle = remMensuelleView.getText().toString();
                        dateDeb = dateDebContratView.getText().toString();
                        dateFin = dateFinContratView.getText().toString();
                        description = descriptionView.getText().toString();
                        entreprise = nomEntreprise.getText().toString();
                        ville=villeView.getText().toString();
                        pays=paysView.getText().toString();
                        if (!nomOffre.equals("") && !refOffre.equals("") && !contrat.equals("") && !dateDeb.equals("")) {
                            nomOffreView.setBackgroundResource(R.drawable.edit_background);
                            refOffreView.setBackgroundResource(R.drawable.edit_background);
                            contratView.setBackgroundResource(R.drawable.edit_background);
                            //if (dateDeb.matches(validDate)) {
                            //dateDebContratView.setBackgroundResource(R.drawable.edit_background);
                            //dateFinContratView.setBackgroundResource(R.drawable.edit_background);

                            LocalDate currentDate = null;
                            int day=0,month=0,year=0;
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                currentDate = LocalDate.now();
                                 day = currentDate.getDayOfMonth();
                                 month = currentDate.getMonthValue();
                                 year = currentDate.getYear();
                            }
                            String datePub = ""+day+"-"+month+"-"+year;

                            Offre offre = new Offre(refOffre, nomOffre, description, Long.parseLong(remMensuelle), Long.parseLong(remHorraire), contrat, dateDeb, dateFin, userEmail,ville,pays,datePub,entreprise);
                            String offreKey = offreRef.push().getKey();
                            offreRef.child(offreKey).setValue(offre);
                            Toast.makeText(view.getContext(), "Offre ajoutée!", Toast.LENGTH_SHORT).show();
                            /*} else {
                                if (!dateDeb.matches(validDate)) {
                                    dateDebContratView.setBackgroundResource(R.drawable.error);
                                    Toast.makeText(view.getContext(), "Veuillez saisir une date valide JJ/MM/AAAA", Toast.LENGTH_SHORT).show();
                                } else {
                                    dateDebContratView.setBackgroundResource(R.drawable.edit_background);
                                }*/
                                /*if (!dateFin.equals("") && dateFin.matches(validDate)) {
                                    dateFinContratView.setBackgroundResource(R.drawable.error);
                                    Toast.makeText(view.getContext(), "Veuillez saisir une date valide JJ/MM/AAAA", Toast.LENGTH_SHORT).show();
                                } else {
                                    dateFinContratView.setBackgroundResource(R.drawable.edit_background);
                                }*/
                        }else {
                            Toast.makeText(view.getContext(), "Veuillez remplir tous les champs de saisi obligatoires SVP", Toast.LENGTH_SHORT).show();
                            if (nomOffre.equals(""))
                                nomOffreView.setBackgroundResource(R.drawable.error);
                            if (refOffre.equals(""))
                                refOffreView.setBackgroundResource(R.drawable.error);
                            if (contrat.equals(""))
                                contratView.setBackgroundResource(R.drawable.error);
                            if (dateDeb.equals(""))
                                dateDebContratView.setBackgroundResource(R.drawable.error);
                        }
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button negativeButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_NEGATIVE);
                Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                LinearLayout.LayoutParams negativeButtonParams = (LinearLayout.LayoutParams) negativeButton.getLayoutParams();
                negativeButtonParams.gravity = Gravity.CENTER_HORIZONTAL;
                negativeButton.setLayoutParams(negativeButtonParams);
                LinearLayout.LayoutParams positiveButtonParams = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
                positiveButtonParams.gravity = Gravity.CENTER_HORIZONTAL;
                positiveButton.setLayoutParams(positiveButtonParams);
            }
        });
        nomOffreView = view.findViewById(R.id.nomOffre);
        refOffreView = view.findViewById(R.id.reference);
        contratView = view.findViewById(R.id.contratType);
        remHorraireView = view.findViewById(R.id.salaireHoraire);
        remMensuelleView = view.findViewById(R.id.salaireMensuelle);
        dateDebContratView = view.findViewById(R.id.dateDeb);
        dateFinContratView = view.findViewById(R.id.dateFin);
        descriptionView = view.findViewById(R.id.description);
        villeView=view.findViewById(R.id.ville);
        paysView=view.findViewById(R.id.pays);
        nomEntreprise = view.findViewById(R.id.nomEntreprise);

        return builder.create();
    }
}



