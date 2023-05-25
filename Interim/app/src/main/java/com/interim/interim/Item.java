package com.interim.interim;

import android.animation.LayoutTransition;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.interim.R;

public class Item extends AppCompatActivity {
    ConstraintLayout layoutCache;
    ConstraintLayout layoutHeader;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_offre_view);
        layoutCache=findViewById(R.id.layoutCache);
        layoutHeader=findViewById(R.id.layout1);
        layoutHeader.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

    }
@RequiresApi(api= Build.VERSION_CODES.KITKAT)
    public void expand(View view){
        int v= (layoutCache.getVisibility()== View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(layoutHeader,new AutoTransition());
        layoutCache.setVisibility(v);
    }


}
