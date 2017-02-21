package com.lanou.taochangjun.gift.projectbapp.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.AbsBaseActivity;
import com.lanou.taochangjun.gift.projectbapp.fire.FireFragment;
import com.lanou.taochangjun.gift.projectbapp.found.FoundFragment;
import com.lanou.taochangjun.gift.projectbapp.home.HomeFragment;
import com.lanou.taochangjun.gift.projectbapp.me.MeFragment;


public class MainActivity extends AbsBaseActivity implements View.OnClickListener {
    private RadioButton radio_home;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        radio_home = (RadioButton) findViewById(R.id.radio_home);
        radio_home.setOnClickListener(this);
        radio_home.setChecked(true);
        findViewById(R.id.radio_home).setOnClickListener(this);
        findViewById(R.id.radio_fire).setOnClickListener(this);
        findViewById(R.id.radio_found).setOnClickListener(this);
        findViewById(R.id.radio_me).setOnClickListener(this);


    }

    @Override
    protected void initData() {
        //让程序刚运行就显示选中第一个
        replace(new HomeFragment());

    }

    private void replace(Fragment f) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_layout, f);
        transaction.commit();


    }


    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.radio_home:
                transaction.replace(R.id.frame_layout,new HomeFragment());
                break;
            case R.id.radio_fire:
                transaction.replace(R.id.frame_layout,new FireFragment());
                break;
            case R.id.radio_found:
                transaction.replace(R.id.frame_layout,new FoundFragment());
                break;
            case R.id.radio_me:
                transaction.replace(R.id.frame_layout,new MeFragment());
                break;
        }
        transaction.commit();


    }
}
