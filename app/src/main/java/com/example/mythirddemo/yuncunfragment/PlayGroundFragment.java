package com.example.mythirddemo.yuncunfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mythirddemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayGroundFragment extends Fragment {


    public PlayGroundFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.play_ground_fg, container, false);
    }

}
