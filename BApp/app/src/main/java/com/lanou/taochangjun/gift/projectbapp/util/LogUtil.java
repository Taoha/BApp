package com.lanou.taochangjun.gift.projectbapp.util;

import android.util.Log;

/**
 * Created by imac on 2017/2/15.
 *
 * log 调试类
 * 作者:陶哈哈
 */

public class LogUtil {
    // final修饰的类不能被继承
    // 私有构造方法：不能被外部new对象
    // 对这个工具类采取这种方法目的：
    // 我这个类就是一个工具，不允许继承修改和创建垃圾对象
    private LogUtil(){
    }
    private static final boolean DEBUG_IS = true;

    public static void i(String info){
        if (DEBUG_IS){
            Log.i("debug",info);
        }
    }
}
