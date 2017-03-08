package com.lanou.taochangjun.gift.projectbapp.home.recommend.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.bean.BacterialBean;
import com.lanou.taochangjun.gift.projectbapp.video.VideoActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 17/2/27.
 * 张德鹏
 * 菠萝菌力荐适配器
 */

public class BacterialRecycleViewAdapter extends RecyclerView.Adapter<BacterialRecycleViewAdapter.ViewHolder>{

    private Context context;
    private List<BacterialBean> bean;
    private BacterialInterface anInterface;

    public void setAnInterface(BacterialInterface anInterface) {
        this.anInterface = anInterface;
    }

    public BacterialRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public void setBean(List<BacterialBean> bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_bacterial_it,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.title.setText(bean.get(position).getTitle());
        holder.name.setText(bean.get(position).getChannelName());
        Glide.with(context).load(bean.get(position).getCover()).override(600,200).into(holder.photo);
        Glide.with(context).load(bean.get(position).getAvatar()).override(600,200).into(holder.namephoto);

        if (anInterface!= null){
            holder.photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    anInterface.OnClick(position);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return bean!= null ? bean.size(): 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView photo , namephoto;
        TextView title, name;

        public ViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.item_recommend_bacterical_it_ploto);
            namephoto = (ImageView) itemView.findViewById(R.id.item_recommend_bacterical_it_name_ploto);
            title= (TextView) itemView.findViewById(R.id.item_recommend_bacterical_it_title);
            name = (TextView) itemView.findViewById(R.id.item_recommend_bacterical_it_name);
        }
    }

}
