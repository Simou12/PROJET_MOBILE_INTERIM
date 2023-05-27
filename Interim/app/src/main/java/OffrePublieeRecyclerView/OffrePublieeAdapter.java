package OffrePublieeRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.CurrentUserManager;
import com.example.interim.OnItemClickListener;
import com.example.interim.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import models.Emploi;
import models.HistoriqueOffre;

public class OffrePublieeAdapter extends RecyclerView.Adapter<OffrePublieeAdapter.OffreViewHolder> {

    Context context;
    List<ItemOffrePubliee> listOffres;
    private final OnItemClickListener listener;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    public OffrePublieeAdapter(Context context, List<ItemOffrePubliee> listOffres, OnItemClickListener listener) {
        this.context = context;
        this.listOffres = listOffres;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OffrePublieeAdapter.OffreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OffreViewHolder(LayoutInflater.from(context).inflate(R.layout.item_offre_employeur,parent,false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull OffrePublieeAdapter.OffreViewHolder holder, int position) {
        holder.nomEmploi.setText(listOffres.get(position).getNomEmploi());
        holder.ref.setText(listOffres.get(position).getRef());
        holder.datePublication.setText(listOffres.get(position).getDatePublication());
        holder.supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //supprimer une offre

                //l'ajouter dans l'historique
                DatabaseReference histoRef = FirebaseDatabase.getInstance().getReference("histoOffreEmpl");
                String offreKey = histoRef.push().getKey();
                HistoriqueOffre histo = new HistoriqueOffre(listOffres.get(position).getNomEmploi(),listOffres.get(position).getDatePublication(),listOffres.get(position).getRef(),userEmail);
                histoRef.child(offreKey).setValue(histo);

                //la supprimer de la table offre
                DatabaseReference offreRef = FirebaseDatabase.getInstance().getReference("offre");
                offreRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot offreSnapshot : dataSnapshot.getChildren()) {
                            // Get the value of the "name" and "ref" properties for each row
                            String name = offreSnapshot.child("nom").getValue(String.class);
                            String ref = offreSnapshot.child("ref").getValue(String.class);

                            if (name != null && ref != null && name.equals(listOffres.get(position).getNomEmploi()) && ref.equals(listOffres.get(position).getRef())) {
                                // Delete the row
                                offreSnapshot.getRef().removeValue();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle any errors that occur during data retrieval
                    }
                });
                Toast.makeText(context, "L'offre a été déplacée dans vos historiques!", Toast.LENGTH_SHORT).show();
                holder.supprimer.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listOffres.size();
    }

    public static class OffreViewHolder extends RecyclerView.ViewHolder{

        TextView nomEmploi, ref, datePublication;
        Button  supprimer;

        public OffreViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nomEmploi = itemView.findViewById(R.id.nomEmploi);
            ref = itemView.findViewById(R.id.ref);
            datePublication = itemView.findViewById(R.id.datePublication);
            supprimer = itemView.findViewById(R.id.supprimer);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            listener.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
