package com.lanou.taochangjun.gift.projectbapp.found;

import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;
import com.lanou.taochangjun.gift.projectbapp.internet.MyOkHttpManager;
import com.lanou.taochangjun.gift.projectbapp.internet.Url;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Created by imac on 2017/2/20.
 */

/**
 * 张德鹏
 * 发现页面的Fragment
 */
public class FoundFragment extends BaseFragment {


    private GridView gridView;
    private ListView listView;
    private List<AllSearchBean>gvbean;
    private List<FoundAppendixBean> lvbean;

    private FoundAppendixBean lvdate;
    private FoundGridViewAdapter gvAdatper;
    private FoundListViewAdapter lvAdapter;


    @Override
    public int setlayout() {
        return R.layout.fragment_found;
    }



    @Override
    public void initView(View view) {
        gridView = (GridView) view.findViewById(R.id.fragment_found_search_gv);
        listView = (ListView) view.findViewById(R.id.fragment_found_search_lv);
        gvbean = new ArrayList<>();
        lvbean = new ArrayList<>();
        gvAdatper = new FoundGridViewAdapter(getContext());
        lvAdapter = new FoundListViewAdapter(getContext());

    }

    @Override
    public void initData() {



        MyOkHttpManager.getsInstance().getAsyncAsString(Url.SEARCH, Url.SEARCHCODE, new MyOkHttpManager.StringCallback() {
            @Override
            public void onFailure(IOException e) {

                Toast.makeText(mContent, "网络请求萌萌哒", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccessful(int requestCode, String result) {
                Gson gson = new Gson();

                Type type = new TypeToken<List<AllSearchBean>>(){}.getType();


                gvbean = gson.fromJson(result,type);
                gvAdatper.setBean(gvbean);
                gridView.setAdapter(gvAdatper);

            }
        });

        MyOkHttpManager.getsInstance().getAsyncAsString(Url.ALL, Url.ALLCODE, new MyOkHttpManager.StringCallback() {
            @Override
            public void onFailure(IOException e) {

                Toast.makeText(mContent, "网络请求萌萌哒", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccessful(int requestCode, String result) {
                Gson gson = new Gson();

                Type type = new TypeToken<List<FoundAppendixBean>>(){}.getType();
                lvbean = gson.fromJson(result,type);
                lvAdapter.setBean(lvbean);
                listView.setAdapter(lvAdapter);

            }
        });


    }
}
