package com.interim.interim;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.interim.R;

public class FragmentProcederPayement extends Fragment {

    private EditText numCarteView, titulaireView, cvcView;
    private Button valider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.proceder_payement, container, false);

        numCarteView = view.findViewById(R.id.numCarte);
        titulaireView = view.findViewById(R.id.titulaireCarte);
        cvcView = view.findViewById(R.id.cvcCarte);
        valider = view.findViewById(R.id.valider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numCarte = numCarteView.getText().toString();
                String titulaire = titulaireView.getText().toString();
                String cvc = cvcView.getText().toString();

                if(numCarte.length()<10 || numCarte.length()>10){
                    showToast("Le numéro de carte n'est pas valide!");
                } else if (cvc.length()< 3 || cvc.length()>3) {
                    showToast("Le numéro CVC n'est pas valide!");
                } else {
                    startNewActivity();
                }
            }
        });
        return view;
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void startNewActivity() {
        Intent intent = new Intent(requireActivity(), Connexion.class);
        startActivity(intent);
    }
}
