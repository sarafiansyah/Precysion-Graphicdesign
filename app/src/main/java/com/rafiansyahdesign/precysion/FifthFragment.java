package com.rafiansyahdesign.precysion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;

public class FifthFragment extends Fragment {

    ViewGroup rootViewA;
    ImageButton btn;
    private ReviewManager reviewManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootViewA = (ViewGroup) inflater.inflate(
                R.layout.fragment_fifth, container, false);

        //Button Menu
        btn = (ImageButton) rootViewA.findViewById(R.id.MenuButton01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent is what you use to start another activity
                Intent myIntent = new Intent(FifthFragment.this.getActivity(), SidebarMenu.class);

                startActivity(myIntent);

            }
        });


        //Button Project
        Button btn = (Button) rootViewA.findViewById(R.id.btnProjects);
        View.OnClickListener listnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProjectsMain.class);
                startActivity(intent);
            }
        };
        btn.setOnClickListener(listnr);

        //Button Music
        Button btnMusic = (Button) rootViewA.findViewById(R.id.btnMusicPlayer);
        View.OnClickListener Musiclistnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MusicPlayer.class);
                startActivity(intent);
            }
        };
        btnMusic.setOnClickListener(Musiclistnr);

        //Button Exit
        Button btnExit = (Button) rootViewA.findViewById(R.id.btnRate);
        View.OnClickListener Exitlistnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getActivity().finish();
                System.exit(0);
            }
        };
        btnExit.setOnClickListener(Exitlistnr);


        init();

        return rootViewA;


    }

    // Initializing method
    private void init() {
        reviewManager = ReviewManagerFactory.create(getContext());
        // Referencing the button
        rootViewA.findViewById(R.id.btnRate).setOnClickListener(view -> showRateApp());
    }


    // Shows the app rate dialog box using In-App review API
    // The app rate dialog box might or might not shown depending
    // on the Quotas and limitations
    public void showRateApp() {
        Task<ReviewInfo> request = reviewManager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // Getting the ReviewInfo object
                ReviewInfo reviewInfo = task.getResult();

                Task<Void> flow = reviewManager.launchReviewFlow(getActivity(), reviewInfo);
                flow.addOnCompleteListener(task1 -> {
                    // The flow has finished. The API does not indicate whether the user
                    // reviewed or not, or even whether the review dialog was shown.
                });
            }
        });

    }
}

