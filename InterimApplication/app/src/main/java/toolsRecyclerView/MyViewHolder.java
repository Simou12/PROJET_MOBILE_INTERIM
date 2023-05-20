package toolsRecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.interimapplication.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nomEmploiView,employeurView, refOffreView, contratOffreView,remunerationHeureView,
            remunerationMoisView,dateDebView,dateFinView,descriptionView,datePublicationView;
    ImageView imageAdd;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nomEmploiView=itemView.findViewById(R.id.nomPostePub);
        employeurView=itemView.findViewById(R.id.employeurPub);
        refOffreView=itemView.findViewById(R.id.referencePub);
        contratOffreView=itemView.findViewById(R.id.ContratPub);
        remunerationHeureView=itemView.findViewById(R.id.remHeurePub);
        remunerationMoisView=itemView.findViewById(R.id.remMoisPub);
        dateDebView=itemView.findViewById(R.id.dateDebPub);
        dateFinView=itemView.findViewById(R.id.dateFinPub);
        descriptionView=itemView.findViewById(R.id.description);
        datePublicationView=itemView.findViewById(R.id.datePublication);
        imageAdd=itemView.findViewById(R.id.addPubImage);
    }
}
