package com.rafiansyahdesign.precysion;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {


    ViewGroup rootViewA;
    ImageButton btn;
    Button arrow;
    LinearLayout hiddenView;
    CardView cardView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootViewA = (ViewGroup) inflater.inflate(
                R.layout.fragment_second, container, false);

        //Button Menu
        btn = (ImageButton ) rootViewA.findViewById(R.id.MenuButton01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent is what you use to start another activity
                Intent myIntent = new Intent(SecondFragment.this.getActivity(), SidebarMenu.class);

                startActivity(myIntent);

            }
        });

        //Button Projects
        Button btn =(Button) rootViewA.findViewById(R.id.btnGoToProjects);
        View.OnClickListener listnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProjectsMain.class);
                startActivity(intent);
            }
        };
        btn.setOnClickListener(listnr);


        cardView = rootViewA.findViewById(R.id.base_cardview);
        arrow = rootViewA.findViewById(R.id.arrow_button);
        hiddenView = rootViewA.findViewById(R.id.hidden_view);

        arrow.setOnClickListener(view -> {
            // If the CardView is already expanded, set its visibility
            // to gone and change the expand less icon to expand more.
            if (hiddenView.getVisibility() == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                hiddenView.setVisibility(View.GONE);
            }

            // If the CardView is not expanded, set its visibility to
            // visible and change the expand more icon to expand less.
            else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                hiddenView.setVisibility(View.VISIBLE);
            }
        });

        rootViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootViewA.getContext().startActivity(new Intent(rootViewA.getContext(), ProjectsMain.class));
            }
        });

        return rootViewA;

    }

}
