package com.lanou.taochangjun.gift.projectbapp.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.WebViewActivity.WebViewActivity;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;
import com.lanou.taochangjun.gift.projectbapp.view.EnterActivity;
import com.lanou.taochangjun.gift.projectbapp.view.RecordActivity;
import com.xys.libzxing.zxing.activity.CaptureActivity;

/**
 * Created by imac on 2017/2/20.
 * 作者:陶长骏
 */

public class MeFragment extends BaseFragment {
    private Button btn_enter;
    private ImageView zxing;
    private TextView record_tv;

    @Override
    public int setlayout() {
        return R.layout.fragment_me;
    }

    @Override
    public void initView(View view) {
        btn_enter = bindView(R.id.btn_enter);
        zxing = bindView(R.id.fragment_me_zxing);
        record_tv = bindView(R.id.record_tv);
        record_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecordActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(EnterActivity.class);
            }
        });

        // 二维码扫描  德鹏
        zxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CaptureActivity.class);

                startActivityForResult(intent,0);
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==  0 && data != null){
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Intent intent = new Intent(getContext(), WebViewActivity.class);
            intent.putExtra("webView",result);

            startActivity(intent);
        }else {
            Toast.makeText(mContent, "你扫的是啥么啊", Toast.LENGTH_SHORT).show();
        }
    }
}
