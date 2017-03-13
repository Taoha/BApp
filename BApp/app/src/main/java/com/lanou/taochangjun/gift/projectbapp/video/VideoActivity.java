package com.lanou.taochangjun.gift.projectbapp.video;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.view.RecordActivity;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.ArrayList;
import java.util.List;
import com.lanou.taochangjun.gift.projectbapp.home.appendix.AppendixListBean;
import com.lanou.taochangjun.gift.projectbapp.internet.MyOkHttpManager;
import com.lanou.taochangjun.gift.projectbapp.internet.Url;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
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
    private String title;
    private String photo;
    private String videoUrl;
    private List<AppendixListBean> appendixListBeanList ;
    private VideoGridViewAdapter adapter;

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
        videoUrl = intent.getStringExtra("Uri");
        title = intent.getStringExtra("title");
        photo = intent.getStringExtra("photo");
        Uri pp = Uri.parse(photo);
        Uri uri = Uri.parse(videoUrl);
//        videoView.setMediaController(new MediaController(this));
//        videoView.setVideoURI(uri);
//        videoView.requestFocus();

        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.actvity_video_jiecao);
        jcVideoPlayerStandard.setUp(videoUrl,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, title);
        jcVideoPlayerStandard.tinyBackImageView.setImageURI(pp);


        JCVideoPlayer.releaseAllVideos();



        // 第三方分享
        ShareSDK.initSDK(this);


        ImageView share = (ImageView) findViewById(R.id.activity_video_share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  showShare();
            }
        });

//        final GridView gridView = (GridView) findViewById(R.id.activity_video_gridView);
//        adapter = new VideoGridViewAdapter(this);
//
//        MyOkHttpManager.getsInstance().getAsyncAsString(Url.HEADLINESUNDER, Url.HEADLINESUNDERCode, new MyOkHttpManager.StringCallback() {
//            @Override
//            public void onFailure(IOException e) {
//                Toast.makeText(VideoActivity.this, "网...", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onSuccessful(int requestCode, String result) {
//                Gson gson = new Gson();
//
//                Type type = new TypeToken<List<AppendixListBean>>(){}.getType();
//                appendixListBeanList = gson.fromJson(result,type);
//                adapter.setAppendixListBeanList(appendixListBeanList);
//                gridView.setAdapter(adapter);
//
//            }
//        });

    }





    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle(title);
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl(videoUrl);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("大家快来看一看");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(photo);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("大家快来看一看");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
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
