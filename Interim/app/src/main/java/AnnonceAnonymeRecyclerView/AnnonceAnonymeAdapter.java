package AnnonceAnonymeRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.Connexion;
import com.example.interim.CurrentUserManager;
import com.example.interim.OnItemClickListener;
import com.example.interim.Postule;
import com.example.interim.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import toolsRecyclerView.ItemOffre;

public class AnnonceAnonymeAdapter extends RecyclerView.Adapter<AnnonceAnonymeAdapter.AnnonceAnonymeViewHolder> {

    Context context;
    ArrayList<ItemOffre> listOffres;
    ConstraintLayout layoutCache;
    ConstraintLayout layoutHeader;
    private final OnItemClickListener listener;

    public AnnonceAnonymeAdapter(Context context, ArrayList<ItemOffre> listOffres, OnItemClickListener listener) {
        this.context = context;
        this.listOffres = listOffres;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnnonceAnonymeAdapter.AnnonceAnonymeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnnonceAnonymeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_annonce_anonyme,parent,false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnonceAnonymeAdapter.AnnonceAnonymeViewHolder holder, int position) {
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

        //postuler
        holder.postuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Veuillez vous inscrire d'abord!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Connexion.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listOffres.size();
    }

    public static class AnnonceAnonymeViewHolder extends RecyclerView.ViewHolder {
        TextView nomEmploiView, employeurView, refOffreView, contratOffreView, remunerationHeureView,
                remunerationMoisView, dateDebView, dateFinView, descriptionView, datePublicationView, adress;
        ImageView traduction, partager;
        Button postuler;
        ConstraintLayout layoutCache;
        ConstraintLayout layoutHeader;
        CardView cardView;

        public AnnonceAnonymeViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nomEmploiView = itemView.findViewById(R.id.nomPostePub);
            employeurView = itemView.findViewById(R.id.nomEmployeurPub);
            refOffreView = itemView.findViewById(R.id.ref);
            contratOffreView = itemView.findViewById(R.id.ContratPub);
            //remunerationHeureView=itemView.findViewById(R.id.remTitle);
            remunerationMoisView = itemView.findViewById(R.id.remTitle);
            dateDebView = itemView.findViewById(R.id.dateDebPub);
            dateFinView = itemView.findViewById(R.id.dateFinPub);
            descriptionView = itemView.findViewById(R.id.description);
            datePublicationView = itemView.findViewById(R.id.datePublication);
            adress = itemView.findViewById(R.id.adre);

            postuler = itemView.findViewById(R.id.postuler);
            traduction = itemView.findViewById(R.id.traduction);
            partager = itemView.findViewById(R.id.share);

            layoutCache = itemView.findViewById(R.id.layoutCache);
            layoutHeader = itemView.findViewById(R.id.layout1);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
