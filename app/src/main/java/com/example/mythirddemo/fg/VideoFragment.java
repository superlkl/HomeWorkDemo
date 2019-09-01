package com.example.mythirddemo.fg;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mythirddemo.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {
    private static final String TAG = "VideoFragment";
    private View view;
    private TabLayout myTab2;

    private List<String> mTitle;
    private List<Fragment> mFragment;
    private ViewPager mViewPager;


    public VideoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.video_fg, container, false);
        myTab2 = (TabLayout) view.findViewById(R.id.my_tab2);
        mViewPager = (ViewPager)view.findViewById(R.id.mViewPager);

        initTabLayout();



        Log.d(TAG, "onCreateView: ");

        mFragment = new ArrayList<>();
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());
        mFragment.add(new Fragment());

        mViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });
        mViewPager.setOffscreenPageLimit(2);
        myTab2.setupWithViewPager(mViewPager);

        return view;
    }

    private void initTabLayout(){
        mTitle = new ArrayList<>();
        mTitle.add("推荐");
        mTitle.add("Look直播");
        mTitle.add("音乐画像");
        mTitle.add("Truth Hurts");
        mTitle.add("现场");
        mTitle.add("生活在云村");
        mTitle.add("翻唱");
        mTitle.add("MV");
        mTitle.add("舞蹈");
        mTitle.add("听BGM");
        mTitle.add("广场");
        mTitle.add("ACG音乐");

    }

}
