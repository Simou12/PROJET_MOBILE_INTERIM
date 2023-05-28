package annonceEmployeurRecyclerView;

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


public class AnnonceEmployeurAdapter extends RecyclerView.Adapter<AnnonceEmployeurAdapter.AnnonceViewHolder>{

    Context context;
    List<ItemAnnonce> listAnnonce;
    private final OnItemClickListener listener;

    public AnnonceEmployeurAdapter(Context context, List<ItemAnnonce> listAnnonce, OnItemClickListener listener) {
        this.context = context;
        this.listAnnonce = listAnnonce;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnnonceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnnonceViewHolder(LayoutInflater.from(context).inflate(R.layout.item_annonce_employeur,parent,false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnonceViewHolder holder, int position) {
        holder.nomEmploi.setText(listAnnonce.get(position).getNomEmploi());
        holder.refAnnonce.setText("Ref : "+listAnnonce.get(position).getRefAnnonce());

    }

    @Override
    public int getItemCount() {
        return listAnnonce.size();
    }


    //view holder
    public static class AnnonceViewHolder extends RecyclerView.ViewHolder{

        TextView nomEmploi, refAnnonce;

        public AnnonceViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nomEmploi = itemView.findViewById(R.id.nomEmploi);
            refAnnonce = itemView.findViewById(R.id.ref);

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
