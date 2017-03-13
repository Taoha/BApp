package com.lanou.taochangjun.gift.projectbapp.view;

import android.app.NotificationManager;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.AbsBaseActivity;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;
import com.mob.tools.utils.UIHandler;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;

/**
 * Created by imac on 2017/2/23.
 */
public class EnterActivity extends AbsBaseActivity implements PlatformActionListener, Handler.Callback {

    private ImageView login;
    private static final int MSG_TOAST = 1;
    private static final int MSG_ACTION_CCALLBACK = 2;
    private static final int MSG_CANCEL_NOTIFY = 3;
    private Platform pf;

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
        login = (ImageView) findViewById(R.id.activity_enter_login);
        ShareSDK.initSDK(this);
    }

    @Override
    protected void initData() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdSinaLogin();
            }
        });
    }


    private void thirdSinaLogin(){
        pf = ShareSDK.getPlatform(this, SinaWeibo.NAME);
        pf.SSOSetting(true);
        //设置监听
        pf.setPlatformActionListener(this);
        //获取登陆用户的信息，如果没有授权，会先授权，然后获取用户信息
        pf.authorize();
    }


    /**
     * 新浪微博授权成功回调页面
     */
    @Override
    public void onComplete(Platform platform, int action, HashMap<String, Object> hashMap) {
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
        msg.arg2 = action;
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
                String text = String.valueOf(message.obj);
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
            break;
            case MSG_ACTION_CCALLBACK:{
                switch (message.arg1){
                    case 1:{
                        // 成功, successful notification
                        //授权成功后,获取用户信息，要自己解析，看看oncomplete里面的注释
                        //ShareSDK只保存以下这几个通用值
                        pf = ShareSDK.getPlatform(this, SinaWeibo.NAME);
//                        Log.e("sharesdk use_id", pf.getDb().getUserId()); //获取用户id
//                        Log.e("sharesdk use_name", pf.getDb().getUserName());//获取用户名称
//                        Log.e("sharesdk use_icon", pf.getDb().getUserIcon());//获取用户头像
                        // 设置图标以及昵称
//                        Picasso.with(context).load(pf.getDb().getUserIcon()).into(imageView_head);
//                        nameTv.setText(pf.getDb().getUserName());
//                        // 存入sp
//                        SharedPreferences.Editor editor = context.getSharedPreferences("DHF", getContext().MODE_PRIVATE).edit();
//                        editor.putString("head", pf.getDb().getUserIcon());
//                        editor.putString("name", pf.getDb().getUserName());
//                        editor.commit();


                        //mPf.author()这个方法每一次都会调用授权，出现授权界面
                        //如果要删除授权信息，重新授权
                        //mPf.getDb().removeAccount();
                        //调用后，用户就得重新授权，否则下一次就不用授权
                    }
                    break;
                    case 2: {
//                        mThirdLoginResult.setText("登录失败");
                    }
                    break;
                    case 3: {
                        // 取消, cancel notification
//                        mThirdLoginResult.setText("取消授权");
                    }
                    break;

                }
            }break;
            case MSG_CANCEL_NOTIFY:{
                NotificationManager nm = (NotificationManager) message.obj;
                if (nm != null){
                    nm.cancel(message.arg1);
                }
            }
            break;

        }




        return false;
    }
}
