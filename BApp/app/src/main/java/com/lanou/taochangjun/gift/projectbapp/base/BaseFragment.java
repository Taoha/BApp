package com.lanou.taochangjun.gift.projectbapp.base;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by imac on 2017/2/16.
 * fragment的基类
 * 作者:陶长骏
 */

public abstract class BaseFragment extends android.support.v4.app.Fragment{


   protected Context mContent;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContent = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setlayout(),container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    //绑定布局
    public abstract int setlayout();
    //初始化组件
    public abstract void initView(View view);
    //写逻辑代码
    public abstract void initData();
    //findViewById操作
    public <T extends View> T bindView(int id){
        return (T) getView().findViewById(id);
    }
    //跳转
    protected void goTo(Class<? extends AbsBaseActivity> to) {
        Intent intent = new Intent();
        intent.setClass(getContext(), to);
        startActivity(intent);
    }
}
