package com.kostya.parser.fragments;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kostya.parser.ItemClickSupport;
import com.kostya.parser.ItemObject;
import com.kostya.parser.MainActivity;
import com.kostya.parser.R;
import com.kostya.parser.adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Степучева Наталья on 25.09.2016.
 */

public class FragmentMain extends Fragment{
    private GridLayoutManager lLayout;
    public String URL;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_main,container,false) ;

        List<ItemObject> rowListItem = getAllItemList();

        lLayout = new GridLayoutManager(getContext(), 3);

        RecyclerView rView = (RecyclerView)v.findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(getContext(), rowListItem);
        rView.setAdapter(rcAdapter);

        ItemClickSupport.addTo(rView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                switch (position){
                    case 0:
                    {
                        URL = "http://eda.ru/recepty/vypechka-deserty";
                    }
                    break;
                    case 1:
                    {
                        URL = "http://eda.ru/recepty/osnovnye-blyuda";
                    }
                    break;
                    case 2:
                    {
                        URL = "http://eda.ru/recepty/zavtraki";
                    }
                    break;
                    case 3:
                    {
                        URL = "http://eda.ru/recepty/salaty";
                    }
                    break;
                    case 4:
                    {
                        URL = "http://eda.ru/recepty/supy";
                    }
                    break;
                    case 5:
                    {
                        URL = "http://eda.ru/recepty/pasta-picca";
                    }
                    break;
                    case 6:
                    {
                        URL = "http://eda.ru/recepty/zakuski";
                    }
                    break;
                    case 7:
                    {
                        URL = "http://eda.ru/recepty/sendvichi";
                    }
                    break;
                    case 8:
                    {
                        URL = "http://eda.ru/recepty/rizotto";
                    }
                    break;
                    case 9:
                    {
                        URL = "http://eda.ru/recepty/napitki";
                    }
                    break;
                    case 10:
                    {
                        URL = "http://eda.ru/recepty/sousy-marinady";
                    }
                    break;
                    case 11:
                    {
                        URL = "http://eda.ru/recepty/bulony";
                    }
                    break;
                }
                Fragment0 fragment = Fragment0.newInstance(URL);
                Fragment fragment0 = new Fragment0();
                FragmentTransaction tr=getActivity().getSupportFragmentManager().beginTransaction();

                tr.add(R.id.fragment,fragment0)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();


                Log.i("AWA","position "+position);
            }
        });

      return v;
    }
    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Выпечка и десерты",R.drawable.vypechka_deserty));
        allItems.add(new ItemObject("Основные блюда",R.drawable.osnovnye_blyuda));
        allItems.add(new ItemObject("Завтраки",R.drawable.zavtraki));
        allItems.add(new ItemObject("Салаты",R.drawable.salaty));
        allItems.add(new ItemObject("Супы",R.drawable.supy));
        allItems.add(new ItemObject("Паста и пицца",R.drawable.pasta_picca));
        allItems.add(new ItemObject("Закуски",R.drawable.zakuski));
        allItems.add(new ItemObject("Сэндвичи",R.drawable.sendvichi));
        allItems.add(new ItemObject("Ризотто",R.drawable.rizotto));
        allItems.add(new ItemObject("Напитки",R.drawable.napitki));
        allItems.add(new ItemObject("Соусы и маринады",R.drawable.sousy_marinady));
        allItems.add(new ItemObject("Бульоны",R.drawable.bulony));
        return allItems;
    }
}
