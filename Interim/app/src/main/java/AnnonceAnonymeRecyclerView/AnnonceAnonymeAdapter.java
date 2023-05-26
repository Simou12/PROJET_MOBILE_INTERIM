package AnnonceAnonymeRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.OnItemClickListener;
import com.example.interim.R;

import java.util.ArrayList;

import toolsRecyclerView.ItemOffre;

public class AnnonceAnonymeAdapter extends RecyclerView.Adapter<AnnonceAnonymeAdapter.AnnonceAnonymeViewHolder> {

    Context context;
    ArrayList<ItemOffre> listOffres;
    private final OnItemClickListener listener;

    public AnnonceAnonymeAdapter(Context context, ArrayList<ItemOffre> listOffres, OnItemClickListener listener) {
        this.context = context;
        this.listOffres = listOffres;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnnonceAnonymeAdapter.AnnonceAnonymeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnnonceAnonymeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_offre_employeur,parent,false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnonceAnonymeAdapter.AnnonceAnonymeViewHolder holder, int position) {
        holder.nomEmploi.setText(listOffres.get(position).getNomEmploi());
        //holder.entreprise.setText(listOffres.get(position).getEntreprise());
        holder.adress.setText(listOffres.get(position).getAdress());
        holder.datePublication.setText(listOffres.get(position).getDatePublication());

    }

    @Override
    public int getItemCount() {
        return listOffres.size();
    }

    public static class AnnonceAnonymeViewHolder extends RecyclerView.ViewHolder{

        TextView nomEmploi, entreprise, adress, datePublication;

        public AnnonceAnonymeViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nomEmploi = itemView.findViewById(R.id.nomPostePub);
            //entreprise = itemView.findViewById(R.id.employeurPub);
            adress = itemView.findViewById(R.id.adress);
            datePublication = itemView.findViewById(R.id.datePublication);
        }
    }
}
