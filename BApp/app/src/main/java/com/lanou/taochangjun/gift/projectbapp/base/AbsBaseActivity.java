package com.lanou.taochangjun.gift.projectbapp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;

/**
 * Created by imac on 2017/2/15.
 * <p>
 * Activity基类
 * 作者:陶长骏
 */

public abstract class AbsBaseActivity extends AppCompatActivity {

    private LinearLayout mRootlayout;
    private RelativeLayout mTitleLayout;
    private ImageView mBackIv;
    private TextView mTitleTv;
    private ImageView mRightIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 封装简单的标题栏的步骤
         * 1给基类绑定一个大的布局
         */

        //1.定制一个流程界面也就是绑定布局/初始化代码/编写逻辑代码
        setContentView(R.layout.root_layout);
        mRootlayout = (LinearLayout) findViewById(R.id.base_root_layout);
        //2.处理子页面的布局
        View childView = getLayoutInflater()
                .inflate(getLayout(), null);
        // 3.将子界面加入根布局
        mRootlayout.addView(childView);
// 4.处理标题栏
        mTitleLayout = (RelativeLayout) findViewById(R.id.title_layout);
        mBackIv = (ImageView) findViewById(R.id.title_back_iv);
        mTitleTv = (TextView) findViewById(R.id.title_middle_tv);
        mRightIv = (ImageView) findViewById(R.id.title_right_iv);
        mBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        initTitle(mTitleLayout,mBackIv,mTitleTv,mRightIv);
        initView();
        initData();
    }
    //标题
    protected abstract void initTitle(RelativeLayout mTitleLayout, ImageView mBackIv,TextView mTitleTv,ImageView mRightIv);

    //定绑定布局
    protected abstract int getLayout();

    //初始化代码
    protected abstract void initView();

    //编写逻辑代码
    protected abstract void initData();

    //精简findViewByid
    protected <V extends View> V byView(int resId) {
        return (V) findViewById(resId);
    }

    //跳转
    protected void goTo(Class<? extends AbsBaseActivity> to) {
        Intent intent = new Intent();
        intent.setClass(this, to);
        startActivity(intent);
    }

    /**
     * 跳转传String
     */
    protected void goTo(Class<? extends AbsBaseActivity> to, String key, String extraValue) {
        Intent intent = new Intent(this, to);
        intent.putExtra(key, extraValue);
        startActivity(intent);

    }

    /**
     * 跳转传int
     */
    protected void goTo(Class<? extends AbsBaseActivity> to, String key, int extraValue) {
        Intent intent = new Intent(this, to);
        intent.putExtra(key, extraValue);
        startActivity(intent);

    }

    /**
     * 跳转传long
     */
    protected void goTo(Class<? extends AbsBaseActivity> to, String key, long extraValue) {
        Intent intent = new Intent(this, to);
        intent.putExtra(key, extraValue);
        startActivity(intent);
    }

    /**
     * 跳转传其他
     * 我想传2个int，3个String，一个Object
     * <p>
     * 我想传1个Map，2个List
     */
    public void goTo(Class<? extends AbsBaseActivity> to,
                     Bundle bundle) {
        // Bundle 小型的数据存储类
        Intent intent = new Intent(this, to);
//        intent.putExtra("",bundle);
        intent.putExtras(bundle);

        startActivity(intent);

    }

}
