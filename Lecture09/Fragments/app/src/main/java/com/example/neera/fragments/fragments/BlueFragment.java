package com.example.neera.fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.neera.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlueFragment extends Fragment {


    public BlueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_blue, container, false);
        rootview.findViewById(R.id.tvBLUE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "BLUE Fragment Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return rootview;
    }

}
