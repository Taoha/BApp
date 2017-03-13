package com.lanou.taochangjun.gift.projectbapp.me;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.map.MapActivity;
import com.lanou.taochangjun.gift.projectbapp.webview.WebViewActivity;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;
import com.lanou.taochangjun.gift.projectbapp.view.EnterActivity;
import com.mob.tools.utils.UIHandler;
import com.squareup.picasso.Picasso;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by imac on 2017/2/20.
 * 作者:陶长骏
 */

public class MeFragment extends BaseFragment implements PlatformActionListener, Handler.Callback {
    private Button btn_enter;
    private ImageView zxing,map,login,back;
    private TextView name,saonian;


    private static final int MSG_TOAST = 1;
    private static final int MSG_ACTION_CCALLBACK = 2;
    private static final int MSG_CANCEL_NOTIFY = 3;
    private Platform pf;
    private ImageView imageView;

    @Override
    public int setlayout() {
        return R.layout.fragment_me;
    }

    @Override
    public void initView(View view) {
        btn_enter = bindView(R.id.btn_enter);
        zxing = bindView(R.id.fragment_me_zxing);
        map = bindView(R.id.fragment_me_map);
        login = bindView(R.id.item_me_login);
        name = bindView(R.id.item_me_name);
        imageView = bindView(R.id.circleImageView);
        saonian = (TextView) view.findViewById(R.id.saonian);
        back = bindView(R.id.image_set);


        ShareSDK.initSDK(getContext());



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

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapActivity.class);

                startActivity(intent);
            }
        });
         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                  thirdSinaLogin();
             }
         });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
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





    private void thirdSinaLogin(){
        pf = ShareSDK.getPlatform(getContext(), SinaWeibo.NAME);
        pf.SSOSetting(true);
        //设置监听
        pf.setPlatformActionListener(this);
        //获取登陆用户的信息，如果没有授权，会先授权，然后获取用户信息
        pf.authorize();
        pf.showUser(null);
    }


    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        /** res是返回的数据，例如showUser(null),返回用户信息，对其解析就行
         *   http://sharesdk.cn/androidDoc/cn/sharesdk/framework/PlatformActionListener.html
         *   1、不懂如何解析hashMap的，可以上网搜索一下
         *   2、可以参考官网例子中的GetInforPage这个类解析用户信息
         *   3、相关的key-value,可以看看对应的开放平台的api
         *     如新浪的：http://open.weibo.com/wiki/2/users/show
         *     腾讯微博：http://wiki.open.t.qq.com/index.php/API%E6%96%87%E6%A1%A3/%E5%B8%90%E6%88%B7%E6%8E%A5%E5%8F%A3/%E8%8E%B7%E5%8F%96%E5%BD%93%E5%89%8D%E7%99%BB%E5%BD%95%E7%94%A8%E6%88%B7%E7%9A%84%E4%B8%AA%E4%BA%BA%E8%B5%84%E6%96%99
         *
         */
        Message msg = new Message();
        msg.what = MSG_ACTION_CCALLBACK;
        msg.arg1 = 1;
        msg.arg2 = i;
        msg.obj = platform;
        UIHandler.sendMessage(msg, this);
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        throwable.printStackTrace();
        throwable.getMessage();
        Message msg = new Message();
        msg.what = MSG_ACTION_CCALLBACK;
        msg.arg1 = 2;
        msg.arg2 = i;
        msg.obj = throwable;
        UIHandler.sendMessage(msg, this);
    }

    @Override
    public void onCancel(Platform platform, int i) {
        Message msg = new Message();
        msg.what = MSG_ACTION_CCALLBACK;
        msg.arg1 = 3;
        msg.arg2 = i;
        msg.obj = platform;
        UIHandler.sendMessage(msg, this);
    }

    @Override
    public boolean handleMessage(Message message) {
        switch (message.what){
            case MSG_TOAST:{
                Log.d("MeFragment", "MSG_TOAST----------------------1");

                String text = String.valueOf(message.obj);
//                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
            break;
            case MSG_ACTION_CCALLBACK:{

                Log.d("MeFragment", "MSG_ACTION_CCALLBACK----------------------1");

                switch (message.arg1){
                    case 1:{

                        Log.d("MeFragment", "----------------------1");

                        // 成功, successful notification
                        //授权成功后,获取用户信息，要自己解析，看看oncomplete里面的注释
                        //ShareSDK只保存以下这几个通用值
//                        pf = ShareSDK.getPlatform(getContext(), SinaWeibo.NAME);
//                        Log.e("sharesdk use_id", pf.getDb().getUserId()); //获取用户id
//                        Log.e("sharesdk use_name", pf.getDb().getUserName());//获取用户名称
//                        Log.e("sharesdk use_icon", pf.getDb().getUserIcon());//获取用户头像
                        // 设置图标以及昵称
//                        Picasso.with(context).load(pf.getDb().getUserIcon()).into(imageView_head);
//                        nameTv.setText(pf.getDb().getUserName());
//                        // 存入sp
                        SharedPreferences.Editor editor = getContext().getSharedPreferences("DHF", getContext().MODE_PRIVATE).edit();
                        editor.putString("head", pf.getDb().getUserIcon());
                        editor.putString("name", pf.getDb().getUserName());
                        editor.commit();



                          name.setText(pf.getDb().getUserName());
                        Log.d("MeFragment", pf.getName()+pf.getId()+pf.getDb().getUserId()+pf.getDb().getPlatformNname()+pf.getDb().getUserName()+"--------------------NAME");
                        Log.d("MeFragment", pf.getDb().getUserIcon()+"--------------------ID");

                        Glide.with(getContext()).load(pf.getDb().getUserIcon()).into(imageView);

//                        mPf.author()这个方法每一次都会调用授权，出现授权界面
//                        如果要删除授权信息，重新授权
                        //mPf.getDb().removeAccount();
                        //调用后，用户就得重新授权，否则下一次就不用授权
                    }
                    break;
                    case 2: {
                        Log.d("MeFragment", "----------------------2");

//                        mThirdLoginResult.setText("登录失败");
                        Toast.makeText(mContent, "登录失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case 3: {
                        Log.d("MeFragment", "----------------------3");

                        // 取消, cancel notification
//                        mThirdLoginResult.setText("取消授权");
                    }
                    break;

                }
            }break;
            case MSG_CANCEL_NOTIFY:{
                Log.d("MeFragment", "MSG_CANCEL_NOTIFY----------------------1");

                NotificationManager nm = (NotificationManager) message.obj;
                if (nm != null){
                    nm.cancel(message.arg1);
                }
            }
            break;

        }




        return false;
    }

    public  void back() {

//        Platform mPf = ShareSDK.getPlatform( SinaWeibo.NAME);
        //如果要删除授权信息，重新授权
        ShareSDK.removeCookieOnAuthorize(true);
        pf.removeAccount();

        name.setText("未知菠萝");
        imageView.setImageResource(R.mipmap.default_avatar);
    }



}
