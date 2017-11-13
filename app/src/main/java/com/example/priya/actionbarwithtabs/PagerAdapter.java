package com.example.priya.actionbarwithtabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import java.util.List;

/**
 * Created by Priya on 11/13/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;


    public PagerAdapter(FragmentManager supportFragmentManager, List<Fragment> fragments) {
        super(supportFragmentManager);
        this.fragments= fragments;
    }

    @Override
    public Fragment getItem(int position) {
        // Our object is just an integer

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
