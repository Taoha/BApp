package com.lanou.taochangjun.gift.projectbapp.video;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.lanou.taochangjun.gift.projectbapp.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import okhttp3.internal.Util;

// 播放视频的Activity  张德鹏

public class VideoActivity extends AppCompatActivity {


    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

//        videoView = (VideoView) findViewById(R.id.actvity_video_videoview);
//
//        // 网络视频
        Intent intent = getIntent();
        String videoUrl = intent.getStringExtra("Uri");
        String title = intent.getStringExtra("title");
        String photo = intent.getStringExtra("photo");
        Uri pp = Uri.parse(photo);
        Uri uri = Uri.parse(videoUrl);
//        videoView.setMediaController(new MediaController(this));
//        videoView.setVideoURI(uri);
//        videoView.requestFocus();

        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.actvity_video_jiecao);
        jcVideoPlayerStandard.setUp(videoUrl,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);
        jcVideoPlayerStandard.thumbImageView.setImageURI(pp);



        JCVideoPlayer.releaseAllVideos();


    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }




}
