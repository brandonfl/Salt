package com.example.utilisateur.projetl3.Aides;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.utilisateur.projetl3.R;

/**
 * Created by inesr on 20/04/2018.
 */

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resources;
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context ctx,int[] image_resources ){
        this.ctx=ctx;
        this.image_resources=image_resources;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    //permet d'instancier le swipe avec les différentes images a chacune des positions
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater= (LayoutInflater)ctx .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view =layoutInflater.inflate(R.layout.slide_lesson,container,false);
        ImageView imageview = (ImageView) item_view.findViewById(R.id.lecon);
        imageview.setImageResource(image_resources[position]);
        container.addView(item_view);

        return item_view;
    }





}