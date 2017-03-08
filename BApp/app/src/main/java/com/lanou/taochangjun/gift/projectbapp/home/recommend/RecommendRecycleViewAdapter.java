package com.lanou.taochangjun.gift.projectbapp.home.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.adapter.BacterialInterface;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.adapter.BacterialRecycleViewAdapter;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.adapter.ForyouRecycleViewAdapter;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.adapter.ListRecycleViewAdapter;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.bean.BacterialBean;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.bean.CarouseBean;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.bean.ForyouBean;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.bean.ListBean;

import com.lanou.taochangjun.gift.projectbapp.home.recommend.headd.RotateVpAdapter;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.headd.ScreenSizeUtils;
import com.lanou.taochangjun.gift.projectbapp.home.recommend.headd.ScreenState;
import com.lanou.taochangjun.gift.projectbapp.internet.MyOkHttpManager;
import com.lanou.taochangjun.gift.projectbapp.internet.Url;
import com.lanou.taochangjun.gift.projectbapp.video.VideoActivity;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/2/27.
 *
 * 张德鹏
 *
 *  这个适配器的作用是, 推荐页的适配器,   有嵌套各中适配器
 */

public class RecommendRecycleViewAdapter extends RecyclerView.Adapter{

    private Context context;

    // 轮播图
    private Handler handler;
    private Runnable rotateRunnable;
    private boolean isRotate = false;// 是否处于轮播状态
    private static final int TIME = 3000;// 轮播间隔时间


    public RecommendRecycleViewAdapter(Context context) {
        this.context = context;

    }

    // 所有的实体类
    private List<CarouseBean> carouseBeanList;
    private List<BacterialBean> bacterialBeanList ;  // 菠萝菌力荐
    private List<ListBean> listBeanList;             // 人气周榜

    private List<ForyouBean> foryouBeanList;

