package com.example.arnav.balthazar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Arnav on 23/11/2016.
 */

public class ViewPagerAdapterDetail extends FragmentStatePagerAdapter {

    public ViewPagerAdapterDetail(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new About();
        }
        else if(position == 1){
            return new Offers();
        }
        else
            return new Map();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
