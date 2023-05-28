package GestionnaireRecyclerView;

import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.R;

import java.util.List;

import toolsRecyclerView.MyViewHolder;

public class NewInscriptionAdapter extends RecyclerView.Adapter<MyViewHolder2> {
    Context context;
    List<ItemNewInscription> items;
CardView cardView;
    public NewInscriptionAdapter(Context context, List<ItemNewInscription> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder2(LayoutInflater.from(context).inflate(R.layout.item_gestionnaire_demande_inscription,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.nameView.setText(items.get(position).getNom());
        holder.roleView.setText(items.get(position).getRole());
        holder.emailView.setText(items.get(position).getEmail());
        holder.numNationalView.setText(items.get(position).getNumNational());
        holder.departementView.setText(items.get(position).getDepartement());
        holder.sDepartementView.setText(items.get(position).getsDeparement());
        holder.dateInscription.setText(items.get(position).getDateInscription());
        holder.imageView2.setImageResource(items.get(position).getLocal());
        holder.imageView3.setImageResource(items.get(position).getGmail());
        holder.imageView4.setImageResource(items.get(position).getPhone());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of layoutCache
                int visibility = (holder.layoutCache.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(holder.layoutHeader, new AutoTransition());
                holder.layoutCache.setVisibility(visibility);
            }
        });

        holder.btnRefuser.setOnClickListener(View -> {
            holder.cardView.setVisibility(android.view.View.GONE);
        });
        holder.btnAccepter.setOnClickListener(View -> {
            holder.cardView.setVisibility(android.view.View.GONE);
            holder.aucune.setText("Aucune inscription en cours!");
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
