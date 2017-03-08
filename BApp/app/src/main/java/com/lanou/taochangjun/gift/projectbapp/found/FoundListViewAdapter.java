package com.lanou.taochangjun.gift.projectbapp.found;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 17/3/1.
 * 张德鹏
 * 发现页面下方 的listView适配器
 */

public class FoundListViewAdapter extends BaseAdapter{

    private Context context;
    private List<FoundAppendixBean> bean;

    public FoundListViewAdapter(Context context) {
        this.context = context;
    }

    public void setBean(List<FoundAppendixBean> bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean!= null ? bean.size():0;
    }

    @Override
    public Object getItem(int position) {
        return bean!= null ? bean.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FoundRecyleViewAdapter adapter = new FoundRecyleViewAdapter(context);

        FoundListViewHolder holder = null;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_found_listview,parent,false);
            holder = new FoundListViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (FoundListViewHolder) convertView.getTag();
        }

        Picasso .with(context).load(bean.get(position).getIcon()).into(holder.imageView);
        holder.title.setText(bean.get(position).getName());


        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        holder.recyclerView.setLayoutManager(manager);
        adapter.setBean(bean.get(position).getVideoSetList());
        holder.recyclerView.setAdapter(adapter);

        return convertView;
    }

    class FoundListViewHolder {
        ImageView imageView ;
        TextView title;
        RecyclerView recyclerView;
        public FoundListViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.item_found_listview_title_photo);
            title = (TextView) view.findViewById(R.id.item_found_listview_title);
            recyclerView = (RecyclerView) view.findViewById(R.id.item_found_listview_rv);
        }
    }


}
