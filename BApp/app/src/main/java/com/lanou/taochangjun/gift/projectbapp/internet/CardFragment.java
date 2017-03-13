package com.lanou.taochangjun.gift.projectbapp.internet;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.fire.FireActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡片Fragment
 *
 * @author xmuSistone
 */
@SuppressLint({"HandlerLeak", "NewApi", "InflateParams"})
public class CardFragment extends Fragment implements View.OnClickListener {
    //使用数组存放图片ID
    private int[] res = {
            R.id.imageview1, R.id.imageview2, R.id.imageview3, R.id.imageview4};
    //使用List存放图片
    private List<ImageView> imgs = new ArrayList<ImageView>();
    //按钮点击事件的标志
    private boolean flag = true;
    //菜单按钮
    private ImageView imageviewstart;

    private CardSlidePanel.CardSwitchListener cardSwitchListener;


//今晚时间来不及了  明天早上来  把这个数组改成实体类试一下,实在不行问老师
    private FireBean mFireBean;
    private String imagePaths[] = {
            "http://bobolive.nosdn.127.net/aac_bobo_1474415966985_45529404.mp4?vframe&offset=7&type=jpg&wsiphost=local",
            "http://bobo-public.nosdn.127.net/bobo_1488608183211_60016432.jpg",
            "http://bobolive.nosdn.127.net/aac_bobo_1464704231158_25000218.mp4?vframe&offset=145&type=jpg",
            "http://bobo-public.nosdn.127.net/bobo_1488802871429_99968157.jpg",
            "http://bobolive.nosdn.127.net/new_bobo_1462362845678_26353391.mp4?vframe&offset=55&type=jpg",
            "http://bobolive.nosdn.127.net/aac_bobo_1465367966478_77241472.mp4?vframe&offset=1091&type=jpg",
            "http://bobo-public.nosdn.127.net/bobo_1488521623338_43324578.png",
            "http://bobolive.nosdn.127.net/aac_bobo_1470992214883_15352841.mp4?vframe&offset=99&type=jpg"}; // 8个图片资源名称

    private String names[] = {"【猫有卵用】溺水篇", "徐老师来巡山104：皎月搞笑滑行踩灯被击落", "56 富贵扇贝开运虾", "小太阳烤出来的肉串油爆爆，这个冬天不太冷",
            "大力金刚84 大力online2", "我的三体】第一季07 三体（MC月番）", "【屎屎看】01 神抽一发，换你老家", "小羽私厨-黄焖鸡"}; // 8个人名

    private List<CardDataItem> dataList = new ArrayList<CardDataItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.card_layout, null);
        initView(rootView);
        //将7个子菜单图片添加点击事件并添加到List
        for (int i = 0; i < res.length; i++) {
            ImageView imageview = (ImageView) rootView.findViewById(res[i]);
            imageview.setOnClickListener(this);
            imgs.add(imageview);
        }
        //主按钮添加点击事件
        imageviewstart = (ImageView) rootView.findViewById(R.id.imageview8);
        imageviewstart.setOnClickListener(this);
        return rootView;
    }


    private void initView(View rootView) {

        CardSlidePanel slidePanel = (CardSlidePanel) rootView
                .findViewById(R.id.image_slide_panel);
        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {


            @Override
            public void onShow(int index) {
                Log.d("CardFragment", "正在显示-" + dataList.get(index).userName);
            }

            @Override
            public void onCardVanish(int index, int type) {
                Log.d("CardFragment", "正在消失-" + dataList.get(index).userName + " 消失type=" + type);
            }

            @Override
            public void onItemClick(View cardView, int index) {
                Log.d("110", "index:============" + index);
                Log.d("CardFragment", "卡片点击-" + dataList.get(index).userName);
                Intent intent = new Intent(getActivity(), FireActivity.class);
//                Log.d("2222", "---->:" + intent);
//                String type = mFireBean.getLinkMp4() +"";
//                Log.d("aaaa", type);
//                intent.putExtra("type",type);
                startActivity(intent);
            }
        };
        slidePanel.setCardSwitchListener(cardSwitchListener);

        prepareDataList();
        slidePanel.fillData(dataList);
    }

    private void prepareDataList() {
        int num = imagePaths.length;

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < num; i++) {
                CardDataItem dataItem = new CardDataItem();
                dataItem.userName = names[i];
                dataItem.imagePath = imagePaths[i];
                dataItem.likeNum = (int) (Math.random() * 10);
                dataItem.imageNum = (int) (Math.random() * 6);
                dataList.add(dataItem);
            }
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageview8:
                if (flag) {
                    flag = false;
                    startAnim();//子菜单弹出动画
                    Log.d("CardFragment", "imageviewstart:" + imageviewstart);
                } else {
                    flag = true;
                    closeAnim();//子菜单收回动画
                }
                break;
        }
    }

    private void closeAnim() {
        float myroate = (float) (Math.PI / 2 / 6);
        for (int i = 0; i < res.length; i++) {
            //500是半径，通过三角函数计算坐标
            float x = (float) (-240 * Math.cos(myroate * i));
            float y = (float) (-240 * Math.sin(myroate * i));

//使用属性动画的平移动画，将坐标从现在的位置移回到原点
            ObjectAnimator animator = ObjectAnimator.ofFloat(imgs.get(i),
                    "translationY", y, 0);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(imgs.get(i),
                    "translationX", x, 0);
//使用AnimatorSet可以同时播放多个属性动画
            AnimatorSet set = new AnimatorSet();
//使用自由落体的差值器
            animator.setInterpolator(new BounceInterpolator());
            animator2.setInterpolator(new BounceInterpolator());
            //设定同时播放
            set.playTogether(animator, animator2);
            //设定播放时间
            set.setDuration(1000);
            //开始播放动画（千万不要忘记这一行）
            set.start();
        }
    }

    private void startAnim() {
        float myroate = (float) (Math.PI / 2 / 6);
        for (int i = 0; i < res.length; i++) {
            float x = (float) (-240 * Math.cos(myroate * i));
            float y = (float) (-240 * Math.sin(myroate * i));

//使用属性动画的平移动画，将坐标从原点移动到每个子菜单对应的位置
            ObjectAnimator animator = ObjectAnimator.ofFloat(imgs.get(i),
                    "translationY", 0, y);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(imgs.get(i),
                    "translationX", 0, x);
            AnimatorSet set = new AnimatorSet();
            animator.setInterpolator(new BounceInterpolator());
            animator2.setInterpolator(new BounceInterpolator());
            set.playTogether(animator, animator2);
            set.setDuration(1000);
            set.start();
        }
    }
}
