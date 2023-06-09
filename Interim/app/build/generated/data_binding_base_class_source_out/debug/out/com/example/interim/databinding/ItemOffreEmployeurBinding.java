// Generated by view binder compiler. Do not edit!
package com.example.interim.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.interim.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemOffreEmployeurBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView calendrier;

  @NonNull
  public final TextView datePublication;

  @NonNull
  public final RelativeLayout header;

  @NonNull
  public final TextView nomEmploi;

  @NonNull
  public final TextView ref;

  @NonNull
  public final Button supprimer;

  private ItemOffreEmployeurBinding(@NonNull RelativeLayout rootView, @NonNull ImageView calendrier,
      @NonNull TextView datePublication, @NonNull RelativeLayout header,
      @NonNull TextView nomEmploi, @NonNull TextView ref, @NonNull Button supprimer) {
    this.rootView = rootView;
    this.calendrier = calendrier;
    this.datePublication = datePublication;
    this.header = header;
    this.nomEmploi = nomEmploi;
    this.ref = ref;
    this.supprimer = supprimer;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemOffreEmployeurBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemOffreEmployeurBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_offre_employeur, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemOffreEmployeurBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.calendrier;
      ImageView calendrier = ViewBindings.findChildViewById(rootView, id);
      if (calendrier == null) {
        break missingId;
      }

      id = R.id.datePublication;
      TextView datePublication = ViewBindings.findChildViewById(rootView, id);
      if (datePublication == null) {
        break missingId;
      }

      id = R.id.header;
      RelativeLayout header = ViewBindings.findChildViewById(rootView, id);
      if (header == null) {
        break missingId;
      }

      id = R.id.nomEmploi;
      TextView nomEmploi = ViewBindings.findChildViewById(rootView, id);
      if (nomEmploi == null) {
        break missingId;
      }

      id = R.id.ref;
      TextView ref = ViewBindings.findChildViewById(rootView, id);
      if (ref == null) {
        break missingId;
      }

      id = R.id.supprimer;
      Button supprimer = ViewBindings.findChildViewById(rootView, id);
      if (supprimer == null) {
        break missingId;
      }

      return new ItemOffreEmployeurBinding((RelativeLayout) rootView, calendrier, datePublication,
          header, nomEmploi, ref, supprimer);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
