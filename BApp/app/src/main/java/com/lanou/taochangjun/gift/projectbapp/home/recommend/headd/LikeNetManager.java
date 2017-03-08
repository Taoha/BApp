package com.lanou.taochangjun.gift.projectbapp.home.recommend.headd;

/**
 * Created by wubihang on 17/2/27.
 */

public class LikeNetManager {


    public void start(OnNetListener listener){
        listener.onSuccess("");
    }


    public interface OnNetListener{
        void onSuccess(String resultStr);
    }

}
