package MesNotifsRecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.R;

public class NotifViewHolder extends RecyclerView.ViewHolder{

    TextView employeur, metier, ref,decision;
    ImageView rejete,accepte;

    public NotifViewHolder(@NonNull View itemView) {
        super(itemView);
        employeur = itemView.findViewById(R.id.nomEmployeur);
        metier = itemView.findViewById(R.id.nomEmploi);
        ref = itemView.findViewById(R.id.ref);
        rejete = itemView.findViewById(R.id.refuserOffre);
        accepte = itemView.findViewById(R.id.accepterOffre);
        decision = itemView.findViewById(R.id.decision);
    }
}
