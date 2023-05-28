package candidatureAccepteEmpl;

import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.OnItemClickListener;
import com.example.interim.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import candidatureEnCoursEmplRecyclerView.CandidatEmplAdapter;
import candidatureEnCoursEmplRecyclerView.ItemCandidatureEmpl;


public class CandidatureAccepteEmplAdapter extends RecyclerView.Adapter<CandidatureAccepteEmplAdapter.CandidatureAcceptHolderView> {

    Context context;
    List<ItemCandidatureEmpl> listCandidatures;
    private final OnItemClickListener listener;

    public CandidatureAccepteEmplAdapter(Context context, List<ItemCandidatureEmpl> listCandidatures, OnItemClickListener listener) {
        this.context = context;
        this.listCandidatures = listCandidatures;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CandidatureAccepteEmplAdapter.CandidatureAcceptHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CandidatureAcceptHolderView(LayoutInflater.from(context).inflate(R.layout.item_candidature_accepte,parent,false),listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidatureAcceptHolderView holder, int position) {
        holder.nom.setText(listCandidatures.get(position).getNomCandidat()+" "+listCandidatures.get(position).getPrenomCandidat());
        holder.email.setText(listCandidatures.get(position).getEmailCandidat());
        holder.dateCandidature.setText("Date de candidature : "+listCandidatures.get(position).getDateCandidature());
        holder.nationnalité.setText(listCandidatures.get(position).getNationalite());
        holder.adress.setText(listCandidatures.get(position).getAdress());
        holder.dateNaissance.setText("Date de naissance : "+listCandidatures.get(position).getDateNaissance());
        holder.telephone.setText("0612345678");
        holder.lettre.setText(listCandidatures.get(position).getLettre());


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

    }


    @Override
    public int getItemCount() {
        return listCandidatures.size();
    }

    public static class CandidatureAcceptHolderView extends RecyclerView.ViewHolder{

        TextView nom, adress, dateCandidature, email,dateNaissance, telephone, nationnalité,lettre;
        ConstraintLayout layoutCache;
        ConstraintLayout layoutHeader;
        CardView cardView;

        public CandidatureAcceptHolderView(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nom = itemView.findViewById(R.id.nomCandidat);
            email = itemView.findViewById(R.id.email);
            dateCandidature = itemView.findViewById(R.id.dateCandidature);
            adress = itemView.findViewById(R.id.adre);
            dateNaissance = itemView.findViewById(R.id.dateNaissance);
            telephone = itemView.findViewById(R.id.tel);
            nationnalité = itemView.findViewById(R.id.nationnalite);
            lettre = itemView.findViewById(R.id.motivation);
            layoutCache=itemView.findViewById(R.id.layoutCache);
            layoutHeader=itemView.findViewById(R.id.layout1);
            cardView = itemView.findViewById(R.id.card);

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
