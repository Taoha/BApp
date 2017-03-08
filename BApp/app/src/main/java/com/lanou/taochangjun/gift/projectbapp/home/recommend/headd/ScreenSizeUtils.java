package com.lanou.taochangjun.gift.projectbapp.home.recommend.headd;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by wubihang on 17/2/27.
 * 获取屏幕尺寸的工具类
 *
 * 工具类是不单例的
 * 而是定义static方法
 */

public class ScreenSizeUtils {

    public static int getScreenWidth(Context context){
        // 1.获取窗口管理者
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        // 2.创建显示尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        // 3.将窗口的尺寸传入显示尺寸类
        wm.getDefaultDisplay().getMetrics(metrics);
        // 返回宽度
        return metrics.widthPixels;
    }
    public static int getScreenHeight(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }


    // 根据代码规范：涉及到状态判断，最好是定义静态常量
    private static final int WIDTH_CODE = 0;
    private static final int HEIGHT_CODE = 1;

    /**
     * 3星封装
     * @param requestCode 0,1
     * @return 0 返回宽度
     *         1 返回高度
     *        默认 返回宽度（传入的不是0和1）
     */
    public static int getScreenSize(Context context, int requestCode){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        switch (requestCode) {
            case WIDTH_CODE:
                return metrics.widthPixels;
            case HEIGHT_CODE:
                return metrics.heightPixels;
            default:
                return metrics.widthPixels;
        }
    }

    /**
     * 五星封装 - 使用 枚举 代替状态
     *
     * 意义：让别人使用时更加方便
     * 主要让人知道怎么用
     */
    public static int getScreen(Context context,
                                ScreenState state){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);

        if (state.equals(ScreenState.WIDTH)){
            return metrics.widthPixels;
        } else {
            return metrics.heightPixels;
        }
    }


}

