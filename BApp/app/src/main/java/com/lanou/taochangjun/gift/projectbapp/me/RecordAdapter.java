package com.lanou.taochangjun.gift.projectbapp.me;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.headd.ScreenSizeUtils;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.headd.ScreenState;
import com.lanou.taochangjun.gift.projectbapp.video.VideoBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by imac on 2017/3/11.
 */

public class RecordAdapter extends BaseAdapter {
    private Context mContext;
    private List<VideoBean> mVideoBeen;

    public RecordAdapter(Context context) {
        mContext = context;
    }

    public void setVideoBeen(List<VideoBean> videoBeen) {
        mVideoBeen = videoBeen;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mVideoBeen != null && mVideoBeen.size() > 0 ? mVideoBeen.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mVideoBeen != null ? mVideoBeen.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_record,parent,false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        ViewGroup.LayoutParams layoutParams = myViewHolder.mImageView.getLayoutParams();
        layoutParams.width = ScreenSizeUtils.getScreen(mContext, ScreenState.WIDTH) / 5 * 2;
        layoutParams.height = ScreenSizeUtils.getScreen(mContext,ScreenState.HEIGHT)/ 6;
        myViewHolder.mImageView.setLayoutParams(layoutParams);

        Picasso.with(mContext).load(mVideoBeen.get(position).getPhoto()).into(myViewHolder.mImageView);
        myViewHolder.tv_one.setText(mVideoBeen.get(position).getTitle().toString());
        myViewHolder.tv_two.setText(mVideoBeen.get(position).getAuthor());


        return convertView;
    }
    class MyViewHolder{
        private ImageView mImageView;
        private TextView tv_one,tv_two;

        public MyViewHolder(View view){
            mImageView = (ImageView) view.findViewById(R.id.iv);
            tv_one = (TextView) view.findViewById(R.id.tv_one);
            tv_two = (TextView) view.findViewById(R.id.tv_two);

        }
    }

}
