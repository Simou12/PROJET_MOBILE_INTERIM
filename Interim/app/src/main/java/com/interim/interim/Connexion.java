package com.interim.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interim.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Connexion extends AppCompatActivity {

    private EditText email;
    private EditText mdp;
    private TextView signup;
    private Button btnConx;
    private FirebaseAuth firebaseAuth;
    private String mail,password;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        email = findViewById(R.id.email);
        mdp = findViewById(R.id.mdp);
        btnConx = findViewById(R.id.btnvalid);
        signup = findViewById(R.id.signUp);

        btnConx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail = String.valueOf(email.getText());
                password = String.valueOf(mdp.getText());

                if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(password)){
                    Toast.makeText(Connexion.this, "Veuillez remplir tous les champs!", Toast.LENGTH_SHORT).show();
                }else{
                    firebaseAuth.getInstance().signInWithEmailAndPassword(mail,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                                        if(currentUser.isEmailVerified()){
                                            CurrentUserManager.getInstance().setCurrentUser(currentUser);
                                            Intent intent = new Intent(Connexion.this, Accueil.class);
                                            startActivity(intent);
                                        }else{
                                            Toast.makeText(Connexion.this, "L'email n'est pas vérfié!", Toast.LENGTH_SHORT).show();
                                        }
                                    }else {
                                        Toast.makeText(Connexion.this, "Ce compte n'existe pas!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Connexion.this, Role.class);
                startActivity(intent);
            }
        });
    }
}