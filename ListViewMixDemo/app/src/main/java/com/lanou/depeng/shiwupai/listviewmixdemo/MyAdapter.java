package com.lanou.depeng.shiwupai.listviewmixdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/2/21.
 */

/**
 * 复用混淆
 * 列表里面存在
 *
 */

/**
 * 解决步骤
 * 1, 定义一个集合存储所有航布局的状态
 *    初始值全部为false
 *    0 - false
 *    1 - false
 *    2 - false
 *    3 - false
 *    ....
 * 2, 点击更改时: 将集合中对应的位置改为true
 *
 * 3, checkBox 的true和false状态设置由集合决定
 */


public class MyAdapter extends BaseAdapter {

    private Context context;

    private List<String> data ;
    // checkBox 选择状态储存Map
    private Map<Integer, Boolean> checkStates;

    // 存储关注未关注的状态
    private Map<Integer,Boolean> eye;


    public MyAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> data) {
        this.data = data;
        checkStates = new HashMap<>();
        eye = new HashMap<>();
        // 将窗台集合 全部存储为false
        for (int i = 0; i < data.size(); i++) {
            checkStates.put(i,false);
            eye.put(i,false);
        }

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder = null;
       if (convertView == null){
           convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
           viewHolder = new ViewHolder(convertView);
           convertView.setTag(viewHolder);
       }else {
           viewHolder = (ViewHolder) convertView.getTag();
       }
        viewHolder.textView.setText(data.get(position));

















        // 点击check将状态改为true
        // 如果是true - false
        // 如果是false - true
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkStates.get(position)== true){
                    checkStates.put(position,false);
                    notifyDataSetChanged();
                }else {
                    checkStates.put(position,true);
                    notifyDataSetChanged();
                }
            }
        });

        // 根据保存的状态重新设置checkBox

        if (checkStates.get(position)== true){
            viewHolder.checkBox.setChecked(true);
        }else {
            viewHolder.checkBox.setChecked(false);
        }
        return convertView;
    }


    private class ViewHolder {
        TextView textView;
        CheckBox checkBox;
        Button button;
        public ViewHolder (View view){
            textView = (TextView) view.findViewById(R.id.item_tv);
            checkBox = (CheckBox) view.findViewById(R.id.item_cb);
            button = (Button) view.findViewById(R.id.item_btn);
        }


    }


}
