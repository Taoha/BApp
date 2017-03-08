package com.lanou.taochangjun.gift.projectbapp.fire;

import android.view.View;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.base.BaseFragment;
import com.lanou.taochangjun.gift.projectbapp.internet.CardFragment;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/**
 * Created by imac on 2017/2/20.
 */

/**
 * 作者:陶长骏
 * 作用:最火页面的Fragment
 */
public class FireFragment extends BaseFragment  {


    @Override
    public int setlayout() {
        return R.layout.fragment_fire;
    }


    @Override
    public void initView(View view) {



    }

    @Override
    public void initData() {
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.container,new CardFragment())
                .commitAllowingStateLoss();



        initImageLoader();



    }



    @SuppressWarnings("deprecation")
    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getContext())
                .memoryCacheExtraOptions(480, 800)
                // default = device screen dimensions
                .threadPoolSize(3)
                // default
                .threadPriority(Thread.NORM_PRIORITY - 1)
                // default
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024).memoryCacheSizePercentage(13) // default
                .discCacheSize(50 * 1024 * 1024) // 缓冲大小
                .discCacheFileCount(100) // 缓冲文件数目
                .discCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(getContext())) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs().build();

        // 2.单例ImageLoader类的初始化
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);

    }



}
