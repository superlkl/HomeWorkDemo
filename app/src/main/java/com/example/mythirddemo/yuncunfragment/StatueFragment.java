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
public class StatueFragment extends Fragment {
    private View view;

    public StatueFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.statue_fg, container, false);
        return view;
    }
}
