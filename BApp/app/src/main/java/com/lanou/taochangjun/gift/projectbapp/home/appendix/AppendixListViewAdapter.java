package com.lanou.taochangjun.gift.projectbapp.home.appendix;

import android.content.Context;
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
 * Created by dllo on 17/2/23.
 *
 * 张德鹏
 * 首页所有附页上半部分所有ListView的适配器
 */

public class AppendixListViewAdapter extends BaseAdapter {

    private Context context;
    private List<AppendixBean> appendixBeen;

    @Override
    public int getCount() {
        return appendixBeen.size()!= 0 ?appendixBeen.size() :0;
    }

    @Override
    public Object getItem(int position) {
        return appendixBeen!= null ? appendixBeen.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_appendix_listview,parent,false);
            viewHolder = new ViewHolder(null);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 标题
        viewHolder.title.setText(appendixBeen.get(position).getVideoCategory().getName());
        // 第一组
        if (appendixBeen.get(position).getVideoList().get(0)!=null){
            Picasso.with(context).load(appendixBeen.get(position).getVideoList().get(0).getCover()).into(viewHolder.article_one_ploto);
            Picasso.with(context).load(appendixBeen.get(position).getVideoList().get(0).getAvatar()).into(viewHolder.article_one_name_photo);
            viewHolder.article_one_title.setText(appendixBeen.get(position).getVideoList().get(0).getTitle());
            viewHolder.article_one_name.setText(appendixBeen.get(position).getVideoList().get(0).getChannelName());
        }
        // 第二组
        if (appendixBeen.get(position).getVideoList().get(1) != null){
            Picasso.with(context).load(appendixBeen.get(position).getVideoList().get(1).getCover()).into(viewHolder.article_two_ploto);
            Picasso.with(context).load(appendixBeen.get(position).getVideoList().get(1).getAvatar()).into(viewHolder.article_two_name_photo);
            viewHolder.article_two_title.setText(appendixBeen.get(position).getVideoList().get(1).getTitle());
            viewHolder.article_two_name.setText(appendixBeen.get(position).getVideoList().get(1).getChannelName());
        }
        // 第三组
        if (appendixBeen.get(position).getVideoList().get(2) != null){
            Picasso.with(context).load(appendixBeen.get(position).getVideoList().get(2).getCover()).into(viewHolder.article_three_ploto);
            Picasso.with(context).load(appendixBeen.get(position).getVideoList().get(2).getAvatar()).into(viewHolder.article_three_name_photo);
            viewHolder.article_three_title.setText(appendixBeen.get(position).getVideoList().get(2).getTitle());
            viewHolder.article_three_name.setText(appendixBeen.get(position).getVideoList().get(2).getChannelName());
        }
        // 第四组
        if (appendixBeen.get(position).getVideoList().get(3) != null){
            Picasso.with(context).load(appendixBeen.get(position).getVideoList().get(3).getCover()).into(viewHolder.article_four_ploto);
            Picasso.with(context).load(appendixBeen.get(position).getVideoList().get(3).getAvatar()).into(viewHolder.article_four_name_photo);
            viewHolder.article_four_title.setText(appendixBeen.get(position).getVideoList().get(3).getTitle());
            viewHolder.article_four_name.setText(appendixBeen.get(position).getVideoList().get(3).getChannelName());
        }
        // 第五组
        if (appendixBeen.get(position).getVideoList().get(4) != null){
            Picasso.with(context).load(appendixBeen.get(position).getVideoList().get(4).getCover()).into(viewHolder.article_five_ploto);
            Picasso.with(context).load(appendixBeen.get(position).getVideoList().get(4).getAvatar()).into(viewHolder.article_five_name_photo);
            viewHolder.article_five_title.setText(appendixBeen.get(position).getVideoList().get(4).getTitle());
            viewHolder.article_five_name.setText(appendixBeen.get(position).getVideoList().get(4).getChannelName());
        }


        return convertView;
    }

    class ViewHolder{
        TextView title; ImageView more;
        ImageView article_one_ploto,article_one_name_photo; TextView article_one_title,article_one_name;
        ImageView article_two_ploto,article_two_name_photo; TextView article_two_title,article_two_name;
        ImageView article_three_ploto,article_three_name_photo; TextView article_three_title,article_three_name;
        ImageView article_four_ploto,article_four_name_photo; TextView article_four_title,article_four_name;
        ImageView article_five_ploto,article_five_name_photo; TextView article_five_title,article_five_name;

        public ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.item_appendix_listview_title_tv);
            more = (ImageView) view.findViewById(R.id.item_appendix_listview_more_iv);
            article_one_ploto = (ImageView) view.findViewById(R.id.item_appendix_listview_article_one_ploto);
            article_one_name_photo = (ImageView) view.findViewById(R.id.item_appendix_listview_article_one_name_photo);
            article_one_title = (TextView) view.findViewById(R.id.item_appendix_listview_article_one_title);
            article_one_name = (TextView) view.findViewById(R.id.item_appendix_listview_article_one_name);
            article_two_ploto = (ImageView) view.findViewById(R.id.item_appendix_listview_article_two_ploto);
            article_two_name_photo = (ImageView) view.findViewById(R.id.item_appendix_listview_article_two_name_photo);
            article_two_title  = (TextView) view.findViewById(R.id.item_appendix_listview_article_two_title);
            article_two_name = (TextView) view.findViewById(R.id.item_appendix_listview_article_two_name);
            article_three_ploto = (ImageView) view.findViewById(R.id.item_appendix_listview_article_three_ploto);
            article_three_name_photo = (ImageView) view.findViewById(R.id.item_appendix_listview_article_three_name_photo);
            article_three_title = (TextView) view.findViewById(R.id.item_appendix_listview_article_three_title);
            article_three_name = (TextView) view.findViewById(R.id.item_appendix_listview_article_three_name);
            article_four_ploto = (ImageView) view.findViewById(R.id.item_appendix_listview_article_four_ploto);
            article_four_name_photo = (ImageView) view.findViewById(R.id.item_appendix_listview_article_four_name_photo);
            article_four_title = (TextView) view.findViewById(R.id.item_appendix_listview_article_four_title);
            article_four_name = (TextView) view.findViewById(R.id.item_appendix_listview_article_four_name);
            article_five_ploto = (ImageView) view.findViewById(R.id.item_appendix_listview_article_five_ploto);
            article_five_name_photo = (ImageView) view.findViewById(R.id.item_appendix_listview_article_five_name_photo);
            article_five_title = (TextView) view.findViewById(R.id.item_appendix_listview_article_five_title);
            article_five_name = (TextView) view.findViewById(R.id.item_appendix_listview_article_five_name);
        }
    }


}
