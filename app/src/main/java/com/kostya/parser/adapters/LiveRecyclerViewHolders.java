package com.kostya.parser.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kostya.parser.R;
import com.kostya.parser.fragments.Fragment0;

public class LiveRecyclerViewHolders extends RecyclerView.ViewHolder {

    public TextView foodName;
    public ImageView foodPhoto;
    public LiveRecyclerViewHolders(View itemView) {
        super(itemView);


        foodName = (TextView)itemView.findViewById(R.id.live_food_name);
        foodPhoto = (ImageView)itemView.findViewById(R.id.live_food_img);

    }


}