package com.rafiansyahdesign.precysion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class L1_M1_Page4 extends Fragment {

    ViewGroup rootViewA;
    ImageButton btn;
    // Urls of our images.
    String url1 = "https://i.ibb.co/FmmtVKk/back.png";
    String url2 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";
    String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootViewA = (ViewGroup) inflater.inflate(
                R.layout.l1__m1__page4, container, false);



        //Button Finish
        Button btn =(Button) rootViewA.findViewById(R.id.l1_m1_finish);
        View.OnClickListener listnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CourseFinish.class);
                startActivity(intent);
            }
        };
        btn.setOnClickListener(listnr);



        return rootViewA;

    }

}
