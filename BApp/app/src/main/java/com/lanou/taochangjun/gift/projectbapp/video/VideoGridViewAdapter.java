package com.lanou.taochangjun.gift.projectbapp.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.home.appendix.AppendixListBean;

import java.util.List;

/**
 * Created by dllo on 17/2/23.
 *
 * 制作者张德鹏
 * 播放界面下面的girdView
 *
 */

public class VideoGridViewAdapter extends BaseAdapter {

    private Context context;
    private List<AppendixListBean> appendixListBeanList ;

    public VideoGridViewAdapter(Context context) {

        this.context = context;
    }

    public void setAppendixListBeanList(List<AppendixListBean> appendixListBeanList) {
        this.appendixListBeanList = appendixListBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return appendixListBeanList .size() >0 ? 6 : 0;
    }

    @Override
    public Object getItem(int position) {
        return appendixListBeanList != null ? appendixListBeanList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_appendix_gridview,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(appendixListBeanList.get(position).getTitle());
        viewHolder.name.setText(appendixListBeanList.get(position).getChannelName());
        Glide.with(context).load(appendixListBeanList.get(position).getCover()).override(600,200).into(viewHolder.photo);
        Glide.with(context).load(appendixListBeanList.get(position).getAvatar()).override(600,200).into(viewHolder.namephoto);
        return convertView;
    }

    class ViewHolder{
        ImageView photo,namephoto;
        TextView title,name;

        public ViewHolder(View view) {
            photo = (ImageView) view.findViewById(R.id.item_appendix_girdview_photo);
            namephoto = (ImageView) view.findViewById(R.id.item_appendix_girdview_name_ploto);
            title = (TextView) view.findViewById(R.id.item_appendix_girdview_title);
            name = (TextView) view.findViewById(R.id.item_appendix_girdview_name);
        }
    }
}
