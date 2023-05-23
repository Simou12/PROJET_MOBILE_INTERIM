// Generated by view binder compiler. Do not edit!
package com.example.interim.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public final class ProcederPayementBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RelativeLayout contaner;

  @NonNull
  public final EditText cvcCarte;

  @NonNull
  public final ImageView likeImage;

  @NonNull
  public final EditText numCarte;

  @NonNull
  public final ImageView shareImage;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView titre;

  @NonNull
  public final EditText titulaireCarte;

  @NonNull
  public final ImageView translateImage;

  @NonNull
  public final Button valider;

  private ProcederPayementBinding(@NonNull LinearLayout rootView, @NonNull RelativeLayout contaner,
      @NonNull EditText cvcCarte, @NonNull ImageView likeImage, @NonNull EditText numCarte,
      @NonNull ImageView shareImage, @NonNull TextView title, @NonNull TextView titre,
      @NonNull EditText titulaireCarte, @NonNull ImageView translateImage,
      @NonNull Button valider) {
    this.rootView = rootView;
    this.contaner = contaner;
    this.cvcCarte = cvcCarte;
    this.likeImage = likeImage;
    this.numCarte = numCarte;
    this.shareImage = shareImage;
    this.title = title;
    this.titre = titre;
    this.titulaireCarte = titulaireCarte;
    this.translateImage = translateImage;
    this.valider = valider;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProcederPayementBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProcederPayementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.proceder_payement, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProcederPayementBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.contaner;
      RelativeLayout contaner = ViewBindings.findChildViewById(rootView, id);
      if (contaner == null) {
        break missingId;
      }

      id = R.id.cvcCarte;
      EditText cvcCarte = ViewBindings.findChildViewById(rootView, id);
      if (cvcCarte == null) {
        break missingId;
      }

      id = R.id.likeImage;
      ImageView likeImage = ViewBindings.findChildViewById(rootView, id);
      if (likeImage == null) {
        break missingId;
      }

      id = R.id.numCarte;
      EditText numCarte = ViewBindings.findChildViewById(rootView, id);
      if (numCarte == null) {
        break missingId;
      }

      id = R.id.shareImage;
      ImageView shareImage = ViewBindings.findChildViewById(rootView, id);
      if (shareImage == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.titre;
      TextView titre = ViewBindings.findChildViewById(rootView, id);
      if (titre == null) {
        break missingId;
      }

      id = R.id.titulaireCarte;
      EditText titulaireCarte = ViewBindings.findChildViewById(rootView, id);
      if (titulaireCarte == null) {
        break missingId;
      }

      id = R.id.translateImage;
      ImageView translateImage = ViewBindings.findChildViewById(rootView, id);
      if (translateImage == null) {
        break missingId;
      }

      id = R.id.valider;
      Button valider = ViewBindings.findChildViewById(rootView, id);
      if (valider == null) {
        break missingId;
      }

      return new ProcederPayementBinding((LinearLayout) rootView, contaner, cvcCarte, likeImage,
          numCarte, shareImage, title, titre, titulaireCarte, translateImage, valider);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
