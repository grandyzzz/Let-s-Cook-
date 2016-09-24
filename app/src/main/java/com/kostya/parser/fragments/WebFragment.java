package com.kostya.parser.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kostya.parser.R;

/**
 * Created by Костя on 29.05.2016.
 */
public class WebFragment extends Fragment {

   private WebView webView;
    static String URL;

    public static WebFragment newInstance(String url){
        WebFragment fragment = new WebFragment();
        Bundle bundle = new Bundle();
        bundle.putString("wURL", url);
        URL=url;
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_web,container,false);

        webView = (WebView) v.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(URL);



        return v;
    }


}
