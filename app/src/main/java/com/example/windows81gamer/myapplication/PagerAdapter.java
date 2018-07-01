package com.example.windows81gamer.myapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag=new Fragment1();
                break;
            case 1:
                frag=new Fragment3();
                break;
            case 2:
                frag=new Fragment22();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Cau hoi 1";
                break;
            case 1:
                title = "Cau hoi 2";
                break;
            case 2:
                title = "Cau hoi 3";
                break;
        }
        return title;
    }
}