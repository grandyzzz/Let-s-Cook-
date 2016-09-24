package com.kostya.letscook.view;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kostya.letscook.controller.ParserItem;
import com.kostya.letscook.R;
import com.kostya.letscook.controller.FoodAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Костя on 24.05.2016.
 */
public class Fragment0 extends Fragment {
    ListView lv;

    FoodAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<ParserItem> arrayList = new ArrayList<ParserItem>();
    static String URL;

    public static Fragment0 newInstance(String url){
        Fragment0 fragment = new Fragment0();
        Bundle bundle = new Bundle();
        bundle.putString("URL", url);
        URL=url;
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_0, container, false);



        new FoodData().execute();

        return v;
    }
    private class FoodData extends AsyncTask<Void, Void,Void>
    {
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
            lv = (ListView) getActivity().findViewById(R.id.listView);
            adapter = new FoodAdapter(getContext(),arrayList);
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String wURL =arrayList.get(position).getIng();

                     WebFragment.newInstance(wURL);


                    WebFragment wFragment = new WebFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment,wFragment)
                            .addToBackStack(null)
                            .commit();




                }
            });

            mProgressDialog.dismiss();
        }
    }


}
