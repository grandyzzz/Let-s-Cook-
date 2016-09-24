package com.kostya.parser.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.kostya.parser.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Костя on 29.05.2016.
 */
public class FoodView extends Fragment {

   private WebView webView;
    static String URL;
    ProgressDialog mProgressDialog;

    public static FoodView newInstance(String url){
        FoodView fragment = new FoodView();
        Bundle bundle = new Bundle();
        bundle.putString("wURL", url);
        URL=url;
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fviewr,container,false);



        new FoodViewData().execute();


        return v;
    }

    private class FoodViewData extends AsyncTask<Void, Void,Void> {

        String sName;

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
                Elements name = doc.select("h1");




                sName=name.text();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.collapse_toolbar);
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(sName);

            mProgressDialog.dismiss();
        }
    }

}
