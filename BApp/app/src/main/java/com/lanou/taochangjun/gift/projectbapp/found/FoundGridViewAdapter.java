package com.lanou.taochangjun.gift.projectbapp.found;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;

import java.util.List;

/**
 * Created by dllo on 17/3/1.
 * z张德鹏
 */

public class FoundGridViewAdapter extends BaseAdapter {

    private Context context;
    private List<AllSearchBean>bean;

    public FoundGridViewAdapter(Context context) {
        this.context = context;
    }

    public void setBean(List<AllSearchBean> bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean!= null ? bean.size() :0;
    }

    @Override
    public Object getItem(int position) {
        return bean!= null ? bean.get(position): null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_found_gridview,parent,false);
            holder = new GridViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (GridViewHolder) convertView.getTag();
        }

        holder.textView.setText(bean.get(position).getKeyword());

        return convertView;
    }

    class GridViewHolder {
        TextView textView;
        public GridViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.item_found_gridview_tv);
        }
    }


}
