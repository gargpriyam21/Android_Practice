package com.example.neera.viewpatterns.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neera.viewpatterns.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlaceholderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaceholderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_BAKGROUND_COLOR = "backgroub_color";
    private static final String ARG_TEXT = "text";

    private int backgroundcolor;
    private String text;


    public PlaceholderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param backgroundcolor Parameter 1.
     * @param text            Parameter 2.
     * @return A new instance of fragment PlaceholderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlaceholderFragment newInstance(int backgroundcolor, String text) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_BAKGROUND_COLOR, backgroundcolor);
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            backgroundcolor = getArguments().getInt(ARG_BAKGROUND_COLOR);
            text = getArguments().getString(ARG_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_blank, container, false);
        (fragmentView.findViewById(R.id.flFragmentBackground)).setBackgroundColor(backgroundcolor);
        ((TextView) fragmentView.findViewById(R.id.tvFragmentText))
                .setText(text);
        return fragmentView;
    }

}
