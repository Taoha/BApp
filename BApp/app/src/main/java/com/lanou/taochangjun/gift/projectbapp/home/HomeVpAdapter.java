package com.lanou.taochangjun.gift.projectbapp.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by imac on 2017/2/20.
 */

public class HomeVpAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private String[] title = {"关注","推荐","游戏杂谈","搞笑","动画","萌宠","美食","二次元","娱乐","网剧","英雄联盟","炉石传说","守望先锋"};
    public HomeVpAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
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
