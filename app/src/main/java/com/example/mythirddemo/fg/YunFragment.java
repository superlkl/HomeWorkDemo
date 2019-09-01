package com.example.mythirddemo.fg;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mythirddemo.R;
import com.example.mythirddemo.yuncunfragment.PlayGroundFragment;
import com.example.mythirddemo.yuncunfragment.SmallAdapter;
import com.example.mythirddemo.yuncunfragment.StatueFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class YunFragment extends Fragment  {
//    public List<Fragment> fragmentList = new ArrayList<>();
//    public ViewPager viewPager;
//    private List<String> titleList = new ArrayList<>();
    private View view;
    TabLayout myTab;
    public YunFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.yun_fg, container, false);
        myTab = view.findViewById(R.id.my_tab);
        myTab.addTab(myTab.newTab().setText("广场").setIcon(R.mipmap.ic_launcher));
        myTab.addTab(myTab.newTab().setText("动态").setIcon(R.mipmap.ic_launcher));

        return view;

    }

}
