package com.lanou.taochangjun.gift.projectbapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.lanou.taochangjun.gift.projectbapp.R;
import com.lanou.taochangjun.gift.projectbapp.me.RecordAdapter;
import com.lanou.taochangjun.gift.projectbapp.video.VideoActivity;
import com.lanou.taochangjun.gift.projectbapp.video.VideoBean;
import com.litesuits.orm.LiteOrm;

import java.util.List;

/**
 * Created by imac on 2017/3/11.
 */
public class RecordActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private List<VideoBean> mVideoBean;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        LiteOrm liteOrm = LiteOrm.newSingleInstance(this,"video.db");
        mListView = (ListView) findViewById(R.id.lv);

        RecordAdapter recordAdapter =  new RecordAdapter(this);
        mVideoBean = liteOrm.query(VideoBean.class);
        recordAdapter.setVideoBeen(mVideoBean);
        mListView.setAdapter(recordAdapter);
        mListView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String url = mVideoBean.get(position).getUrl();
        Intent intent = new Intent(this, RecordActivity.class);
        intent.putExtra("url",url);
        startActivity(intent);
        Toast.makeText(this, "你追我,如果你追上我,我就让德鹏跟你嘿嘿嘿", Toast.LENGTH_SHORT).show();
    }
}
