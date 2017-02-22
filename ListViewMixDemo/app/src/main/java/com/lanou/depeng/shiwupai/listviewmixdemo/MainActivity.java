package com.lanou.depeng.shiwupai.listviewmixdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.main_lv);

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("123");
        }
        MyAdapter ad = new MyAdapter(this);
        ad.setData(data);
        list.setAdapter(ad);


    }
}
