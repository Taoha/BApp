package com.lanou.taochangjun.gift.projectbapp.home.focus;

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
 * Created by imac on 2017/2/27.
 */

public class FocusItemAdapter extends RecyclerView.Adapter<FocusItemAdapter.MyViewHolder> {
    private Context context;
    private List<FocusBean.VideoListBean> data;

    public FocusItemAdapter(Context context) {
       this.context = context;
    }

    public void setData(List<FocusBean.VideoListBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_focus_second,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder ;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context).load(data.get(position).getCover()).placeholder(R.mipmap.home_inner_list_more).into(holder.mImageView);
        holder.mTextView.setText(data.get(position).getTitle());



    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size(): 0 ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_substance);
            mTextView = (TextView) itemView.findViewById(R.id.tv_present);
        }
    }
}
