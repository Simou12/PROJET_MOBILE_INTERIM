package histoRecyclerView;

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

import OffrePublieeRecyclerView.ItemOffrePubliee;
import models.Emploi;
import models.HistoriqueOffre;

public class HistoAdapter extends RecyclerView.Adapter<HistoAdapter.HistoViewHolder> {

    Context context;
    List<ItemOffrePubliee> listOffres;
    private final OnItemClickListener listener;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

    public HistoAdapter(Context context, List<ItemOffrePubliee> listOffres, OnItemClickListener listener) {
        this.context = context;
        this.listOffres = listOffres;
        this.listener = listener;
    }


    @NonNull
    @Override
    public HistoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_hiso,parent,false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoViewHolder holder, int position) {
        holder.nomEmploi.setText(listOffres.get(position).getNomEmploi());
        holder.ref.setText(listOffres.get(position).getRef());
        holder.datePublication.setText(listOffres.get(position).getDatePublication());
    }

    @Override
    public int getItemCount() {
        return listOffres.size();
    }

    public static class HistoViewHolder extends RecyclerView.ViewHolder{

        TextView nomEmploi, ref, datePublication;


        public HistoViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nomEmploi = itemView.findViewById(R.id.nomEmploi);
            ref = itemView.findViewById(R.id.ref);
            datePublication = itemView.findViewById(R.id.datePublication);

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
