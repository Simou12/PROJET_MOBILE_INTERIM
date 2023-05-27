// Generated by view binder compiler. Do not edit!
package com.example.interim.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
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

public final class ActivityInscription1PublisherBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final EditText mail1;

  @NonNull
  public final EditText mdp;

  @NonNull
  public final EditText mdpConfirm;

  @NonNull
  public final ImageView next;

  @NonNull
  public final EditText nom;

  @NonNull
  public final EditText prenom;

  @NonNull
  public final EditText tel;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView titre;

  private ActivityInscription1PublisherBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout constraintLayout, @NonNull EditText mail1, @NonNull EditText mdp,
      @NonNull EditText mdpConfirm, @NonNull ImageView next, @NonNull EditText nom,
      @NonNull EditText prenom, @NonNull EditText tel, @NonNull TextView textView2,
      @NonNull TextView titre) {
    this.rootView = rootView;
    this.constraintLayout = constraintLayout;
    this.mail1 = mail1;
    this.mdp = mdp;
    this.mdpConfirm = mdpConfirm;
    this.next = next;
    this.nom = nom;
    this.prenom = prenom;
    this.tel = tel;
    this.textView2 = textView2;
    this.titre = titre;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityInscription1PublisherBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityInscription1PublisherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_inscription1_publisher, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityInscription1PublisherBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.mail1;
      EditText mail1 = ViewBindings.findChildViewById(rootView, id);
      if (mail1 == null) {
        break missingId;
      }

      id = R.id.mdp;
      EditText mdp = ViewBindings.findChildViewById(rootView, id);
      if (mdp == null) {
        break missingId;
      }

      id = R.id.mdpConfirm;
      EditText mdpConfirm = ViewBindings.findChildViewById(rootView, id);
      if (mdpConfirm == null) {
        break missingId;
      }

      id = R.id.next;
      ImageView next = ViewBindings.findChildViewById(rootView, id);
      if (next == null) {
        break missingId;
      }

      id = R.id.nom;
      EditText nom = ViewBindings.findChildViewById(rootView, id);
      if (nom == null) {
        break missingId;
      }

      id = R.id.prenom;
      EditText prenom = ViewBindings.findChildViewById(rootView, id);
      if (prenom == null) {
        break missingId;
      }

      id = R.id.tel;
      EditText tel = ViewBindings.findChildViewById(rootView, id);
      if (tel == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.titre;
      TextView titre = ViewBindings.findChildViewById(rootView, id);
      if (titre == null) {
        break missingId;
      }

      return new ActivityInscription1PublisherBinding((ConstraintLayout) rootView, constraintLayout,
          mail1, mdp, mdpConfirm, next, nom, prenom, tel, textView2, titre);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
