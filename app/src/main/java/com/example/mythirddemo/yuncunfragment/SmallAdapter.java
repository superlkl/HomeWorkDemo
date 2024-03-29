package com.example.mythirddemo.yuncunfragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class SmallAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String>titleList;

    public SmallAdapter(FragmentManager fm, List<Fragment> fragments, List<String> stringList) {
        super(fm);
        fragmentList=fragments;
        titleList=stringList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

}