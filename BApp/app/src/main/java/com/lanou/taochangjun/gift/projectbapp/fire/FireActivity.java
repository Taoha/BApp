package com.lanou.taochangjun.gift.projectbapp.fire;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.AbsBaseActivity;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by imac on 2017/3/7.
 * 作者陶长骏
 *
 *
 *
 * 内容:播放视频
 */

public class FireActivity extends AbsBaseActivity implements MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener {


    private Uri uri;
    private ProgressBar pb;
    private TextView downloadRateView, loadRateView;
    private CustomMediaController mCustomMediaController;
    private VideoView mVideoView;


    @Override
    protected int getLayout() {
        return R.layout.activity_fire;
    }

    @Override
    protected void initView() {
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window = FireActivity.this.getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        //必须写这个，初始化加载库文件
        Vitamio.isInitialized(this);
        mVideoView = byView(R.id.buffer);
        mCustomMediaController=new CustomMediaController(this,mVideoView,this);
        pb = byView(R.id.probar);
        downloadRateView =  byView(R.id.download_rate);
        loadRateView = byView(R.id.load_rate);

    }

    @Override
    protected void initData() {
//        Intent intent = getIntent();
//        String type = intent.getStringExtra("type");
        //视频地址
        String path = "http://bobolive.nosdn.127.net/aac_bobo_1474415966985_45529404.mp4";
        uri = Uri.parse(path);
        mVideoView.setVideoURI(uri);//设置视频播放地址

        mCustomMediaController.show(5000);
        mVideoView.setMediaController(mCustomMediaController);
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//高画质
        mVideoView.requestFocus();
        mVideoView.setOnInfoListener(this);
        mVideoView.setOnBufferingUpdateListener(this);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });

    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        switch (what) {
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                    pb.setVisibility(View.VISIBLE);
                    downloadRateView.setText("");
                    loadRateView.setText("");
                    downloadRateView.setVisibility(View.VISIBLE);
                    loadRateView.setVisibility(View.VISIBLE);

                }
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                mVideoView.start();
                pb.setVisibility(View.GONE);
                downloadRateView.setVisibility(View.GONE);
                loadRateView.setVisibility(View.GONE);
                break;
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                downloadRateView.setText("" + extra + "kb/s" + "  ");
                break;
        }
        return true;
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        loadRateView.setText(percent + "%");

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //屏幕切换时，设置全屏
        if (mVideoView != null){
            mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
        }
        super.onConfigurationChanged(newConfig);
    }
}
