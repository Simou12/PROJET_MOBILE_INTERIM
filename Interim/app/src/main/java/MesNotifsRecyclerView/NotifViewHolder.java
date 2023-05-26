package MesNotifsRecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.R;

public class NotifViewHolder extends RecyclerView.ViewHolder{

    TextView employeur, metier, ref;
    ImageView rejete,accepte;

    public NotifViewHolder(@NonNull View itemView) {
        super(itemView);
        employeur = itemView.findViewById(R.id.nomEntreprise);
        metier = itemView.findViewById(R.id.nomEmploi);
        ref = itemView.findViewById(R.id.ref);
        /*rejete = itemView.findViewById(R.id.refus);
        accepte = itemView.findViewById(R.id.refus);*/
    }
}
