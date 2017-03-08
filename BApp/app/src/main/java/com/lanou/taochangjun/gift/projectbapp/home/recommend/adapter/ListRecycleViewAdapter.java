package com.lanou.taochangjun.gift.projectbapp.home.recommend.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.bean.ListBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 17/2/27.
 * 张德鹏
 * 人气周榜item
 */

public class ListRecycleViewAdapter extends RecyclerView.Adapter<ListRecycleViewAdapter.MyViewHolder>{

    private Context context;
    private List<ListBean> been;

    public ListRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public void setBeen(List<ListBean> been) {
        this.been = been;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_list_it,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Glide.with(context).load(been.get(position).getCover()).override(600,200).into(holder.photo);
        holder.title.setText(been.get(position).getName());
        holder.hot.setText("人气值:"+been.get(position).getDegree());
    }

    @Override
    public int getItemCount() {
        return been!= null ? been.size():0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView photo ;
        TextView title, hot;

        public MyViewHolder(View itemView) {
            super(itemView);
            photo  = (ImageView) itemView.findViewById(R.id.item_recommend_list_it_photo);
            title = (TextView) itemView.findViewById(R.id.item_recommend_list_it_title);
            hot = (TextView) itemView.findViewById(R.id.item_recommend_list_it_hot);
        }
    }

}
