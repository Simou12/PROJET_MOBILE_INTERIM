package mesEmploiRecyclerView;

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


public class MesEmploisAdapter extends RecyclerView.Adapter<MesEmploisAdapter.MesEmploisViewHolder> {

    Context context;
    List<ItemEmploi> listEmplois;
    private final OnItemClickListener listener;

    public MesEmploisAdapter(Context context, List<ItemEmploi> listEmplois, OnItemClickListener listener) {
        this.context = context;
        this.listEmplois = listEmplois;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MesEmploisAdapter.MesEmploisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MesEmploisViewHolder(LayoutInflater.from(context).inflate(R.layout.item_emploi,parent,false),listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MesEmploisAdapter.MesEmploisViewHolder holder, int position) {
        holder.nomEmploi.setText(listEmplois.get(position).getNomEmploi());
        holder.adress.setText(listEmplois.get(position).getAdress());
        holder.entreprise.setText(listEmplois.get(position).getEntreprise());
    }

    @Override
    public int getItemCount() {
        return listEmplois.size();
    }

    public static class MesEmploisViewHolder extends RecyclerView.ViewHolder{

        TextView nomEmploi, entreprise, adress;

        public MesEmploisViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nomEmploi = itemView.findViewById(R.id.nomEmploi);
            entreprise = itemView.findViewById(R.id.nomEntreprise);
            adress = itemView.findViewById(R.id.adress);

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
