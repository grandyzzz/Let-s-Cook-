package com.kostya.parser.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kostya.parser.ItemClickSupport;
import com.kostya.parser.ParserItem;
import com.kostya.parser.R;
import com.kostya.parser.adapters.FoodAdapter;
import com.kostya.parser.adapters.LiveRecyclerViewAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Степучева Наталья on 25.09.2016.
 */

public class LiveFragment extends Fragment {
    RecyclerView rv;
    TextView textView;
    LiveRecyclerViewAdapter lrvAdapter;
    ProgressDialog mProgressDialog;
    ArrayList<ParserItem> arrayList = new ArrayList<ParserItem>();
    LinearLayoutManager linearLayoutManager;
    static String URL;
    static String timeOfEat;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_live, container, false);
//
        new LiveData().execute();

        return v;
    }
    private class LiveData extends AsyncTask<Void, Void,Void>
    {
        public  boolean isBetween(int x, int lower, int upper) {
            return lower <= x && x <= upper;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(getContext());
            mProgressDialog.setTitle("Let's cook!");
            mProgressDialog.setMessage("Загрузка...");
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {

                Calendar c = Calendar.getInstance();
        int hours = c.get(Calendar.HOUR_OF_DAY);
                if (isBetween(hours,7,12))
                {
                    URL="http://eda.ru/recepty/zavtraki";
                    timeOfEat="Пора завтракать!";
                } else
                if (isBetween(hours,13,15))
                {
                    URL="http://eda.ru/recepty/osnovnye-blyuda";
                    timeOfEat="Пора обедать!";
                }else
                if (isBetween(hours,16,17))
                {
                    URL="http://eda.ru/recepty/postnaya-eda/salaty";
                    timeOfEat="Пора есть салатик!";
                }else
                if (isBetween(hours,18,21))
                {
                    URL="http://eda.ru/recepty/sendvichi";
                    timeOfEat="Пора ужинать!";
                }


                Document doc = Jsoup.connect(URL).get();


                Elements name = doc.select("h3");
                Elements image = doc.select("a img[src]");
                Elements ing = doc.select("h3 a[href]");

                arrayList.clear();

                int k=0;
                for (Element names: name)
                {
                    ParserItem pI = new ParserItem();
                    pI.setName(names.text());
                    pI.setImg(image.get(k).attr("src"));
                    pI.setIng(ing.get(k).attr("abs:href"));
                    arrayList.add(pI);

                    k++;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            textView=(TextView) getActivity().findViewById(R.id.txt_live) ;
            rv = (RecyclerView) getActivity().findViewById(R.id.recycler_live);
            linearLayoutManager = new LinearLayoutManager(getContext());

            rv.setLayoutManager(linearLayoutManager);
            lrvAdapter = new LiveRecyclerViewAdapter(getContext(),arrayList);
            rv.setAdapter(lrvAdapter);
            textView.setText(timeOfEat);

            ItemClickSupport.addTo(rv).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    String wURL =arrayList.get(position).getIng();
                    String imgURL=arrayList.get(position).getImg();

                    FoodView.newInstance(wURL,imgURL);

                    FoodView wFragment = new FoodView();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.add(R.id.main_container,wFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addToBackStack(null)
                            .commit();
                }

            });

            mProgressDialog.dismiss();
        }
    }
}
