package com.example.android.mymusic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by happyding3 on 2016/10/1.
 */

public class simpleFragmentPagerAdapter extends FragmentPagerAdapter {
    public simpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new HomeFragment();
        }else if (position==1){
            return new MyMusicFragment();
        }else {
            return new FavoriteFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
