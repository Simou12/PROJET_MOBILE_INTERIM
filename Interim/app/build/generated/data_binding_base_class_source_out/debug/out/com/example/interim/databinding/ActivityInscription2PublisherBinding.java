// Generated by view binder compiler. Do not edit!
package com.example.interim.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivityInscription2PublisherBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText adress;

  @NonNull
  public final EditText email1;

  @NonNull
  public final EditText email2;

  @NonNull
  public final EditText lien;

  @NonNull
  public final EditText mdp;

  @NonNull
  public final EditText tel1;

  @NonNull
  public final EditText tel2;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView titre;

  @NonNull
  public final Button valider;

  private ActivityInscription2PublisherBinding(@NonNull RelativeLayout rootView,
      @NonNull EditText adress, @NonNull EditText email1, @NonNull EditText email2,
      @NonNull EditText lien, @NonNull EditText mdp, @NonNull EditText tel1, @NonNull EditText tel2,
      @NonNull TextView title, @NonNull TextView titre, @NonNull Button valider) {
    this.rootView = rootView;
    this.adress = adress;
    this.email1 = email1;
    this.email2 = email2;
    this.lien = lien;
    this.mdp = mdp;
    this.tel1 = tel1;
    this.tel2 = tel2;
    this.title = title;
    this.titre = titre;
    this.valider = valider;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityInscription2PublisherBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityInscription2PublisherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_inscription2_publisher, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityInscription2PublisherBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.adress;
      EditText adress = ViewBindings.findChildViewById(rootView, id);
      if (adress == null) {
        break missingId;
      }

      id = R.id.email1;
      EditText email1 = ViewBindings.findChildViewById(rootView, id);
      if (email1 == null) {
        break missingId;
      }

      id = R.id.email2;
      EditText email2 = ViewBindings.findChildViewById(rootView, id);
      if (email2 == null) {
        break missingId;
      }

      id = R.id.lien;
      EditText lien = ViewBindings.findChildViewById(rootView, id);
      if (lien == null) {
        break missingId;
      }

      id = R.id.mdp;
      EditText mdp = ViewBindings.findChildViewById(rootView, id);
      if (mdp == null) {
        break missingId;
      }

      id = R.id.tel1;
      EditText tel1 = ViewBindings.findChildViewById(rootView, id);
      if (tel1 == null) {
        break missingId;
      }

      id = R.id.tel2;
      EditText tel2 = ViewBindings.findChildViewById(rootView, id);
      if (tel2 == null) {
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

      id = R.id.valider;
      Button valider = ViewBindings.findChildViewById(rootView, id);
      if (valider == null) {
        break missingId;
      }

      return new ActivityInscription2PublisherBinding((RelativeLayout) rootView, adress, email1,
          email2, lien, mdp, tel1, tel2, title, titre, valider);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
