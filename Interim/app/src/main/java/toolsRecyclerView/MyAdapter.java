package toolsRecyclerView;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.interim.CurrentUserManager;
import com.example.interim.Postule;
import com.example.interim.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import models.Favoris;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    ArrayList<ItemOffre> listOffres;
    ConstraintLayout layoutCache;
    ConstraintLayout layoutHeader;
    boolean like = false;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();
    private DatabaseReference favoriRef;


    public MyAdapter(Context context, ArrayList<ItemOffre> listOffre) {
        this.context = context;
        this.listOffres = listOffre;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_offre_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nomEmploiView.setText(listOffres.get(position).getNomEmploi());
        holder.employeurView.setText(listOffres.get(position).getEntreprise());
        holder.refOffreView.setText("Réféference : "+listOffres.get(position).getReference());
        holder.contratOffreView.setText(listOffres.get(position).getContrat());
        ///holder.remunerationHeureView.setText("€/Heure : "+listOffres.get(position).getRemuHeure());
        holder.remunerationMoisView.setText(listOffres.get(position).getRemuMois()+"$");
        holder.dateDebView.setText("Debut : "+listOffres.get(position).getDateDeb());
        holder.dateFinView.setText("Fin : "+listOffres.get(position).getDateFin());
        holder.descriptionView.setText(listOffres.get(position).getDescription());
        holder.datePublicationView.setText("Publié le : "+listOffres.get(position).getDatePublication());
        holder.adress.setText(listOffres.get(position).getAdress());

        //postuler
        holder.postuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Postule.class);
                intent.putExtra("offreRef",listOffres.get(position).getReference());
                intent.putExtra("employeur",listOffres.get(position).getEmployeur());
                intent.putExtra("emploi",listOffres.get(position).getNomEmploi());
                intent.putExtra("adress",listOffres.get(position).getAdress());
                intent.putExtra("entreprise",listOffres.get(position).getEntreprise());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        //card click
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of layoutCache
                int visibility = (holder.layoutCache.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(holder.layoutHeader, new AutoTransition());
                holder.layoutCache.setVisibility(visibility);
            }
        });


        //liker
        favoriRef = FirebaseDatabase.getInstance().getReference().child("favoris");
        String favoriKey = favoriRef.push().getKey();

        holder.liker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(like == false){
                    holder.liker.setImageResource(R.drawable.coeur_rempli);
                    like = true;
                    String ref = listOffres.get(position).getReference();
                    String emploi = listOffres.get(position).getNomEmploi();
                    String desc = listOffres.get(position).getDescription();
                    String remuMois = listOffres.get(position).getRemuMois();
                    String remHeure = listOffres.get(position).getRemuHeure();
                    String contrat = listOffres.get(position).getContrat();
                    String debut = listOffres.get(position).getDateDeb();
                    String fin = listOffres.get(position).getDateFin();
                    String employeur = listOffres.get(position).getEmployeur();
                    String adress = listOffres.get(position).getAdress();
                    String datePub = listOffres.get(position).getDatePublication();
                    String entreprise = listOffres.get(position).getEntreprise();

                    Favoris fav = new Favoris(userEmail,ref,emploi,desc,Long.parseLong(remuMois),Long.parseLong(remHeure),contrat,debut,fin,employeur,adress,datePub,entreprise);
                    favoriRef.child(favoriKey).setValue(fav);
                    Toast.makeText(context, "Annonce ajoutée aux favoris!", Toast.LENGTH_SHORT).show();
                }else {
                    holder.liker.setImageResource(R.drawable.coeurnonrempli);
                    like=false;

                    DatabaseReference childRef = favoriRef.child(favoriKey);
                    //supprimer l'offre des favoris
                    childRef.removeValue()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(context, "Annonce supprimée des favoris!", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // An error occurred while removing the child
                                }
                            });
                }

            }
        });



    }

    @Override
    public int getItemCount() {
            return listOffres.size();

    }




}