package com.lanou.taochangjun.gift.projectbapp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by imac on 2017/2/15.
 *
 * Activity基类
 * 作者:陶长骏
 *
 */

public abstract class AbsBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //定制一个流程界面也就是绑定布局/初始化代码/编写逻辑代码
        setContentView(getLayout());
        initView();
        initData();
    }
    //定绑定布局
    protected abstract int getLayout();
    //初始化代码
    protected abstract void initView();
    //编写逻辑代码
    protected abstract void initData();

    //精简findViewByid
    protected <V extends View >V byView(int resId){
        return (V) findViewById(resId);
    }
    //跳转
    protected void  goTo(Class<? extends  AbsBaseActivity> to){
        Intent intent = new Intent();
        intent.setClass(this,to);
        startActivity(intent);
    }

}
