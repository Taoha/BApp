package com.lanou.taochangjun.gift.projectbapp.internet;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by dllo on 17/1/10.
 */

public class MyGirdView extends GridView {
    public MyGirdView(Context context) {
        super(context);
    }

    public MyGirdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGirdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
