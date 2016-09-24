package com.kostya.letscook.controller;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kostya.letscook.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder {

    public TextView countryName;
    public ImageView countryPhoto;
    public FragmentTransaction tr;
    public RecyclerViewHolders(View itemView) {
        super(itemView);


        countryName = (TextView)itemView.findViewById(R.id.country_name);
        countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);

    }


}
