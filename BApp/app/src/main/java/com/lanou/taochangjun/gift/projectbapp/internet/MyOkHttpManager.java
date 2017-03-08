package com.lanou.taochangjun.gift.projectbapp.internet;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dllo on 17/3/2.
 *
 * 张德鹏抄写玲姐Ok封装
 *
 */

public class MyOkHttpManager {

    private OkHttpClient mClient;

    /**
     * 储存当前实例对象, 用于单例返回本类对象
     */
    private static MyOkHttpManager sInstance;

    public static MyOkHttpManager getsInstance() {
        // 如果sInstance对象是空的, 就创建一个否则直接返回
        if (sInstance == null){
            sInstance = new MyOkHttpManager();
        }
        return sInstance;
    }


    private MyOkHttpManager(){
        mClient = new OkHttpClient();// 初始化网络请求客户端对象
    }

    public void getAsyncAsString(String url, final int requestCode, final StringCallback callback){
        // 发起异步的网络请求
        final Request request = new Request.Builder()
                .url(url)
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = mHandler.obtainMessage();
                message.what = 200;
                message.obj = callback;

                Bundle bundle = new Bundle();
                bundle.putSerializable("e",e);
                message.setData(bundle);

                mHandler.sendMessage(message);//发送失败消息
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();

                Message message = mHandler.obtainMessage();
                message.what = 100;
                message.obj = callback;
                message.arg1= requestCode;

                Bundle bundle = new Bundle();
                bundle.putString("result",result);
                message.setData(bundle);

                mHandler.sendMessage(message);//发送成功消息
            }
        });


    }


    //  上方调用方法的String Callback
    public interface StringCallback {
        void onFailure(IOException e);

        void onSuccessful(int requestCode, String result);
    }

    // 上方成功方法中调用的Handler
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            StringCallback mStringCallback = (StringCallback) msg.obj;

            if (msg.what == 100){  // 成功的参数200
                String result = msg.getData().getString("result");
                int requestCode = msg.arg1;
                // 收到成功的数据请求之后发起回调
                mStringCallback.onSuccessful(requestCode,result);
            }   else {
                IOException exception = (IOException) msg.getData().getSerializable("exception");
                // 收到失败消息发起回调
                mStringCallback.onFailure(exception);
            }


            return false;
        }
    });




    /**
     * 对外开发的方法
     ***/
    public String getAsString(String url) {
        return _getAsString(url);//调用真正的get请求
    }

    /**
     * 对内实现的真正进行网络请求的方法
     * 同步的get请求 意味着外部调用时需要另起一个线程进行单独处理
     *
     * @param url 要请求的地址
     * @return 返回请求之后的字符串
     **/
    private String _getAsString(String url) {
        //1.构建request请求对象 里面设置请求地址
        Request request = new Request.Builder()
                .url(url)
                .build();
        //2.通过OkHttpClient客户端发起请求并执行 返回一个Response对象
        try {
            Response response = mClient.newCall(request).execute();

            if (response.isSuccessful()) {
                //3.如果请求成功之后 则将请求得到的字符串对象进行返回
                return response.body().string();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }



    /**
     * 发起一个异步的网络请求 即外部调用时不用单独开辟线程来处理
     */
    public void getAsyncAsString(String url, Callback callback) {
        _getAsyncAsString(url, callback);

    }

    /**
     * 真正实现异步get请求
     *
     * @param url      请求的地址
     * @param callback 请求结束之后的回调接口
     */
    private void _getAsyncAsString(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        mClient.newCall(request).enqueue(callback);

    }



}
