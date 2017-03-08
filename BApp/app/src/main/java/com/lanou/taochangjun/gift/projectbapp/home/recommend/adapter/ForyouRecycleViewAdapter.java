package com.lanou.taochangjun.gift.projectbapp.home.recommend.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.bean.ForyouBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 17/2/27.
 * 张德鹏
 * 为您推荐适配器
 */

public class ForyouRecycleViewAdapter extends RecyclerView.Adapter<ForyouRecycleViewAdapter.ForyouHolder>{


    private Context context;
    private List<ForyouBean> bean;

    public ForyouRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public void setBean(List<ForyouBean> bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public ForyouHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("111", "context:" + context);
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_foryou_it,parent,false);
        ForyouHolder holder = new ForyouHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ForyouHolder holder, int position) {

        holder.title.setText(bean.get(position).getTitle());
        holder.name.setText(bean.get(position).getChannelName());
        Glide.with(context).load(bean.get(position).getCover()).override(600,200).into(holder.photo);
        Glide.with(context).load(bean.get(position).getAvatar()).override(600,200).into(holder.namephoto);


    }

    @Override
    public int getItemCount() {
        return bean!= null? bean.size(): 0;
    }

    class ForyouHolder extends RecyclerView.ViewHolder{
        ImageView photo, namephoto;
        TextView title, name;

        public ForyouHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.item_recommend_foryou_it_photo);
//            namephoto = (ImageView) itemView.findViewById(R.id.item_recommend_foryou_it_name_photo);
            namephoto =(de.hdodenhof.circleimageview.CircleImageView) itemView.findViewById(R.id.item_recommend_foryou_it_name_photo);
            title = (TextView) itemView.findViewById(R.id.item_recommend_foryou_it_title);
            name = (TextView) itemView.findViewById(R.id.item_recommend_foryou_it_name);

        }
    }

}
