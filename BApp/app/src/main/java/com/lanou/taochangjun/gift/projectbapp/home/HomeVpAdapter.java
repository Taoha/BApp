package com.lanou.taochangjun.gift.projectbapp.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by imac on 2017/2/20.
 */
/**
 * 作者:陶长骏
 * 作用:首页页面的标题获取
 */

public class HomeVpAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private  String[] title;

    public void setTitle(String[] title) {
        this.title = title;
    }

    public HomeVpAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }



    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
