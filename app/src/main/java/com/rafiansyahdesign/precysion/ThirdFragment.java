package com.rafiansyahdesign.precysion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import com.daprlabs.cardstack.SwipeDeck;
import java.util.ArrayList;

public class ThirdFragment extends Fragment {

    ViewGroup rootViewA;
    ImageButton btn;
    private SwipeDeck cardStack;
    private ArrayList<SwipeCard> courseModalArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootViewA = (ViewGroup) inflater.inflate(R.layout.fragment_third, container, false);

        //Button Menu
        btn = (ImageButton ) rootViewA.findViewById(R.id.MenuButton01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent is what you use to start another activity
                Intent myIntent = new Intent(ThirdFragment.this.getActivity(), SidebarMenu.class);

                startActivity(myIntent);

            }
        });
        

        // on below line we are initializing our array list and swipe deck.
        courseModalArrayList = new ArrayList<>();
        cardStack = (SwipeDeck) rootViewA.findViewById(R.id.swipe_deck);

        // on below line we are adding data to our array list.
        courseModalArrayList.add(new SwipeCard("Graphic Design", "01/01/2023", "Precysion Team", "Graphic design is a profession, academic discipline and applied art whose activity consists in projecting visual communications to transmit specific messages.", R.drawable.tipscard_asset04));
        courseModalArrayList.add(new SwipeCard("William Addison Dwiggins", "01/01/2023", "Precysion Team", "William Addison Dwiggins coined the term 'graphic designer' to describe his activities as an individual who brought structural order and visual form to printed communications, that an emerging profession received an appropriate name", R.drawable.tipscard_asset01));
        courseModalArrayList.add(new SwipeCard("About Precysion", "02/01/2023", "Mahesa Rafian Syah", "Precysion was inspired from the eyes of an eagle, ehich represents accuracy and precision as well.", R.drawable.tipscard_asset02));
        courseModalArrayList.add(new SwipeCard("UKRIDA", "30 days", "20 Tracks", "Universitas Kristen Krida Wacana, the university where the developer studies, has various unique things inside.", R.drawable.tipscard_asset03));
        courseModalArrayList.add(new SwipeCard("DSA", "30 days", "20 Tracks", "DSA Self Paced Course", R.drawable.tipscard_asset05));
        courseModalArrayList.add(new SwipeCard("PHP", "30 days", "20 Tracks", "PHP Self Paced Course", R.drawable.tipscard_asset06));

        // on below line we are creating a variable for our adapter class and passing array list to it.
        final SwipeCardAdapter adapter = new SwipeCardAdapter(courseModalArrayList, this.getActivity());

        // on below line we are setting adapter to our card stack.
        cardStack.setAdapter(adapter);

        return rootViewA;

    }

}
