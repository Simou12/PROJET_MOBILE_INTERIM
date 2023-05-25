package com.interim.interim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.interim.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import models.Abonnement;

public class FragmentChoixAbonnement extends Fragment {

    private Button unMois, indetermine, annuel, mensuel, semestriel, trimestriel;
    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choix_abonnement, container, false);

        unMois = view.findViewById(R.id.unMois);
        indetermine = view.findViewById(R.id.indetermine);
        annuel = view.findViewById(R.id.annuel);
        mensuel = view.findViewById(R.id.mensuel);
        semestriel = view.findViewById(R.id.semestriel);
        trimestriel = view.findViewById(R.id.trimestriel);

        unMois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(currentUser.isEmailVerified()){
                    CurrentUserManager.getInstance().setCurrentUser(currentUser);
                    Abonnement abonnement = new Abonnement(15,"Mensuel",userEmail);
                    DatabaseReference abonnementRef = FirebaseDatabase.getInstance().getReference().child("abonnement");
                    abonnementRef.setValue(abonnement)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    showToast("Abonnement ajouté!");
                                    FragmentProcederPayement secondFragment = new FragmentProcederPayement();
                                    requireActivity().getSupportFragmentManager().beginTransaction()
                                            .replace(R.id.fragment_container, secondFragment)
                                            .commit();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });
                /*}else {
                   showToast("Veuillez valider votre adresse mail d'abord!");
                }*/
            }
        });

        return view;
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}