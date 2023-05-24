package OffrePublieeRecyclerView;

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

public class OffrePublieeAdapter extends RecyclerView.Adapter<OffrePublieeAdapter.OffreViewHolder> {

    Context context;
    List<ItemOffrePubliee> listOffres;
    private final OnItemClickListener listener;

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

    }

    @Override
    public int getItemCount() {
        return listOffres.size();
    }

    public static class OffreViewHolder extends RecyclerView.ViewHolder{

        TextView nomEmploi, ref, datePublication;

        public OffreViewHolder(@NonNull View itemView, OnItemClickListener listener) {
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
