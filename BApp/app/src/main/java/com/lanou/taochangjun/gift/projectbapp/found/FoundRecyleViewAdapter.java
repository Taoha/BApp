package com.lanou.taochangjun.gift.projectbapp.found;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 17/3/1.
 * 张德鹏
 * 发现页面下凡listView 用来嵌套的RecycleView
 */

public class FoundRecyleViewAdapter extends RecyclerView.Adapter<FoundRecyleViewAdapter.FoundRecycleViewHolder>{

    private Context context;
    private List<FoundAppendixBean.VideoSetListBean> bean;


    public FoundRecyleViewAdapter(Context context) {
        this.context = context;
    }

    public void setBean(List<FoundAppendixBean.VideoSetListBean> bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public FoundRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_found_listview_it,parent,false);
        FoundRecycleViewHolder holder = new FoundRecycleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FoundRecycleViewHolder holder, int position) {
        Picasso .with(context).load(bean.get(position).getCover()).into(holder.imageView);
        holder.textView.setText(bean.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return bean!= null ? bean.size() :0 ;
    }



    class FoundRecycleViewHolder extends RecyclerView.ViewHolder{
       ImageView imageView;
       TextView textView;
        public FoundRecycleViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_found_listview_it_photo);
            textView = (TextView) itemView.findViewById(R.id.item_found_listview_it_title);
        }
    }


}
