package com.interim.interim;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.interim.R;
import com.example.interim.databinding.ActivityMesNotifsBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import MesNotifsRecyclerView.ItemNotif;
import MesNotifsRecyclerView.NotifAdapter;
import models.Candidature;

public class MesNotifs extends Drawer_base {

    ActivityMesNotifsBinding act;
    List<ItemNotif> listNotifItem ;
    RecyclerView recyclerView;
    DatabaseReference candidatureRef;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = ActivityMesNotifsBinding.inflate(getLayoutInflater());
        setContentView(act.getRoot());
        allocatedTitle("Mes notifications");

        listNotifItem = new ArrayList<>();

        candidatureRef = FirebaseDatabase.getInstance().getReference("candidatures");
        candidatureRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                    Candidature candidature = datasnapshot.getValue(Candidature.class);
                    if(candidature.getCandidat().equals(userEmail)){
                        ItemNotif notif= new ItemNotif(candidature.getNomEmploi(),candidature.getEmployeur(),candidature.getAdress());
                        listNotifItem.add(notif);
                    }
                }
                for (ItemNotif item : listNotifItem){
                    System.out.println("itemmmmmmmm"+item.getEmployeur());
                }
                afficher(listNotifItem);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void afficher(List<ItemNotif> listNotifItem) {
        recyclerView=findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NotifAdapter(getApplicationContext(),listNotifItem));
    }


}