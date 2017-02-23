package com.lanou.taochangjun.gift.projectbapp.view;

import android.view.View;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.AbsBaseActivity;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;

/**
 * Created by imac on 2017/2/23.
 */
public class EnterActivity extends AbsBaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_enter;
    }

    @Override
    protected void initView() {
        findViewById(R.id.iv_X).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {

    }
}
