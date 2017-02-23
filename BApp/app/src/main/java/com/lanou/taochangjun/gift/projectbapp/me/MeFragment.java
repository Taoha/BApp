package com.lanou.taochangjun.gift.projectbapp.me;

import android.view.View;
import android.widget.Button;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;
import com.lanou.taochangjun.gift.projectbapp.view.EnterActivity;

/**
 * Created by imac on 2017/2/20.
 * 作者:陶长骏
 */

public class MeFragment extends BaseFragment {
    private Button btn_enter;

    @Override
    public int setlayout() {
        return R.layout.fragment_me;
    }

    @Override
    public void initView(View view) {
        btn_enter = bindView(R.id.btn_enter);

    }

    @Override
    public void initData() {
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(EnterActivity.class);
            }
        });

    }
}
