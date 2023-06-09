// Generated by view binder compiler. Do not edit!
package com.example.interim.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivityInscription2InterimaireBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText email;

  @NonNull
  public final EditText mdp;

  @NonNull
  public final EditText mdpConfirm;

  @NonNull
  public final EditText tel;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView titre;

  @NonNull
  public final Button valider;

  private ActivityInscription2InterimaireBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText email, @NonNull EditText mdp, @NonNull EditText mdpConfirm,
      @NonNull EditText tel, @NonNull TextView textView2, @NonNull TextView titre,
      @NonNull Button valider) {
    this.rootView = rootView;
    this.email = email;
    this.mdp = mdp;
    this.mdpConfirm = mdpConfirm;
    this.tel = tel;
    this.textView2 = textView2;
    this.titre = titre;
    this.valider = valider;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityInscription2InterimaireBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityInscription2InterimaireBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_inscription2_interimaire, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityInscription2InterimaireBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.email;
      EditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
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

      id = R.id.valider;
      Button valider = ViewBindings.findChildViewById(rootView, id);
      if (valider == null) {
        break missingId;
      }

      return new ActivityInscription2InterimaireBinding((ConstraintLayout) rootView, email, mdp,
          mdpConfirm, tel, textView2, titre, valider);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
