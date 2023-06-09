// Generated by view binder compiler. Do not edit!
package com.example.interim.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.interim.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemGestionnaireDemandeInscriptionBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button accepter;

  @NonNull
  public final TextView adresse;

  @NonNull
  public final TextView aucune;

  @NonNull
  public final CardView card;

  @NonNull
  public final TextView dateInscription;

  @NonNull
  public final TextView departement;

  @NonNull
  public final TextView email;

  @NonNull
  public final ImageView gmail;

  @NonNull
  public final ConstraintLayout layout1;

  @NonNull
  public final ConstraintLayout layoutCache;

  @NonNull
  public final LinearLayout layoutContraty;

  @NonNull
  public final LinearLayout layoutLocal;

  @NonNull
  public final LinearLayout layoutRemun;

  @NonNull
  public final ImageView local;

  @NonNull
  public final TextView nom;

  @NonNull
  public final TextView numNational;

  @NonNull
  public final ImageView phone;

  @NonNull
  public final ImageView photoProfil;

  @NonNull
  public final Button refuser;

  @NonNull
  public final TextView role;

  @NonNull
  public final TextView sDepartement;

  @NonNull
  public final TextView tel;

  private ItemGestionnaireDemandeInscriptionBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button accepter, @NonNull TextView adresse, @NonNull TextView aucune,
      @NonNull CardView card, @NonNull TextView dateInscription, @NonNull TextView departement,
      @NonNull TextView email, @NonNull ImageView gmail, @NonNull ConstraintLayout layout1,
      @NonNull ConstraintLayout layoutCache, @NonNull LinearLayout layoutContraty,
      @NonNull LinearLayout layoutLocal, @NonNull LinearLayout layoutRemun,
      @NonNull ImageView local, @NonNull TextView nom, @NonNull TextView numNational,
      @NonNull ImageView phone, @NonNull ImageView photoProfil, @NonNull Button refuser,
      @NonNull TextView role, @NonNull TextView sDepartement, @NonNull TextView tel) {
    this.rootView = rootView;
    this.accepter = accepter;
    this.adresse = adresse;
    this.aucune = aucune;
    this.card = card;
    this.dateInscription = dateInscription;
    this.departement = departement;
    this.email = email;
    this.gmail = gmail;
    this.layout1 = layout1;
    this.layoutCache = layoutCache;
    this.layoutContraty = layoutContraty;
    this.layoutLocal = layoutLocal;
    this.layoutRemun = layoutRemun;
    this.local = local;
    this.nom = nom;
    this.numNational = numNational;
    this.phone = phone;
    this.photoProfil = photoProfil;
    this.refuser = refuser;
    this.role = role;
    this.sDepartement = sDepartement;
    this.tel = tel;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemGestionnaireDemandeInscriptionBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemGestionnaireDemandeInscriptionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_gestionnaire_demande_inscription, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemGestionnaireDemandeInscriptionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.accepter;
      Button accepter = ViewBindings.findChildViewById(rootView, id);
      if (accepter == null) {
        break missingId;
      }

      id = R.id.adresse;
      TextView adresse = ViewBindings.findChildViewById(rootView, id);
      if (adresse == null) {
        break missingId;
      }

      id = R.id.aucune;
      TextView aucune = ViewBindings.findChildViewById(rootView, id);
      if (aucune == null) {
        break missingId;
      }

      id = R.id.card;
      CardView card = ViewBindings.findChildViewById(rootView, id);
      if (card == null) {
        break missingId;
      }

      id = R.id.dateInscription;
      TextView dateInscription = ViewBindings.findChildViewById(rootView, id);
      if (dateInscription == null) {
        break missingId;
      }

      id = R.id.departement;
      TextView departement = ViewBindings.findChildViewById(rootView, id);
      if (departement == null) {
        break missingId;
      }

      id = R.id.email;
      TextView email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.gmail;
      ImageView gmail = ViewBindings.findChildViewById(rootView, id);
      if (gmail == null) {
        break missingId;
      }

      id = R.id.layout1;
      ConstraintLayout layout1 = ViewBindings.findChildViewById(rootView, id);
      if (layout1 == null) {
        break missingId;
      }

      id = R.id.layoutCache;
      ConstraintLayout layoutCache = ViewBindings.findChildViewById(rootView, id);
      if (layoutCache == null) {
        break missingId;
      }

      id = R.id.layoutContraty;
      LinearLayout layoutContraty = ViewBindings.findChildViewById(rootView, id);
      if (layoutContraty == null) {
        break missingId;
      }

      id = R.id.layoutLocal;
      LinearLayout layoutLocal = ViewBindings.findChildViewById(rootView, id);
      if (layoutLocal == null) {
        break missingId;
      }

      id = R.id.layoutRemun;
      LinearLayout layoutRemun = ViewBindings.findChildViewById(rootView, id);
      if (layoutRemun == null) {
        break missingId;
      }

      id = R.id.local;
      ImageView local = ViewBindings.findChildViewById(rootView, id);
      if (local == null) {
        break missingId;
      }

      id = R.id.nom;
      TextView nom = ViewBindings.findChildViewById(rootView, id);
      if (nom == null) {
        break missingId;
      }

      id = R.id.numNational;
      TextView numNational = ViewBindings.findChildViewById(rootView, id);
      if (numNational == null) {
        break missingId;
      }

      id = R.id.phone;
      ImageView phone = ViewBindings.findChildViewById(rootView, id);
      if (phone == null) {
        break missingId;
      }

      id = R.id.photoProfil;
      ImageView photoProfil = ViewBindings.findChildViewById(rootView, id);
      if (photoProfil == null) {
        break missingId;
      }

      id = R.id.refuser;
      Button refuser = ViewBindings.findChildViewById(rootView, id);
      if (refuser == null) {
        break missingId;
      }

      id = R.id.role;
      TextView role = ViewBindings.findChildViewById(rootView, id);
      if (role == null) {
        break missingId;
      }

      id = R.id.sDepartement;
      TextView sDepartement = ViewBindings.findChildViewById(rootView, id);
      if (sDepartement == null) {
        break missingId;
      }

      id = R.id.tel;
      TextView tel = ViewBindings.findChildViewById(rootView, id);
      if (tel == null) {
        break missingId;
      }

      return new ItemGestionnaireDemandeInscriptionBinding((ConstraintLayout) rootView, accepter,
          adresse, aucune, card, dateInscription, departement, email, gmail, layout1, layoutCache,
          layoutContraty, layoutLocal, layoutRemun, local, nom, numNational, phone, photoProfil,
          refuser, role, sDepartement, tel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
