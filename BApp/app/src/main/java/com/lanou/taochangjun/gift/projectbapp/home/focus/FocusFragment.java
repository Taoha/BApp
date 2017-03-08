package com.lanou.taochangjun.gift.projectbapp.home.focus;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;
import com.lanou.taochangjun.gift.projectbapp.internet.Url;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by imac on 2017/2/21.
 */

/**
 * 作者:陶长骏
 * 作用:页面的关注Fragment
 */
public class FocusFragment extends BaseFragment {
    private RecyclerView mRecyclerView;

    @Override
    public int setlayout() {
        return R.layout.fragment_home_focus;
    }

    @Override
    public void initView(View view) {
        mRecyclerView = bindView(R.id.rv_focus);

    }

    @Override
    public void initData() {
        //关注解析
        focusInternet();

    }

    private void focusInternet() {
        RequestQueue q;
        String FocusUrl = Url.ATTENTION;
        q = Volley.newRequestQueue(getContext());
        StringRequest request = new StringRequest(Request.Method.GET, FocusUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Type type = new TypeToken<List<FocusBean>>() {}.getType();
                List<FocusBean> focusBeen = gson.fromJson(response, type);
                FocusAdapter focusAdapter = new FocusAdapter(getContext());
                focusAdapter.setFocusBean(focusBeen);
                mRecyclerView.setAdapter(focusAdapter);
               // GridLayoutManager manager = new GridLayoutManager(getContext(),4,GridLayoutManager.HORIZONTAL,false);
                LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                mRecyclerView.setLayoutManager(manager);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        q.add(request);

    }
}
