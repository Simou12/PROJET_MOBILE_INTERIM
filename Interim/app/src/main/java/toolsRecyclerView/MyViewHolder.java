package toolsRecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.interim.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nomEmploiView,employeurView, refOffreView, contratOffreView,remunerationHeureView,
            remunerationMoisView,dateDebView,dateFinView,descriptionView,datePublicationView,adress;
    ImageView traduction,partager,liker;
    Button postuler;
    ConstraintLayout layoutCache;
    ConstraintLayout layoutHeader;
    CardView cardView;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nomEmploiView=itemView.findViewById(R.id.nomPostePub);
        employeurView=itemView.findViewById(R.id.nomEmployeurPub);
        refOffreView=itemView.findViewById(R.id.ref);
        contratOffreView=itemView.findViewById(R.id.ContratPub);
        //remunerationHeureView=itemView.findViewById(R.id.remTitle);
        remunerationMoisView=itemView.findViewById(R.id.remTitle);
        dateDebView=itemView.findViewById(R.id.dateDebPub);
        dateFinView=itemView.findViewById(R.id.dateFinPub);
        descriptionView=itemView.findViewById(R.id.description);
        datePublicationView=itemView.findViewById(R.id.datePublication);
        adress = itemView.findViewById(R.id.adre);

        postuler = itemView.findViewById(R.id.postuler);
        traduction = itemView.findViewById(R.id.traduction);
        partager = itemView.findViewById(R.id.share);
        liker = itemView.findViewById(R.id.liker);

        layoutCache=itemView.findViewById(R.id.layoutCache);
        layoutHeader=itemView.findViewById(R.id.layout1);
        cardView = itemView.findViewById(R.id.card);
    }
}