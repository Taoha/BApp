package com.lanou.taochangjun.gift.projectbapp.view;

import android.os.CountDownTimer;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.AbsBaseActivity;


/**
 * 欢迎页面, 制作者:张德鹏 2月22日
 *
 *  timer 计时器
 *  imageView 欢迎页背景
 *  next      跳过图片
 *  number    计时数字
 */
public class WelcomeActivity extends AbsBaseActivity {

    private CountDownTimer timer;
    private ImageView imageView;
    private TextView number;
    private  int a =0;
    private  int b = 6;
    private ImageView next;

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;

    }

    @Override
    protected void initView() {
        imageView = byView(R.id.activity_welcome_iv);
        imageView.setImageResource(R.mipmap.splash_bg);
        next = byView(R.id.activity_welcome_iv_next);
        number = byView(R.id.activity_welcome_tv_number);

    }

    @Override
    protected void initData() {

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                goTo(MainActivity.class);
                finish();
            }
        });


          timer = new CountDownTimer(7000,1000) {
              @Override
              public void onTick(long millisUntilFinished) {
                   a++;
                  b--;
                  Log.d("WelcomeActivity", "a:" + a+b);
                  if (a == 3|| a == 4 || a == 5|| a ==6){
                      next.setImageResource(R.mipmap.ic_video_play);
                      number.setText("跳过"+b+"s");
                      imageView.setImageResource(R.mipmap.splash_without_load);
                  }
              }

              @Override
              public void onFinish() {
                    goTo(MainActivity.class);
                  finish();
              }
          }.start();
    }


}
