package MesNotifsRecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.AnnonceEmployeur;
import com.example.interim.CurrentUserManager;
import com.example.interim.EmployeurProfil;
import com.example.interim.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;
import java.util.List;

import models.Emploi;


public class NotifAdapter extends RecyclerView.Adapter<NotifViewHolder>{

    Context context;
    List<ItemNotif> listNotifs;
    AlertDialog.Builder builder;
    private DatabaseReference emploiRef;
    private String nomEmploi,entreprise,date,ref;
    FirebaseUser currentUser = CurrentUserManager.getInstance().getCurrentUser();
    String userEmail = currentUser.getEmail();

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
        holder.ref.setText(listNotifs.get(position).getRef());

        nomEmploi = listNotifs.get(position).getMetier();
        entreprise = listNotifs.get(position).getEmployeur();
        ref = listNotifs.get(position).getRef();

        /*if(listNotifs.get(position).getStatus().equals("acceptee")){
            holder.accepte.setVisibility(View.VISIBLE);
            holder.accepte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showMenu(view);
                }
            });
        }
        if(listNotifs.get(position).getStatus().equals("refusee")){
            holder.rejete.setVisibility(View.VISIBLE);
        }*/
    }

    @Override
    public int getItemCount() {
        return listNotifs.size();
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
        popupMenu.inflate(R.menu.menu_notifs);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.acceptee:
                        builder = new AlertDialog.Builder(context);
                        builder.setTitle("Confirmation")
                                .setMessage("Etes vous sûr de vouloir valider cette action?")
                                .setCancelable(true)
                                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(context, "Confirmation avec succès!", Toast.LENGTH_SHORT).show();
                                    }

                                })
                                .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                })
                                .show();

                        //recuperer la date actuelle
                        LocalDate currentDate = null;
                        int day=0,month=0,year=0;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            currentDate = LocalDate.now();
                            day = currentDate.getDayOfMonth();
                            month = currentDate.getMonthValue();
                            year = currentDate.getYear();
                        }
                        String acceptationDate = ""+day+"-"+month+"-"+year;

                        //ajouter l'emploi a la bd
                        /*emploiRef = FirebaseDatabase.getInstance().getReference().child("candidatures");
                        String emploiKey = emploiRef.push().getKey();
                        Emploi emploi = new Emploi(nomEmploi,entreprise,adress,acceptationDate,userEmail);
                        emploiRef.child(emploiKey).setValue(emploi);*/

                    case R.id.refusee:
                        builder = new AlertDialog.Builder(context);
                        builder.setTitle("Confirmation")
                                .setMessage("Etes vous sûr de vouloir valider cette action?")
                                .setCancelable(true)
                                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(context, "Confirmation avec succès!", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                })
                                .show();
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }
}
