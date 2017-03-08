package com.lanou.taochangjun.gift.projectbapp.home.recommend.headd;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.bean.CarouseBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by dllo on 17/3/8.
 */

public class RotateVpAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<CarouseBean> datas;

    public RotateVpAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<CarouseBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // position是int最大值所以这里可能是几百甚至上千,因此取余避免数组越界
        int newPosition = position % datas.size();

        View converView = inflater.inflate(R.layout.item_carouse_pageadapter,container,false);

        // 文字
        TextView textView = (TextView) converView.findViewById(R.id.item_rotate_tv);
        textView.setText(datas.get(newPosition).getTitle());

        // 视频
//        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.actvity_video_jiecao);
//        jcVideoPlayerStandard.setUp(videoUrl,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);
//        jcVideoPlayerStandard.thumbImageView.setImageURI(pp);
        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) converView.findViewById(R.id.item_page_jiecao);
        String uri = datas.get(newPosition).getLinkMp4();
        String title = datas.get(newPosition).getTitle();
        jcVideoPlayerStandard.setUp(uri,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);

        JCVideoPlayer.releaseAllVideos();


        container.addView(converView);
        return converView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
