package com.lanou.taochangjun.gift.projectbapp.home;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;
import com.lanou.taochangjun.gift.projectbapp.home.appendix.AppendixFragment;
import com.lanou.taochangjun.gift.projectbapp.home.focus.FocusFragment;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.RecommendFragment;
import com.lanou.taochangjun.gift.projectbapp.internet.Url;

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
    private HomeVpAdapter adapter;
    private String[] title = {"关注","推荐","游戏杂谈","搞笑","萌宠","美食","娱乐"};

    @Override
    public int setlayout() {
        return R.layout.fragment_home;
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
        fragments.add(AppendixFragment.newInstance(Url.GAMETALK,Url.GAMETALKUNDER,Url.GAMETALKCode, Url.GAMETALKUNDERCode));
        fragments.add(AppendixFragment.newInstance(Url.FUNNY,Url.FUNNYUNDER,Url.FUNNYCode,Url.FUNNYUNDERCode));
//        fragments.add(AppendixFragment.newInstance(Url.ANIMATIO,Url.ANIMATIONUNDER,Url.ANIMATIOCode,Url.ANIMATIONUNDERCode));
        fragments.add(AppendixFragment.newInstance(Url.ANIMAL,Url.ANIMALUNDER,Url.ANIMALCode,Url.ANIMALUNDERCode));
        fragments.add(AppendixFragment.newInstance(Url.FOOD,Url.FOODUNDER,Url.FOODCode,Url.FOODUNDERCode));
//        fragments.add(AppendixFragment.newInstance(Url.EMELENT,Url.EMELENTUNDER,Url.EMELENTCode,Url.EMELENTUNDERCode));
//        fragments.add(AppendixFragment.newInstance(Url.HEADLINES,Url.HEADLINESUNDER,Url.HEADLINESCode,Url.HEADLINESUNDERCode));
//        fragments.add(AppendixFragment.newInstance(Url.TV,Url.TVUNDER,Url.TVCode,Url.TVUNDERCode));
//        fragments.add(AppendixFragment.newInstance(Url.LOL,Url.LOLUNDER,Url.LOLCode,Url.LOLUNDERCode));
//       fragments.add(AppendixFragment.newInstance(Url.STONE,Url.STONEUNDER,Url.STONECode,Url.STONEUNDERCode));
      //  fragments.add(AppendixFragment.newInstance(Url.VANGUARD,Url.VANGUARDUNDER,Url.VANGUARDCode,Url.VANGUARDUNDERCode));


        adapter = new HomeVpAdapter(getChildFragmentManager(),fragments);
        adapter.setTitle(title);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //让程序刚运行就显示首页中的第二个Fragment
        viewPager.setCurrentItem(1,true);

    }

}
