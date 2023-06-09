// Generated by view binder compiler. Do not edit!
package com.example.interim.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.interim.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutDialogBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Spinner contratType;

  @NonNull
  public final TextView date;

  @NonNull
  public final EditText dateDeb;

  @NonNull
  public final EditText dateFin;

  @NonNull
  public final EditText description;

  @NonNull
  public final EditText nomEntreprise;

  @NonNull
  public final EditText nomOffre;

  @NonNull
  public final EditText pays;

  @NonNull
  public final EditText reference;

  @NonNull
  public final EditText salaireHoraire;

  @NonNull
  public final EditText salaireMensuelle;

  @NonNull
  public final TextView textDescr;

  @NonNull
  public final TextView textRemuneration;

  @NonNull
  public final TextView title;

  @NonNull
  public final EditText ville;

  private LayoutDialogBinding(@NonNull ConstraintLayout rootView, @NonNull Spinner contratType,
      @NonNull TextView date, @NonNull EditText dateDeb, @NonNull EditText dateFin,
      @NonNull EditText description, @NonNull EditText nomEntreprise, @NonNull EditText nomOffre,
      @NonNull EditText pays, @NonNull EditText reference, @NonNull EditText salaireHoraire,
      @NonNull EditText salaireMensuelle, @NonNull TextView textDescr,
      @NonNull TextView textRemuneration, @NonNull TextView title, @NonNull EditText ville) {
    this.rootView = rootView;
    this.contratType = contratType;
    this.date = date;
    this.dateDeb = dateDeb;
    this.dateFin = dateFin;
    this.description = description;
    this.nomEntreprise = nomEntreprise;
    this.nomOffre = nomOffre;
    this.pays = pays;
    this.reference = reference;
    this.salaireHoraire = salaireHoraire;
    this.salaireMensuelle = salaireMensuelle;
    this.textDescr = textDescr;
    this.textRemuneration = textRemuneration;
    this.title = title;
    this.ville = ville;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.contratType;
      Spinner contratType = ViewBindings.findChildViewById(rootView, id);
      if (contratType == null) {
        break missingId;
      }

      id = R.id.date;
      TextView date = ViewBindings.findChildViewById(rootView, id);
      if (date == null) {
        break missingId;
      }

      id = R.id.dateDeb;
      EditText dateDeb = ViewBindings.findChildViewById(rootView, id);
      if (dateDeb == null) {
        break missingId;
      }

      id = R.id.dateFin;
      EditText dateFin = ViewBindings.findChildViewById(rootView, id);
      if (dateFin == null) {
        break missingId;
      }

      id = R.id.description;
      EditText description = ViewBindings.findChildViewById(rootView, id);
      if (description == null) {
        break missingId;
      }

      id = R.id.nomEntreprise;
      EditText nomEntreprise = ViewBindings.findChildViewById(rootView, id);
      if (nomEntreprise == null) {
        break missingId;
      }

      id = R.id.nomOffre;
      EditText nomOffre = ViewBindings.findChildViewById(rootView, id);
      if (nomOffre == null) {
        break missingId;
      }

      id = R.id.pays;
      EditText pays = ViewBindings.findChildViewById(rootView, id);
      if (pays == null) {
        break missingId;
      }

      id = R.id.reference;
      EditText reference = ViewBindings.findChildViewById(rootView, id);
      if (reference == null) {
        break missingId;
      }

      id = R.id.salaireHoraire;
      EditText salaireHoraire = ViewBindings.findChildViewById(rootView, id);
      if (salaireHoraire == null) {
        break missingId;
      }

      id = R.id.salaireMensuelle;
      EditText salaireMensuelle = ViewBindings.findChildViewById(rootView, id);
      if (salaireMensuelle == null) {
        break missingId;
      }

      id = R.id.textDescr;
      TextView textDescr = ViewBindings.findChildViewById(rootView, id);
      if (textDescr == null) {
        break missingId;
      }

      id = R.id.textRemuneration;
      TextView textRemuneration = ViewBindings.findChildViewById(rootView, id);
      if (textRemuneration == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.ville;
      EditText ville = ViewBindings.findChildViewById(rootView, id);
      if (ville == null) {
        break missingId;
      }

      return new LayoutDialogBinding((ConstraintLayout) rootView, contratType, date, dateDeb,
          dateFin, description, nomEntreprise, nomOffre, pays, reference, salaireHoraire,
          salaireMensuelle, textDescr, textRemuneration, title, ville);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
