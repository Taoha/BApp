package com.lanou.taochangjun.gift.projectbapp.volley;

/**
 * Created by wubihang on 17/2/20.
 */

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * 封装Volley请求的单例
 * 形式模仿OkHttp的单例
 */
public class VolleyManager {
    /**
     * 1.封装Volley单例
     *      主要练习：单例模式，及各种请求的封装及回调
     * 2.长期的工作：
     *      网络图片加载时二级缓存，三级缓存是怎么回事？
     *      Picasso、Glide、Fresco、Unversi-Image-Loader的对比
     */

    private static VolleyManager instance;

    // 请求队列
    private RequestQueue queue;

    /**
     * 按照之前的做法：
     * 在构造方法中定义Context
     *
     * 这种操作是正确的，适用于 不是单例，不是static的
     *
     *  在单例中：
     *  1.创建单例对象时需要使用context，传入了Activity对象
     *  2.单例对象是static的，传入的Activity对象被static持有
     *  3.该Activity无论是否显示，都无法被垃圾回收机制回收
     *  4.导致该Activity的内存一直无法释放
     *
     *  我们要避免这种情况的产生：
     *  因此，可以使用全局的context
     *  什么时候不用Activity.this的context：如果用了会被static持有就不用
     *
     */

    private VolleyManager(){
//        queue = Volley.newRequestQueue(MyApp.getContext())
        queue = getQueue();
    }

    public static VolleyManager getInstance(){
        if (instance == null){
            synchronized (VolleyManager.class){
                if (instance == null){
                    instance = new VolleyManager();
                }
            }
        }
        return instance;
    }

    private RequestQueue getQueue() {
        if (queue == null){
            queue = Volley.newRequestQueue(MyApp.getContext());
        }
        return queue;
    }

    private void addQueue(Request request){
        queue.add(request);
    }

    //************具体的请求方法***************/

    // get请求
    private void _startRequest(String url, final OnNetResultListener listener){
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailure(error.getMessage());
            }
        });
        addQueue(sr);
    }

    public void startRequest(String url, OnNetResultListener listener){
        _startRequest(url,listener);
    }

    // post请求
    private void _startRequest(String url, final Map<String, String> body, final OnNetResultListener listener){
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailure(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return body;
            }
        };

        addQueue(sr);
    }

    public void startRequest(String url, Map<String, String> body,OnNetResultListener listener){
        _startRequest(url,body,listener);
    }

    /*
    重载：方法名相同，参数列表不同
    参数列表不同：个数，类型，顺序
     */

    // header
    // 1.重载，改变参数顺序
    // 2.改名
    private void _startRequestWithHeader(String url, final Map<String, String> headers, final OnNetResultListener listener){
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailure(error.getMessage());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };

        addQueue(sr);
    }


    public void startRequestWithHeader(String url, Map<String,String> headers, OnNetResultListener listener){
        _startRequestWithHeader(url,headers,listener);
    }
}


