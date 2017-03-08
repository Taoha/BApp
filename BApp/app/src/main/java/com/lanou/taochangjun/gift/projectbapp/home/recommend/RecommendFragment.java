package com.lanou.taochangjun.gift.projectbapp.home.recommend;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;

/**
 * Created by imac on 2017/2/21.
 */
/**
 * 张德鹏
 * 推荐页面的fragment
 */
public class RecommendFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private RecommendRecycleViewAdapter adapter ;





    @Override
    public int setlayout() {
        return R.layout.fragment_home_recommend;
    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_home_recommend_rv);
        adapter = new RecommendRecycleViewAdapter(getContext());
    }

    @Override
    public void initData() {

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }





}
