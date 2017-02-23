package com.lanou.taochangjun.gift.projectbapp.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;
import com.lanou.taochangjun.gift.projectbapp.home.focus.FocusFragment;

import java.util.ArrayList;

/**
 * Created by imac on 2017/2/20.
 */
/**
 * 作者:陶长骏
 * 作用:首页页面的Fragment
 */

public class HomeFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    public int setlayout() {
        return R.layout.tab_vp;
    }

    @Override
    public void initView(View view) {
        tabLayout = bindView(R.id.tb_home_top);
        viewPager = bindView(R.id.vp_home_top);

    }

    @Override
    public void initData() {


        fragments.add(new FocusFragment());
        fragments.add(new RecommendFragment());
        HomeVpAdapter adapter = new HomeVpAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //让程序刚运行就显示首页中的第二个Fragment
        viewPager.setCurrentItem(2,true);

    }

}
