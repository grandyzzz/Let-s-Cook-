package com.kostya.letscook.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.kostya.letscook.R;
import com.kostya.letscook.controller.RecyclerViewAdapter;
import com.kostya.letscook.controller.ItemClickSupport;
import com.kostya.letscook.controller.ItemObject;
import com.kostya.letscook.view.Fragment0;
import com.mikepenz.materialdrawer.Drawer;

import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;

import java.util.ArrayList;
import java.util.List;

import static com.kostya.letscook.R.id.toolbar;


public class MainActivity extends ActionBarActivity {

    private GridLayoutManager lLayout;
    public String URL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(null);

        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        topToolBar.setLogo(R.mipmap.ic_launcher);
        new Drawer()
                .withActivity(this)
                .withToolbar(topToolBar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withBadge("99").withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_free_play),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_custom).withBadge("6").withIdentifier(2),
                        new SectionDrawerItem().withName(R.string.drawer_item_settings),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_help),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).setEnabled(false),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withBadge("12+").withIdentifier(1)
                )
                .build();


        List<ItemObject> rowListItem = getAllItemList();

        lLayout = new GridLayoutManager(MainActivity.this, 3);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
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
                FragmentTransaction tr=getSupportFragmentManager().beginTransaction();

                tr.add(R.id.fragment,fragment0)
                        .addToBackStack(null)
                        .commit();


                Log.i("AWA","position "+position);



            }
        });










    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement



        return super.onOptionsItemSelected(item);
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

