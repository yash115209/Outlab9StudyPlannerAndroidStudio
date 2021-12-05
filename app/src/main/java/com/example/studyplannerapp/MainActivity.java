package com.example.studyplannerapp;


import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 4;
    public static ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    private String[] titles = new String[]{"Study Plans", "Exams", "Lectures", "Assignments"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager =findViewById(R.id.mypager);
        pagerAdapter = new MyPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        //inflating tab layout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //displaying tabs
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(titles[position])).attach();
    }

    private class MyPagerAdapter extends FragmentStateAdapter {

        public MyPagerAdapter(FragmentActivity fa) {
            super(fa);
        }


        @Override
        public Fragment createFragment(int pos) {
            switch (pos) {
                case 0: {
                    return FirstFragment.newInstance("fragment 1");
                }
                case 1: {

                    return SecondFragment.newInstance("fragment 2");
                }
                case 2: {
                    return ThirdFragment.newInstance("fragment 3");
                }
                case 3: {
                    return FourthFragment.newInstance("fragment 4");
                }
                default:
                    return FirstFragment.newInstance("fragment 1, Default");
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}