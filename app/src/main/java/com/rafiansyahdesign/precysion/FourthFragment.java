package com.rafiansyahdesign.precysion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class FourthFragment extends Fragment {

    String html = "<iframe width=\"450\" height=\"260\" style=\"border: 1px solid #cccccc;\" src=\"http://api.thingspeak.com/channels/31592/charts/1?width=450&height=260&results=60&dynamic=true\" ></iframe>";
    ViewGroup rootViewA;
    ImageButton btn;
    WebView myWebView;
    String mapPath = "https://www.google.com/maps/place/Mahesa+Creative+Company/@-6.1927207,106.7003195,19z/data=!4m9!1m2!2m1!1smahesa+!3m5!1s0x2e69f905e7eedc0d:0x4936a8c57bf4e7d1!8m2!3d-6.1927207!4d106.7008893!15sCgZtYWhlc2GSARBjb3Jwb3JhdGVfb2ZmaWNl4AEA";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootViewA = (ViewGroup) inflater.inflate(
                R.layout.fragment_fourth, container, false);

        //Button Menu
        btn = (ImageButton ) rootViewA.findViewById(R.id.MenuButton01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent is what you use to start another activity
                Intent myIntent = new Intent(FourthFragment.this.getActivity(), SidebarMenu.class);

                startActivity(myIntent);

            }
        });

        //Button Facebook
        btn = (ImageButton ) rootViewA.findViewById(R.id.btnFacebook);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com/mahesa.rafiansyah/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });


        //Button Instagram
        btn = (ImageButton ) rootViewA.findViewById(R.id.btnInstagram);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.instagram.com/sa_rafiansyah/?hl=en";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });

        //Button Maps
        Button btn =(Button) rootViewA.findViewById(R.id.btnMaps01);
        View.OnClickListener listnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/maps/place/Mahesa+Creative+Company/@-6.1927207,106.7003195,19z/data=!4m9!1m2!2m1!1smahesa+!3m5!1s0x2e69f905e7eedc0d:0x4936a8c57bf4e7d1!8m2!3d-6.1927207!4d106.7008893!15sCgZtYWhlc2GSARBjb3Jwb3JhdGVfb2ZmaWNl4AEA";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };
        btn.setOnClickListener(listnr);

        myWebView = (WebView) rootViewA.findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(mapPath);

        //Matiin Touch (Disable)
        myWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        return rootViewA;

    }

}
