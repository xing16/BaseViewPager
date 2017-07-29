package com.xing.bannerviewlib;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * PagerAdapter 关联 Viewholder
 * Created by Administrator on 2017/7/29.
 */

public class ViewPagerAdapter<T> extends PagerAdapter {

    private List<T> mData;

    private Context mContext;

    private ViewHolderCreator creator;

    public ViewPagerAdapter(Context context, List<T> data, ViewHolderCreator creator) {
        mContext = context;
        this.mData = data;
        this.creator = creator;
    }


    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = getView(null, position);
        container.addView(view);
        return view;
    }

    private View getView(View view, int position) {
        ViewPagerHolder holder = null;
        if (view == null) {
            holder = creator.create();
            view = holder.onCreateView(mContext);
            view.setTag(R.string.app_name, holder);
        } else {
            holder = (ViewPagerHolder) view.getTag(R.string.app_name);
        }
        if (holder != null && mData != null && mData.size() > 0) {
            holder.onBindViewHolder(mContext, mData.get(position), position);
        }
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
