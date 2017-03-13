package com.lanou.taochangjun.gift.projectbapp.home.appendix;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.video.VideoActivity;
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

    public AppendixListViewAdapter(Context context1) {

        this.context = context1;

    }

    public void setAppendixBeen(List<AppendixBean> appendixBeen) {
        this.appendixBeen = appendixBeen;

    }

    @Override
    public int getCount() {
        return appendixBeen != null && appendixBeen.size()>0? 2 : 0;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){

            convertView = LayoutInflater.from(context).inflate(R.layout.item_appendix_listview,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 标题
        viewHolder.title.setText(appendixBeen.get(position).getVideoCategory().getName());
        // 第一组
        if (appendixBeen.get(position).getVideoList().get(0)!=null){
            Glide.with(context).load(appendixBeen.get(position).getVideoList().get(0).getCover()).override(600,200).into(viewHolder.article_one_ploto);
            Glide.with(context).load(appendixBeen.get(position).getVideoList().get(0).getAvatar()).override(600,200).into(viewHolder.article_one_name_photo);
            viewHolder.article_one_title.setText(appendixBeen.get(position).getVideoList().get(0).getTitle());
            viewHolder.article_one_name.setText(appendixBeen.get(position).getVideoList().get(0).getChannelName());

            viewHolder.article_one_ploto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, VideoActivity.class);
                    String uri = appendixBeen.get(position).getVideoList().get(0).getLinkMp4();
                    String title = appendixBeen.get(position).getVideoList().get(0).getTitle();
                    String photo = appendixBeen.get(position).getVideoList().get(0).getCover();
                    String author = appendixBeen.get(position).getVideoList().get(0).getChannelName();
                    intent.putExtra("author",author);
                    intent.putExtra("Uri",uri);
                    intent .putExtra("title",title);
                    intent.putExtra("photo",photo);
                    context.startActivity(intent);
                }
            });
        }
        // 第二组
        if (appendixBeen.get(position).getVideoList().get(1) != null){
            Glide.with(context).load(appendixBeen.get(position).getVideoList().get(1).getCover()).override(600,200).into(viewHolder.article_two_ploto);
            Glide.with(context).load(appendixBeen.get(position).getVideoList().get(1).getAvatar()).override(600,200).into(viewHolder.article_two_name_photo);
            viewHolder.article_two_title.setText(appendixBeen.get(position).getVideoList().get(1).getTitle());
            viewHolder.article_two_name.setText(appendixBeen.get(position).getVideoList().get(1).getChannelName());

            viewHolder.article_two_ploto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, VideoActivity.class);
                    String uri = appendixBeen.get(position).getVideoList().get(1).getLinkMp4();
                    String title = appendixBeen.get(position).getVideoList().get(1).getTitle();
                    String photo = appendixBeen.get(position).getVideoList().get(1).getCover();
                    String author = appendixBeen.get(position).getVideoList().get(1).getChannelName();
                    intent.putExtra("author",author);
                    intent.putExtra("Uri",uri);
                    intent .putExtra("title",title);
                    intent.putExtra("photo",photo);
                    context.startActivity(intent);
                }
            });

        }
        // 第三组
        if (appendixBeen.get(position).getVideoList().get(2) != null){
            Glide.with(context).load(appendixBeen.get(position).getVideoList().get(2).getCover()).override(600,200).into(viewHolder.article_three_ploto);
            Glide.with(context).load(appendixBeen.get(position).getVideoList().get(2).getAvatar()).override(600,200).into(viewHolder.article_three_name_photo);
            viewHolder.article_three_title.setText(appendixBeen.get(position).getVideoList().get(2).getTitle());
            viewHolder.article_three_name.setText(appendixBeen.get(position).getVideoList().get(2).getChannelName());

            viewHolder.article_three_ploto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, VideoActivity.class);
                    String uri = appendixBeen.get(position).getVideoList().get(2).getLinkMp4();
                    String title = appendixBeen.get(position).getVideoList().get(2).getTitle();
                    String photo = appendixBeen.get(position).getVideoList().get(2).getCover();
                    String author = appendixBeen.get(position).getVideoList().get(2).getChannelName();
                    intent.putExtra("author",author);
                    intent.putExtra("Uri",uri);
                    intent .putExtra("title",title);
                    intent.putExtra("photo",photo);
                    context.startActivity(intent);
                }
            });


        }
        // 第四组
        if (appendixBeen.get(position).getVideoList().get(3) != null){
            Glide.with(context).load(appendixBeen.get(position).getVideoList().get(3).getCover()).override(600,200).into(viewHolder.article_four_ploto);
            Glide.with(context).load(appendixBeen.get(position).getVideoList().get(3).getAvatar()).override(600,200).into(viewHolder.article_four_name_photo);
            viewHolder.article_four_title.setText(appendixBeen.get(position).getVideoList().get(3).getTitle());
            viewHolder.article_four_name.setText(appendixBeen.get(position).getVideoList().get(3).getChannelName());

            viewHolder.article_four_ploto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, VideoActivity.class);
                    String uri = appendixBeen.get(position).getVideoList().get(3).getLinkMp4();
                    String title = appendixBeen.get(position).getVideoList().get(3).getTitle();
                    String photo = appendixBeen.get(position).getVideoList().get(3).getCover();
                    String author = appendixBeen.get(position).getVideoList().get(3).getChannelName();
                    intent.putExtra("author",author);
                    intent.putExtra("Uri",uri);
                    intent .putExtra("title",title);
                    intent.putExtra("photo",photo);
                    context.startActivity(intent);
                }
            });

        }
        // 第五组
        if (appendixBeen.get(position).getVideoList().get(4) != null){
            Glide.with(context).load(appendixBeen.get(position).getVideoList().get(4).getCover()).override(600,200).into(viewHolder.article_five_ploto);
            Glide.with(context).load(appendixBeen.get(position).getVideoList().get(4).getAvatar()).override(600,200).into(viewHolder.article_five_name_photo);
            viewHolder.article_five_title.setText(appendixBeen.get(position).getVideoList().get(4).getTitle());
            viewHolder.article_five_name.setText(appendixBeen.get(position).getVideoList().get(4).getChannelName());

            viewHolder.article_five_ploto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, VideoActivity.class);
                    String uri = appendixBeen.get(position).getVideoList().get(4).getLinkMp4();
                    String title = appendixBeen.get(position).getVideoList().get(4).getTitle();
                    String photo = appendixBeen.get(position).getVideoList().get(4).getCover();
                    String author = appendixBeen.get(position).getVideoList().get(4).getChannelName();
                    intent.putExtra("author",author);
                    intent.putExtra("Uri",uri);
                    intent .putExtra("title",title);
                    intent.putExtra("photo",photo);
                    context.startActivity(intent);
                }
            });

        }


//        viewHolder.article_one_ploto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, VideoActivity.class);
//                String uri = appendixBeen.get(position).getVideoList().get(0).getLinkMp4();
//                String title = appendixBeen.get(position).getVideoList().get(0).getTitle();
//                String photo = appendixBeen.get(position).getVideoList().get(0).getCover();
//                intent.putExtra("Uri",uri);
//                intent .putExtra("title",title);
//                intent.putExtra("photo",photo);
//                context.startActivity(intent);
//
//            }
//        });



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
