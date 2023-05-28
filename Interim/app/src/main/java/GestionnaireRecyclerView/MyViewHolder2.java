package GestionnaireRecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.R;

public class MyViewHolder2 extends RecyclerView.ViewHolder{
    ImageView imageView1,imageView2,imageView3,imageView4;
    TextView nameView,roleView,emailView,telView,numNationalView,departementView,sDepartementView,dateInscription;
    Button btnAccepter,btnRefuser;
    CardView cardView;
    ConstraintLayout layoutCache;
    ConstraintLayout layoutHeader;

    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.nom);
        roleView=itemView.findViewById(R.id.role);
        emailView = itemView.findViewById(R.id.email);
        telView = itemView.findViewById(R.id.tel);
        numNationalView = itemView.findViewById(R.id.numNational);
        departementView = itemView.findViewById(R.id.departement);
        sDepartementView=itemView.findViewById(R.id.sDepartement);
        dateInscription = itemView.findViewById(R.id.dateInscription);
        imageView1=itemView.findViewById(R.id.date);
        imageView2=itemView.findViewById(R.id.local);
        imageView3=itemView.findViewById(R.id.gmail);
        imageView4=itemView.findViewById(R.id.phone);
        btnAccepter=itemView.findViewById(R.id.accepter);
        btnRefuser=itemView.findViewById(R.id.refuser);
        cardView=itemView.findViewById(R.id.card);
        layoutCache=itemView.findViewById(R.id.layoutCache);
        layoutHeader=itemView.findViewById(R.id.layout1);
    }

    public ImageView getImageView1() {
        return imageView1;
    }

    public void setImageView1(ImageView imageView1) {
        this.imageView1 = imageView1;
    }

    public ImageView getImageView2() {
        return imageView2;
    }

    public void setImageView2(ImageView imageView2) {
        this.imageView2 = imageView2;
    }

    public ImageView getImageView3() {
        return imageView3;
    }

    public void setImageView3(ImageView imageView3) {
        this.imageView3 = imageView3;
    }

    public ImageView getImageView4() {
        return imageView4;
    }

    public void setImageView4(ImageView imageView4) {
        this.imageView4 = imageView4;
    }

    public TextView getNameView() {
        return nameView;
    }

    public void setNameView(TextView nameView) {
        this.nameView = nameView;
    }

    public TextView getRoleView() {
        return roleView;
    }

    public void setRoleView(TextView roleView) {
        this.roleView = roleView;
    }

    public TextView getEmailView() {
        return emailView;
    }

    public void setEmailView(TextView emailView) {
        this.emailView = emailView;
    }

    public TextView getTelView() {
        return telView;
    }

    public void setTelView(TextView telView) {
        this.telView = telView;
    }

    public TextView getNumNationalView() {
        return numNationalView;
    }

    public void setNumNationalView(TextView numNationalView) {
        this.numNationalView = numNationalView;
    }

    public TextView getDepartementView() {
        return departementView;
    }

    public void setDepartementView(TextView departementView) {
        this.departementView = departementView;
    }

    public TextView getsDepartementView() {
        return sDepartementView;
    }

    public void setsDepartementView(TextView sDepartementView) {
        this.sDepartementView = sDepartementView;
    }

    public TextView getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(TextView dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Button getBtnAccepter() {
        return btnAccepter;
    }

    public void setBtnAccepter(Button btnAccepter) {
        this.btnAccepter = btnAccepter;
    }

    public Button getBtnRefuser() {
        return btnRefuser;
    }

    public void setBtnRefuser(Button btnRefuser) {
        this.btnRefuser = btnRefuser;
    }
}
