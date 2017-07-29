package com.xing.bannerviewlib;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2017/7/29.
 */

public interface ViewPagerHolder<T> {

    View onCreateView(Context context);

    void onBindViewHolder(Context context, T data, int position);

}
