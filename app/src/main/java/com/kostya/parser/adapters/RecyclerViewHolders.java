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
