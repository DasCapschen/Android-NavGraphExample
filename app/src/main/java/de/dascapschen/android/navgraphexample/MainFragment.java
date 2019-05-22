package de.dascapschen.android.navgraphexample;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment
{


    public MainFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        //setup onClick events for our buttons
        //use the new Navigation component to easily do this
        view.findViewById(R.id.btnSettings).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_toSettings));

        view.findViewById(R.id.btnAbout).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_toAbout));
    }
}
