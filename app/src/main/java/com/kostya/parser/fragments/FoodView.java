package com.kostya.parser.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.kostya.parser.Ingredients;
import com.kostya.parser.R;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Костя on 29.05.2016.
 */
public class FoodView extends Fragment {

    private TextView tvTime;
    private ImageView colImg;
    static String URL,imgURL;
    ProgressDialog mProgressDialog;

    public static FoodView newInstance(String url, String ImgURL){
        FoodView fragment = new FoodView();
        Bundle bundle = new Bundle();
        bundle.putString("wURL", url);
        bundle.putString("imgURL",ImgURL);
        imgURL=ImgURL;
        URL=url;
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fview,container,false);



        new FoodViewData().execute();


        return v;
    }

    private class FoodViewData extends AsyncTask<Void, Void,Void> {

        String sName;
        String sTime;
        ArrayList<Ingredients> something =new ArrayList<Ingredients>();


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
                Document doc = Jsoup.connect(URL).get();
                Element name = doc.select("h1").first();

                Element table = doc.select("table").first();
                Elements rows = doc.select("tr");
                for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                    Element row = rows.get(i);
                    Elements cols = row.select("td");
                    something.add(new Ingredients(cols.get(0).text(),cols.get(1).text()));
                    Log.i("SDFS",cols.get(0).text() + " "+cols.get(1).text());
                }

               // Elements time = doc.select("");
//                Elements div = doc.select("div.b-directions");
//                Elements ol = doc.select("div.b-directions > ol.instructions");
//                Elements li = ol.select("li");
//
//                for (int i=0;i<li.size();i++)
//                {
//                    recept.add(li.get(i).select("div.text").text());
//                }


                sName=name.text();
                //sTime=time.attr("time");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.collapse_toolbar);
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            tvTime=(TextView) getActivity().findViewById(R.id.time);
            colImg=(ImageView)getActivity().findViewById(R.id.collapse_img);

            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(sName);
            tvTime.setText(sTime);
            Picasso.with(getContext()).load(imgURL).into(colImg);

            mProgressDialog.dismiss();
        }
    }

}
