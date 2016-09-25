package com.kostya.parser;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.kostya.parser.adapters.RecyclerViewAdapter;
import com.kostya.parser.fragments.Fragment0;
import com.kostya.parser.fragments.FragmentMain;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Let's Cook!");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
       topToolBar.setLogo(R.mipmap.ic_launcher);
        topToolBar.setTitleTextColor(Color.WHITE);

        Fragment fragment = new FragmentMain();
        FragmentTransaction tr=getSupportFragmentManager().beginTransaction();
        tr.replace(R.id.fragment,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

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
        if(id == R.id.action_search) {
            Toast.makeText(MainActivity.this, "Эта функия ещё не сделана", Toast.LENGTH_LONG).show();
        }
        //noinspection SimplifiableIfStatement



        return super.onOptionsItemSelected(item);
    }




}
