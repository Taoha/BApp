package com.lanou.taochangjun.gift.projectbapp.home.focus;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by imac on 2017/2/23.
 */

public class FocusAdapter extends RecyclerView.Adapter<FocusAdapter.MyViewHolder> {
    private Context mContext;
    private List<FocusBean> mFocusBean;


    public FocusAdapter(Context context) {
        mContext = context;

    }

    public void setFocusBean(List<FocusBean> focusBean) {
        mFocusBean = focusBean;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_focus, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        FocusBean focusBean = mFocusBean.get(position);
//        String auatar = focusBean.getAvatar();
//        if (null != auatar && !auatar.isEmpty()) {
//            Picasso.with(mContext).load(auatar).into(holder.iv_head);
//
//        }
        Picasso.with(mContext).load(mFocusBean.get(position).getAvatar()).into(holder.iv_head);
        holder.tv_author.setText(mFocusBean.get(position).getNick());
        holder.tv_substance.setText(mFocusBean.get(position).getIntro());


        FocusItemAdapter focusItemAdapter = new FocusItemAdapter(mContext);
        List<FocusBean.VideoListBean> list  = mFocusBean.get(position).getVideoList();
        focusItemAdapter.setData(list);
        holder.mRecyclerView.setAdapter(focusItemAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        holder.mRecyclerView.setLayoutManager(manager);



    }

    @Override
    public int getItemCount() {
        return mFocusBean != null && mFocusBean.size() > 0 ? mFocusBean.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_head, iv_substance;
        TextView tv_author, tv_substance, tv_present;
        RecyclerView mRecyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_head = (CircleImageView) itemView.findViewById(R.id.iv_head);
            iv_substance = (ImageView) itemView.findViewById(R.id.iv_substance);
            tv_author = (TextView) itemView.findViewById(R.id.tv_author);
            tv_substance = (TextView) itemView.findViewById(R.id.tv_substance);
            tv_present = (TextView) itemView.findViewById(R.id.tv_present);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.rv_focus_second);

        }
    }
}
