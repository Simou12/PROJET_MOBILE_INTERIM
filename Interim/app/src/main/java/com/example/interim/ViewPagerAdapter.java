package com.example.interim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    int images[]={
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
    };

    int headling[]={
            R.string.headling1,
            R.string.headling2,
            R.string.headling3,
            R.string.headling4,
            R.string.headling5
    };
    int descriptions[]={
            R.string.description1,
            R.string.description2,
            R.string.description3,
            R.string.description4,
            R.string.description5
    };
    public ViewPagerAdapter(Context context){
        this.context=context;
    }


    @Override
    public int getCount() {
        return headling.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout) object;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide,container,false);

        ImageView slidetitleImage= (ImageView) view.findViewById(R.id.titleImage);
        TextView slideHeadling=(TextView)  view.findViewById(R.id.texttitle);
        TextView slideDescription=(TextView)  view.findViewById(R.id.texttitle);

        slidetitleImage.setImageResource(images[position]);
        slideHeadling.setText(headling[position]);
        slideDescription.setText(descriptions[position]);
        container.addView(view);
        return view;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }
}
