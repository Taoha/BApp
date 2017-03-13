package com.lanou.taochangjun.gift.projectbapp.video;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.view.RecordActivity;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

// 播放视频的Activity  张德鹏

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {


    private VideoView videoView;
    private ImageView home_title_img_follow;
    private LiteOrm mLiteOrm;
    private String mVideoUrl;
    private String mTitle;
    private String mPhoto;
    private String mAuthor;
    private VideoBean mVideoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        mLiteOrm = LiteOrm.newSingleInstance(this, "video.db");

        home_title_img_follow = (ImageView) findViewById(R.id.home_title_img_follow);
       home_title_img_follow.setOnClickListener(this);

//
//        // 网络视频
        Intent intent = getIntent();
        mVideoUrl = intent.getStringExtra("Uri");
        mTitle = intent.getStringExtra("title");
        mPhoto = intent.getStringExtra("photo");
        mAuthor = intent.getStringExtra("author");

        Uri pp = Uri.parse(mPhoto);
        Uri uri = Uri.parse(mVideoUrl);


        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.actvity_video_jiecao);
        jcVideoPlayerStandard.setUp(mVideoUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, mTitle);
        jcVideoPlayerStandard.thumbImageView.setImageURI(pp);


        JCVideoPlayer.releaseAllVideos();


    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    private VideoBean buildData() {
        mVideoBean = new VideoBean();
        mVideoBean.setAuthor(mAuthor);
        mVideoBean.setPhoto(mPhoto);
        mVideoBean.setTitle(mTitle);
        mVideoBean.setUrl(mVideoUrl);
        return mVideoBean;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_title_img_follow:

                QueryBuilder<VideoBean> queryBuilder = new QueryBuilder<>(VideoBean.class);
                queryBuilder.where("title = ?", new Object[]{mTitle});
                List<VideoBean> list = mLiteOrm.query(queryBuilder);
                Log.d("VideoActivity", "list.size():" + list.size());

                if (list.size() == 0) {
                    mVideoBean = buildData();
                    mLiteOrm.insert(mVideoBean);
                    Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
                    home_title_img_follow.setImageResource(R.mipmap.home_title_img_follow);

                } else if (list.size() > 0) {
                    mLiteOrm.delete(list);
                    Toast.makeText(this, "你残忍的,不爱我了", Toast.LENGTH_SHORT).show();
                    home_title_img_follow.setImageResource(R.mipmap.video_player_favor);
                }


                break;

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        QueryBuilder<VideoBean> queryBuilder = new QueryBuilder<>(VideoBean.class);
        queryBuilder.where("title = ?", new Object[]{mTitle});
        List<VideoBean> list = mLiteOrm.query(queryBuilder);
        if (list.size()>0){
            home_title_img_follow.setImageResource(R.mipmap.home_title_img_follow);

        }
    }
}
