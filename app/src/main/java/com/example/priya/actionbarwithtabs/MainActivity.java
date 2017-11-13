package com.example.priya.actionbarwithtabs;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> fragments = new Vector<>();
        fragments.add(Fragment.instantiate(this, Fragment1.class.getName()));
        fragments.add(Fragment.instantiate(this, Fragment2.class.getName()));

        // ViewPager and its adapters use support library fragments, so use getSupportFragmentManager.
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        final ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        //set adapter
        pager.setAdapter(adapter);
        final ActionBar actionBar = getSupportActionBar();

        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


// Create a tab listener that is called when the user changes tabs.
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                // show the given tab

                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // hide the given tab


            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // probably ignore this event


            }
        };
        actionBar.addTab(actionBar.newTab().setText("Audio").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Video").setTabListener(tabListener));

        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void onPageSelected(int position) {
                // When swiping between pages, select the corresponding tab.

                actionBar.setSelectedNavigationItem(position);
            }
        });


    }
}


