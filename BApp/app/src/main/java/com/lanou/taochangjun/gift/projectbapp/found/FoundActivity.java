package com.lanou.taochangjun.gift.projectbapp.found;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.AbsBaseActivity;
import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;
import java.util.List;

public class FoundActivity extends AbsBaseActivity implements View.OnClickListener {


    private ImageView mHome_search_big;
    private LiteOrm mLiteOrm;

    @Override
    protected int getLayout() {
        return R.layout.activity_found;
    }

    @Override
    protected void initView() {
        mLiteOrm = LiteOrm.newSingleInstance(this, "person.db");
        mHome_search_big = byView(R.id.home_search_big);
        mHome_search_big.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_search_big:
                break;
        }

    }
    private List<FoundActBean> buildData(){
        List<FoundActBean> l = new ArrayList<>();
        l.add(new FoundActBean(

        ));
        l.add(new FoundActBean("大力金刚"));
        l.add(new FoundActBean("美女"));
        l.add(new FoundActBean("陈翔六点半"));
        l.add(new FoundActBean("污视频"));
        l.add(new FoundActBean("美少女大批叉"));
        l.add(new FoundActBean("许老师来巡山"));
        l.add(new FoundActBean("傻逼"));

        mLiteOrm.insert(l);
        return l;
    }
}
