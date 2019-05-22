package de.dascapschen.android.navgraphexample;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment
{


    public AboutFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(getArguments().getString("title"));

        //!!! Das ist nicht nötig wenn die Nav ausschließlich über den Drawer funktioniert!!!
        //ist nur ein problem wegen den buttons und menu items!!!
        //(wobei die buttons wahrscheinlich garnicht navigieren sollten
        //und die menu item neue activities öffnen sollten)
        MainActivity activity = (MainActivity) getActivity();
        activity.navView.setCheckedItem(R.id.drawer_item_about);

    }
}
