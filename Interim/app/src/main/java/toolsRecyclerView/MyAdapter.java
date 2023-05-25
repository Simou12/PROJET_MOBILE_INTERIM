package toolsRecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.interim.interim.Postule;
import com.example.interim.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    ArrayList<ItemOffre> listOffres;

    public MyAdapter(){}
    public MyAdapter(Context context, ArrayList<ItemOffre> listOffres) {
        this.context = context;
        this.listOffres = listOffres;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_offre_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nomEmploiView.setText(listOffres.get(position).getNomEmploi());
        holder.employeurView.setText("Employeur : "+listOffres.get(position).getEntreprise());
        holder.refOffreView.setText("Réféference : "+listOffres.get(position).getReference());
        holder.contratOffreView.setText("Type Contract : "+listOffres.get(position).getContrat());
        holder.remunerationHeureView.setText("€/Heure : "+listOffres.get(position).getRemuHeure());
        holder.remunerationMoisView.setText("€/Mois : "+listOffres.get(position).getRemuMois());
        holder.dateDebView.setText("Debut du contrat : "+listOffres.get(position).getDateDeb());
        holder.dateFinView.setText("Fin du contrat : "+listOffres.get(position).getDateFin());
        holder.descriptionView.setText(listOffres.get(position).getDescription());
        holder.datePublicationView.setText("Date de publication : "+listOffres.get(position).getDatePublication());
        holder.imageAdd.setImageResource(R.drawable.add);
        holder.adress.setText("Adress : "+listOffres.get(position).getAdress());
        //the overflow menu
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOverflowMenu(view);
            }
        });

        //postuler
       holder.postuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Postule.class);
                intent.putExtra("offreRef",listOffres.get(position).getReference());
                intent.putExtra("employeur",listOffres.get(position).getEmployeur());
                intent.putExtra("emploi",listOffres.get(position).getNomEmploi());
                intent.putExtra("adress",listOffres.get(position).getAdress());
                intent.putExtra("entreprise",listOffres.get(position).getEntreprise());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOffres.size();
    }

    private void showOverflowMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
        popupMenu.inflate(R.menu.overflow_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.sauvegarde:

                        return true;
                    case R.id.traduire:

                        return true;
                    case R.id.partager:

                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }


}