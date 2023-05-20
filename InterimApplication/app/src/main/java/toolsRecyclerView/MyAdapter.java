package toolsRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.interimapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<ItemOffre> listOffres;
    public MyAdapter(){}
    public MyAdapter(Context context, List<ItemOffre> listOffres) {
        this.context = context;
        this.listOffres = listOffres;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_offre_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nomEmploiView.setText(listOffres.get(position).getNomEmploi());
        holder.employeurView.setText(listOffres.get(position).getEmployeur());
        holder.refOffreView.setText(listOffres.get(position).getReference());
        holder.contratOffreView.setText(listOffres.get(position).getContrat());
        holder.remunerationHeureView.setText(listOffres.get(position).getRemuHeure());
        holder.remunerationMoisView.setText(listOffres.get(position).getRemuMois());
        holder.dateDebView.setText(listOffres.get(position).getDateDeb());
        holder.dateFinView.setText(listOffres.get(position).getDateFin());
        holder.descriptionView.setText(listOffres.get(position).getDescription());
        holder.datePublicationView.setText(listOffres.get(position).getDatePublication());
        holder.imageAdd.setImageResource(R.drawable.add);

    }

    @Override
    public int getItemCount() {
        return listOffres.size();
    }
}
