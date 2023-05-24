package MesNotifsRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.R;

import java.util.List;


public class NotifAdapter extends RecyclerView.Adapter<NotifViewHolder>{

    Context context;
    List<ItemNotif> listNotifs;

    public NotifAdapter(){}

    public NotifAdapter(Context context, List<ItemNotif> listNotifs) {
        this.context = context;
        this.listNotifs = listNotifs;
    }

    @NonNull
    @Override
    public NotifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotifViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notif_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotifViewHolder holder, int position) {
        holder.metier.setText(listNotifs.get(position).getMetier());
        holder.employeur.setText(listNotifs.get(position).getEmployeur());
        holder.adresse.setText(listNotifs.get(position).getAdress());
    }

    @Override
    public int getItemCount() {
        return listNotifs.size();
    }
}
