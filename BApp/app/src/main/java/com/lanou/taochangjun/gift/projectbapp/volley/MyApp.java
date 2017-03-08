package com.lanou.taochangjun.gift.projectbapp.volley;

import android.app.Application;
import android.content.Context;

/**
 * Created by wubihang on 17/2/21.
 */

public class MyApp extends Application{

    // 注意：在清单文件注册这个Application
    // Application能做什么？
    // 1.提供全局Context
    // 2.一些全局使用的对象初始化
    //      极光推送、支付SDK初始化、ShareSDK
    // 3.记录版本
    // 4.设置调试模式  debug-release

    /**
     * 全局Context适用情况：
     * 1.数据库
     * 2.网络
     * 3.线程池
     */
    private static Context context;

    public static Context getContext() {
        return context;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        /**
         * Application：应用程序
         * 就代表整个app应用
         * 当app应用打开时，就会自动生成一个Application对象
         *
         * 当app应用退出时，该对象自动销毁
         *
         * Application也有一个context
         * 这个context通常称为全局的context
         * Context：
         * Context是一个抽象类
         * Application和Activity都间接的继承自该类
         * 在通常情况下，称之为上下文
         * 我的理解：环境
         * 1.获取资源文件，获取手机某路径
         * 2.数据库，网络，流相关操作
         * 3.Toast，加载布局，创建某View
         *
         * 以上三种操作都抽象的会与界面或手机相关
         * 只要我们去操作界面或手机都会基于这个手机去执行
         * context在某种程度上==这个手机
         */
    }
}
