package MesNotifsRecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.R;

public class NotifViewHolder extends RecyclerView.ViewHolder{

    TextView employeur, metier, adresse;
    ImageView enCours,rejete,accepte;

    public NotifViewHolder(@NonNull View itemView) {
        super(itemView);
        employeur = itemView.findViewById(R.id.employeurPub);
        metier = itemView.findViewById(R.id.nomPostePub);
        adresse = itemView.findViewById(R.id.adressPub);
    }
}