    @Override
    public int getItemViewType(int position) {

        switch (position){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;

        }


        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder =null;
        if (0 == viewType){

            View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_carousel,parent,false);
            holder = new CarouseHolder(view);
        }
        if (viewType == 1){
            View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_bacterial,parent,false);
            holder = new BacterialHolder(view);
        }
        if (viewType == 2 ){
            View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_list,parent,false);
            holder = new ListHolder(view);
        }

        if (viewType == 3  ){
           View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_foryou,parent,false);
           holder = new ForHolder(view);
        }


        return holder;
    }



    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {


//        final RotateAdapter rotateAdapter = new RotateAdapter(context);
        final RotateVpAdapter rotateVpAdapter = new RotateVpAdapter(context);
        final BacterialRecycleViewAdapter bactericAdapter = new BacterialRecycleViewAdapter(context);
        final ListRecycleViewAdapter listAdapter = new ListRecycleViewAdapter(context);
        final ForyouRecycleViewAdapter forAdapter = new ForyouRecycleViewAdapter(context);

        int viewType = getItemViewType(position);

        switch (viewType){
            case 0:


                final CarouseHolder holder1 = (CarouseHolder) holder;
                ViewGroup.LayoutParams lp = holder1.viewPager.getLayoutParams();
                lp.width = ScreenSizeUtils.getScreen(context, ScreenState.WIDTH);
                lp.height = (ScreenSizeUtils.getScreen(context,ScreenState.HEIGHT))/4;
                holder1.viewPager.setLayoutParams(lp);

                // 给轮播图绑定适配器
                handler = new Handler();
                holder1.viewPager.setAdapter(rotateVpAdapter);

                MyOkHttpManager.getsInstance().getAsyncAsString(Url.CAROUSEL, Url.CAROUSELCode, new MyOkHttpManager.StringCallback() {
                    @Override
                    public void onFailure(IOException e) {

                    }

                    @Override
                    public void onSuccessful(int requestCode, String result) {

                        Gson gson = new Gson();
                        Type type = new TypeToken<List<CarouseBean>>(){}.getType();

                        carouseBeanList = gson.fromJson(result,type);
                        if (carouseBeanList != null){
                            rotateVpAdapter.setDatas(carouseBeanList);
                        }

                        // ViewPager的页数为int最大值,设置当前页多一些,可以上来就向前滑动
                        // 为了保证第一页始终为数据的第0条 取余要为0,因此设置数据集合大小的倍数
                        holder1.viewPager.setCurrentItem(carouseBeanList.size() * 100);

                        // 开始轮播
                        // 开始轮播-和添加轮播小点等方法都应该写在获取到网络数据之后
                        // 否则：空指针

                    }
                });









                break;
            case 1:

                MyOkHttpManager.getsInstance().getAsyncAsString(Url.PINEAPPLE, Url.PINEAPPLECode, new MyOkHttpManager.StringCallback() {
                    @Override
                    public void onFailure(IOException e) {

                    }

                    @Override
                    public void onSuccessful(int requestCode, String result) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<BacterialBean>>(){}.getType();
                        bacterialBeanList = gson.fromJson(result,type);

//                        Log.d("RecommendFragment1", bacterialBeanList.get(0).getTitle());
                        bactericAdapter.setBean(bacterialBeanList);





                    }
                });


                BacterialHolder bacterialHolder = (BacterialHolder) holder;


                StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                bacterialHolder.rv.setLayoutManager(manager);
                bacterialHolder.rv.setAdapter(bactericAdapter);
                break;
            case 2:

                MyOkHttpManager.getsInstance().getAsyncAsString(Url.PEOPLE, Url.PEOPLECode, new MyOkHttpManager.StringCallback() {
                    @Override
                    public void onFailure(IOException e) {

                    }

                    @Override
                    public void onSuccessful(int requestCode, String result) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<ListBean>>(){}.getType();
                        listBeanList = gson.fromJson(result,type);

                        Log.d("RecommendFragment2", listBeanList.get(0).getName());
                        listAdapter.setBeen(listBeanList);

                    }
                });



                ListHolder listHolder = (ListHolder) holder;


                StaggeredGridLayoutManager manager2 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);
                listHolder.rv.setLayoutManager(manager2);
                listHolder.rv.setAdapter(listAdapter);
                break;
            case 3:

                MyOkHttpManager.getsInstance().getAsyncAsString(Url.RECOMMEND, Url.RECOMMENDCode, new MyOkHttpManager.StringCallback() {
                    @Override
                    public void onFailure(IOException e) {

                    }

                    @Override
                    public void onSuccessful(int requestCode, String result) {
                      Gson gson = new Gson();
                        Type type = new TypeToken<List<ForyouBean>>(){}.getType();
                        foryouBeanList = gson.fromJson(result,type);
                        Log.d("RecommendRecycleViewAda", "foryouBeanList.size():" + foryouBeanList.size());
                        forAdapter.setBean(foryouBeanList);
                    }
                });
                ForHolder forHolder = (ForHolder) holder;
                  StaggeredGridLayoutManager manager3 = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

                  forHolder.recyclerView.setLayoutManager(manager3);
                  forHolder.recyclerView.setAdapter(forAdapter);

                break;



        }

              bactericAdapter.setAnInterface(new BacterialInterface() {
                  @Override
                  public void OnClick(int position) {
                      Intent intent = new Intent(context, VideoActivity.class);
                      String uri = bacterialBeanList.get(position).getLinkMp4();
                      intent.putExtra("Uri",uri);
                      context.startActivity(intent);

                  }
              });



    }

    @Override
    public int getItemCount() {
        return 4;
    }



    // 轮播图
    class CarouseHolder extends RecyclerView.ViewHolder{

        ViewPager viewPager ;
        public CarouseHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.item_recommend_carousel_viewpage);
        }
    }

    // 菠萝菌力荐
    class BacterialHolder extends RecyclerView.ViewHolder{
        RecyclerView rv ;
        ImageView more;

        public BacterialHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.item_recommend_bacterical_rv);
            more = (ImageView) itemView.findViewById(R.id.item_recommend_bacterical_more_iv);
        }
    }

    // 人气周榜
    class ListHolder extends  RecyclerView.ViewHolder{
        RecyclerView rv ;
        ImageView more;
        public ListHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.item_recommend_list_rv);
            more = (ImageView) itemView.findViewById(R.id.item_recommend_list_more_iv);

        }
    }

    // po
    class ForHolder extends  RecyclerView.ViewHolder{
       RecyclerView recyclerView;
        public ForHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.item_recommend_foryou_rv);
        }
    }







}
