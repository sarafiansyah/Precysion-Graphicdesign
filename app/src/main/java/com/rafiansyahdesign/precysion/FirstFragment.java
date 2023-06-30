package com.rafiansyahdesign.precysion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.rafiansyahdesign.precysion.levelIntermediate.L2_M2_Course;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    ViewGroup rootViewA;
    ImageButton btn;
    // Urls of our images.
    String url1 = "https://i.ibb.co/tx9MGMT/pcy-ads01.png";
    String url2 = "https://i.ibb.co/KLKhK7q/pcy-ads02.png";
    String url3 = "https://i.ibb.co/YTkK3Mx/pcy-ads03.png";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootViewA = (ViewGroup) inflater.inflate(
                R.layout.fragment_first, container, false);

        //Button Menu
        btn = (ImageButton ) rootViewA.findViewById(R.id.MenuButton01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent is what you use to start another activity
                Intent myIntent = new Intent(FirstFragment.this.getActivity(), SidebarMenu.class);

                startActivity(myIntent);

            }
        });

        //Button Logout
        btn = (ImageButton ) rootViewA.findViewById(R.id.LogoutButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent is what you use to start another activity
                Intent myIntent = new Intent(FirstFragment.this.getActivity(), LoginMain00.class);

                startActivity(myIntent);

            }
        });

        //Button Content 1
        Button btn =(Button) rootViewA.findViewById(R.id.btn_l1_m1_course);
        View.OnClickListener listnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), L1_M1_Course.class);
                startActivity(intent);
            }
        };
        btn.setOnClickListener(listnr);

        //Button Content 2
        Button btn2 =(Button) rootViewA.findViewById(R.id.btn_l2_m2_course);
        View.OnClickListener listnr2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), L2_M2_Course.class);
                startActivity(intent);
            }
        };
        btn2.setOnClickListener(listnr2);

        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = rootViewA.findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();


        return rootViewA;

    }

}
