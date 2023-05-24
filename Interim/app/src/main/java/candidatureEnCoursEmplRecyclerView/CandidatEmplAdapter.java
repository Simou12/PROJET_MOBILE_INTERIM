package candidatureEnCoursEmplRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.OnItemClickListener;
import com.example.interim.R;

import java.util.List;


public class CandidatEmplAdapter extends RecyclerView.Adapter<CandidatEmplAdapter.CandidatureHolderView> {

    Context context;
    List<ItemCandidatureEmpl> listCandidatures;
    private final OnItemClickListener listener;

    public CandidatEmplAdapter(Context context, List<ItemCandidatureEmpl> listCandidatures, OnItemClickListener listener) {
        this.context = context;
        this.listCandidatures = listCandidatures;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CandidatEmplAdapter.CandidatureHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CandidatureHolderView(LayoutInflater.from(context).inflate(R.layout.item_candidature_en_cours,parent,false),listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidatEmplAdapter.CandidatureHolderView holder, int position) {
        holder.nom.setText(listCandidatures.get(position).getNomCandidat());
        holder.prenom.setText(listCandidatures.get(position).getPrenomCandidat());
        holder.email.setText(listCandidatures.get(position).getEmailCandidat());
        holder.dateCandidature.setText(listCandidatures.get(position).getDateCandidature());

    }

    @Override
    public int getItemCount() {
        return listCandidatures.size();
    }

    public static class CandidatureHolderView extends RecyclerView.ViewHolder{

        TextView nom, prenom, dateCandidature, email;

        public CandidatureHolderView(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nom = itemView.findViewById(R.id.nomCandidat);
            prenom = itemView.findViewById(R.id.prenomCandidat);
            email = itemView.findViewById(R.id.email);
            dateCandidature = itemView.findViewById(R.id.dateCandidature);

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
