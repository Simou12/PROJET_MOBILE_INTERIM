package candidatureEnCoursEmplRecyclerView;

import static android.content.Context.DOWNLOAD_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.Call;
import com.example.interim.OnItemClickListener;
import com.example.interim.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class CandidatEmplAdapter extends RecyclerView.Adapter<CandidatEmplAdapter.CandidatureHolderView> {

    Context context;
    List<ItemCandidatureEmpl> listCandidatures;
    private final OnItemClickListener listener;
    private DownloadManager downloadManager;
    private static final String TAG = "DownloadService";
    private long downloadId;

    public CandidatEmplAdapter(Context context, List<ItemCandidatureEmpl> listCandidatures, OnItemClickListener listener) {
        this.context = context;
        this.listCandidatures = listCandidatures;
        this.listener = listener;
    }


    @NonNull
    @Override
    public CandidatEmplAdapter.CandidatureHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CandidatureHolderView(LayoutInflater.from(context).inflate(R.layout.item_candidature_en_cours,parent,false),listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidatEmplAdapter.CandidatureHolderView holder, @SuppressLint("RecyclerView") int position) {
        holder.nom.setText(listCandidatures.get(position).getNomCandidat()+" "+listCandidatures.get(position).getPrenomCandidat());
        holder.email.setText(listCandidatures.get(position).getEmailCandidat());
        holder.dateCandidature.setText("Date de candidature : "+listCandidatures.get(position).getDateCandidature());
        holder.nationnalité.setText(listCandidatures.get(position).getNationalite());
        holder.adress.setText(listCandidatures.get(position).getAdress());
        holder.dateNaissance.setText("Date de naissance : "+listCandidatures.get(position).getDateNaissance());
        holder.telephone.setText("0612345678");
        holder.lettre.setText(listCandidatures.get(position).getLettre());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadFile("https://pedagogie.ac-strasbourg.fr/fileadmin/pedagogie/isn/ISN/Conferences/cours_isn_Coloration_graphe.pdf");
                Toast.makeText(context, "Téléchargement du fichier Mon_CV2.pdf avec succès!", Toast.LENGTH_SHORT).show();
            }
        });


        //card click
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of layoutCache
                int visibility = (holder.layoutCache.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(holder.layoutHeader, new AutoTransition());
                holder.layoutCache.setVisibility(visibility);
            }
        });

        //appler
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Call.class);
                intent.putExtra("num","0612345678");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });




        //accepter une candidature
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mettre a jour le status de la candidature

                DatabaseReference candRef = FirebaseDatabase.getInstance().getReference().child("candidatures");

                Query query = candRef.orderByChild("email").equalTo(listCandidatures.get(position).getEmailCandidat());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            // Check if the reference field matches
                            String reference = dataSnapshot.child("refAnnonce").getValue(String.class);
                            if (reference != null && reference.equals(listCandidatures.get(position).getRef())) {
                                // Get the specific child key for updating the status field
                                String childKey = dataSnapshot.getKey();

                                // Get a reference to the specific child using the child key
                                DatabaseReference childRef = candRef.child(childKey);

                                // Update the status field
                                childRef.child("status").setValue("acceptee")
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(context, "Demande validée!", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                // An error occurred while updating the field
                                            }
                                        });
                                holder.accept.setVisibility(View.GONE);
                                holder.refus.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle any errors
                    }
                });
            }
        });



        //refuser la candidature
        holder.refus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mettre a jour le status de la candidature

                DatabaseReference candRef = FirebaseDatabase.getInstance().getReference().child("candidatures");

                Query query = candRef.orderByChild("email").equalTo(listCandidatures.get(position).getEmailCandidat());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            // Check if the reference field matches
                            String reference = dataSnapshot.child("refAnnonce").getValue(String.class);
                            if (reference != null && reference.equals(listCandidatures.get(position).getRef())) {
                                // Get the specific child key for updating the status field
                                String childKey = dataSnapshot.getKey();

                                // Get a reference to the specific child using the child key
                                DatabaseReference childRef = candRef.child(childKey);

                                // Update the status field
                                childRef.child("status").setValue("refusee")
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(context, "Demande validée!", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                // An error occurred while updating the field
                                            }
                                        });
                                holder.accept.setVisibility(View.GONE);
                                holder.refus.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle any errors
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return listCandidatures.size();
    }

    public static class CandidatureHolderView extends RecyclerView.ViewHolder{

        TextView nom, adress, dateCandidature, email,dateNaissance, telephone, nationnalité,lettre,cv;
        Button accept, refus;
        ConstraintLayout layoutCache;
        ConstraintLayout layoutHeader;
        CardView cardView;
        ImageView call;

        public CandidatureHolderView(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nom = itemView.findViewById(R.id.nomCandidat);
            email = itemView.findViewById(R.id.email);
            dateCandidature = itemView.findViewById(R.id.dateCandidature);
            adress = itemView.findViewById(R.id.adre);
            dateNaissance = itemView.findViewById(R.id.dateNaissance);
            telephone = itemView.findViewById(R.id.tel);
            nationnalité = itemView.findViewById(R.id.nationnalite);
            lettre = itemView.findViewById(R.id.motivation);
            layoutCache=itemView.findViewById(R.id.layoutCache);
            layoutHeader=itemView.findViewById(R.id.layout1);
            cardView = itemView.findViewById(R.id.card);
            accept = itemView.findViewById(R.id.accepter);
            refus = itemView.findViewById(R.id.refuser);
            cv = itemView.findViewById(R.id.monCv);
            call = itemView.findViewById(R.id.call);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            listener.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }

    private void downloadFile(String url) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle("File download");
        request.setDescription("Downloading file ");

        // Save the file in the Downloads directory
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Mon_CV.pdf");

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);
    }



}
