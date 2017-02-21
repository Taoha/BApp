package com.lanou.taochangjun.gift.projectbapp.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by imac on 2017/2/20.
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
        tabLayout = (TabLayout) view.findViewById(R.id.tb_home_top);
        viewPager = (ViewPager) view.findViewById(R.id.vp_home_top);

    }

    @Override
    public void initData() {
        //让程序刚运行就显示选中第一个
       replace (new RecommendFragment());

        fragments.add(new FocusFragment());
        fragments.add(new RecommendFragment());
        HomeVpAdapter adapter = new HomeVpAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    public void replace(Fragment fragment) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.replace, fragment);
        transaction.commit();
    }
}
