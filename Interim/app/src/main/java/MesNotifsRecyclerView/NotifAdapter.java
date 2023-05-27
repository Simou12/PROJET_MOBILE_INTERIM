package MesNotifsRecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.CurrentUserManager;
import com.example.interim.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.util.List;

import models.Emploi;


public class NotifAdapter extends RecyclerView.Adapter<NotifViewHolder>{

    Context context;
    List<ItemNotif> listNotifs;
    AlertDialog.Builder builder;
    private DatabaseReference emploiRef;
    private String nomEmploi,entreprise,date,ref;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    public NotifAdapter(){}

    public NotifAdapter(Context context, List<ItemNotif> listNotifs) {
        this.context = context;
        this.listNotifs = listNotifs;
    }

    @NonNull
    @Override
    public NotifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotifViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notif_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotifViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.metier.setText(listNotifs.get(position).getMetier());
        holder.employeur.setText(listNotifs.get(position).getEmployeur());
        holder.ref.setText(listNotifs.get(position).getRef());

        nomEmploi = listNotifs.get(position).getMetier();
        entreprise = listNotifs.get(position).getEmployeur();
        ref = listNotifs.get(position).getRef();


        //accepté
        if(listNotifs.get(position).getStatus().equals("acceptee")){
            holder.decision.setText("Accepté");
            holder.accepte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Confirmation avec succès!", Toast.LENGTH_SHORT).show();
                    //recuperer la date actuelle
                    LocalDate currentDate = null;
                    int day=0,month=0,year=0;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        currentDate = LocalDate.now();
                        day = currentDate.getDayOfMonth();
                        month = currentDate.getMonthValue();
                        year = currentDate.getYear();
                    }
                    String acceptationDate = ""+day+"-"+month+"-"+year;

                    //ajouter l'emploi a la bd
                    emploiRef = FirebaseDatabase.getInstance().getReference().child("emploi");
                    String emploiKey = emploiRef.push().getKey();
                    Emploi emploi = new Emploi(nomEmploi,entreprise,listNotifs.get(position).getAdress(),acceptationDate,userEmail);
                    emploiRef.child(emploiKey).setValue(emploi);

                    //supprimer la notif
                    DatabaseReference candRef = FirebaseDatabase.getInstance().getReference().child("candidatures");
                    Query query = candRef.orderByChild("email").equalTo(userEmail);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                // Check if the reference field matches
                                String reference = dataSnapshot.child("refAnnonce").getValue(String.class);
                                if (reference != null && reference.equals(listNotifs.get(position).getRef())) {
                                    // Get the specific child key for updating the status field
                                    String childKey = dataSnapshot.getKey();

                                    // Get a reference to the specific child using the child key
                                    DatabaseReference childRef = candRef.child(childKey);

                                    // Update the status field
                                    childRef.child("status").setValue("accept candidat");
                                }
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            });

            //refuser l'emploi
            holder.rejete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Confirmation avec succès!", Toast.LENGTH_SHORT).show();

                    //supprimer la notif
                    DatabaseReference candRef = FirebaseDatabase.getInstance().getReference().child("candidatures");
                    Query query = candRef.orderByChild("email").equalTo(userEmail);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                // Check if the reference field matches
                                String reference = dataSnapshot.child("refAnnonce").getValue(String.class);
                                if (reference != null && reference.equals(listNotifs.get(position).getRef())) {
                                    // Get the specific child key for updating the status field
                                    String childKey = dataSnapshot.getKey();

                                    // Get a reference to the specific child using the child key
                                    DatabaseReference childRef = candRef.child(childKey);

                                    // Update the status field
                                    childRef.child("status").setValue("refus candidat");
                                }
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            });
        }


        if(listNotifs.get(position).getStatus().equals("refusee")){
            holder.decision.setText("Refusé");
            holder.decision.setTextColor(Color.RED);
            holder.rejete.setVisibility(View.GONE);
            holder.accepte.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listNotifs.size();
    }

}
