package com.rafiansyahdesign.precysion.levelIntermediate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rafiansyahdesign.precysion.R;

public class L2_M2_Page2 extends Fragment {

    ViewGroup rootViewA;
    // on below line we are creating variables.
    WebView myWebView;
    String mapPath = "https://www.youtube.com/embed/_WI3B54m6SU?autoplay=1&fs=1&mute=0";


    // Your Video URL
    String videoUrl = "https://www.youtube.com/watch?v=_WI3B54m6SU";


    public L2_M2_Page2() {
        // required empty public constructor.
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootViewA = (ViewGroup) inflater.inflate(
                R.layout.l2__m2__page2, container, false);

        myWebView = (WebView) rootViewA.findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl(mapPath);

//        //DIsable Touch
//        myWebView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
        return rootViewA;

    }

}

// on below line we are initializing our variables.



