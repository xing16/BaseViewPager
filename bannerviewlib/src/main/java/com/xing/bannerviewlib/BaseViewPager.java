package com.xing.bannerviewlib;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */

public class BaseViewPager<T> extends RelativeLayout {

    private Context mContext;

    private ViewPager viewPager;

    private ViewPagerAdapter mAdapter;

    public BaseViewPager(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    public BaseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.base_view_pager, this, true);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);

    }

    public void setPages(List<T> data, ViewHolderCreator creator) {
        mAdapter = new ViewPagerAdapter<T>(mContext, data, creator);
        mAdapter.notifyDataSetChanged();
        viewPager.setAdapter(mAdapter);
    }

    public void addOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        viewPager.addOnPageChangeListener(listener);
    }

    public void setCurrentItem(int currentItem) {
        viewPager.setCurrentItem(currentItem);
    }

    public ViewPagerAdapter getAdapter() {
        return mAdapter;
    }


}
