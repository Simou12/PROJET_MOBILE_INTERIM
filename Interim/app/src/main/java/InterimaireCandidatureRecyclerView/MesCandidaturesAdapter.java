package InterimaireCandidatureRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.OnItemClickListener;
import com.example.interim.R;

import java.util.List;

public class MesCandidaturesAdapter extends RecyclerView.Adapter<MesCandidaturesAdapter.CandidatureViewHolder> {

    Context context;
    List<ItemCandidature> listCandidatures;
    private final OnItemClickListener listener;

    public MesCandidaturesAdapter(Context context, List<ItemCandidature> listCandidatures, OnItemClickListener listener) {
        this.context = context;
        this.listCandidatures = listCandidatures;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MesCandidaturesAdapter.CandidatureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CandidatureViewHolder(LayoutInflater.from(context).inflate(R.layout.item_interimaire_candidatures,parent,false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MesCandidaturesAdapter.CandidatureViewHolder holder, int position) {
        holder.nomEmploi.setText(listCandidatures.get(position).getNomEmploi());
        holder.entreprise.setText(listCandidatures.get(position).getEntreprise());
        holder.ref.setText("Ref : "+listCandidatures.get(position).getRef());
        holder.dateCandidature.setText("Date de candidature : "+listCandidatures.get(position).getDateCandidature());
        holder.adress.setText((listCandidatures.get(position).getAdress()));
        if(listCandidatures.get(position).getStatus().equals("acceptee")){
            holder.traitementCand.setImageResource(R.drawable.accepte);
        }else if(listCandidatures.get(position).getStatus().equals("refusee")){
            holder.traitementCand.setImageResource(R.drawable.rejeter);;
        }else if (listCandidatures.get(position).getStatus().equals("en attente")){
            holder.traitementCand.setImageResource(R.drawable.encours);
        }
    }

    @Override
    public int getItemCount() {
        return listCandidatures.size();
    }

    public static class CandidatureViewHolder extends RecyclerView.ViewHolder{

        TextView nomEmploi, entreprise,dateCandidature,ref, adress;
        ImageView traitementCand;

        public CandidatureViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nomEmploi = itemView.findViewById(R.id.nomPostePub);
            entreprise = itemView.findViewById(R.id.nomEmployeurPub);
            dateCandidature = itemView.findViewById(R.id.dateCandidature);
            ref = itemView.findViewById(R.id.ref);
            adress = itemView.findViewById(R.id.adress);
            traitementCand = itemView.findViewById(R.id.traitementCand);

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
