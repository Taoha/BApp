package com.lanou.taochangjun.gift.projectbapp.home.appendix;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;
import com.lanou.taochangjun.gift.projectbapp.found.AllSearchBean;
import com.lanou.taochangjun.gift.projectbapp.internet.MyOkHttpManager;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dllo on 17/3/2.
 */

public class AppendixFragment extends BaseFragment {


    private ListView listview;
    private GridView gridView;
    private String url;
    private String urll;
    private int code;
    private int codee;



    private AppendixGridViewAdapter gvAdapter;
    private AppendixListViewAdapter lvAdatper;
    private List<AppendixListBean> appendixListBeanList ;
    private List<AppendixBean> appendixBeen;

    @Override
    public int setlayout() {

        return R.layout.fragment_home_appendix;
    }

    // 公用的fragment,返回每一个fragmetn对象
    public static AppendixFragment newInstance(String url,String urll,int a ,int b) {

        Bundle args = new Bundle();

        args.putString("url",url);
        args.putString("urll" , urll);
        args.putInt("code",a);
        args.putInt("codee",b);

        AppendixFragment fragment = new AppendixFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView(View view) {
        listview = (ListView) view.findViewById(R.id.fragment_home_appendix_lv);



        gvAdapter = new AppendixGridViewAdapter(getContext());
        lvAdatper = new AppendixListViewAdapter(getContext());
    }

    @Override
    public void initData() {



       Bundle bundle = getArguments();
       if (bundle!= null){
           url = bundle.getString("url");
           urll = bundle.getString("urll");
           code = bundle.getInt("code");
           codee = bundle.getInt("codee");
       }

        final View view1 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home_appendix_grid,null);
        gridView  = (GridView) view1.findViewById(R.id.fragment_home_appendix_gv);

        MyOkHttpManager.getsInstance().getAsyncAsString(url, code, new MyOkHttpManager.StringCallback() {

            @Override
            public void onFailure(IOException e) {
                Toast.makeText(mContent, "网络萌萌哒", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccessful(int requestCode, String result) {
                Gson gson = new Gson();

                Type type = new TypeToken<List<AppendixBean>>(){}.getType();
                appendixBeen = gson.fromJson(result,type);

                lvAdatper.setAppendixBeen(appendixBeen);




                listview.setAdapter(lvAdatper);
                listview.addFooterView(view1);


            }
        });

        MyOkHttpManager.getsInstance().getAsyncAsString(urll, codee, new MyOkHttpManager.StringCallback() {
            @Override
            public void onFailure(IOException e) {
                Toast.makeText(mContent, "网络萌萌哒", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccessful(int requestCode, String result) {
                Gson gson = new Gson();

                Type type = new TypeToken<List<AppendixListBean>>(){}.getType();
                appendixListBeanList = gson.fromJson(result,type);
                gvAdapter.setAppendixListBeanList(appendixListBeanList);
                gridView.setAdapter(gvAdapter);

            }
        });


    }





    private void setListViewHeightBasedOnChildren(ListView listView) {
        lvAdatper = (AppendixListViewAdapter) listview.getAdapter();
        if (lvAdatper == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i <  lvAdatper.getCount(); i++) {
            View listItem = lvAdatper.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (lvAdatper.getCount() - 1));
        listView.setLayoutParams(params);
    }










}
