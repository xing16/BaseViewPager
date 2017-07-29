package com.xing.bannerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xing.bannerviewlib.BaseViewPager;
import com.xing.bannerviewlib.ViewHolderCreator;
import com.xing.bannerviewlib.ViewPagerHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private BaseViewPager viewPager;

    private List<NewsBean> mDataList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (BaseViewPager) findViewById(R.id.base_view_pager);
        ImageView image = (ImageView) findViewById(R.id.iv_icon);
        Glide.with(this).load("http://ws1.sinaimg.cn/large/610dc034ly1fhegpeu0h5j20u011iae5.jpg").into(image);
        mDataList.add(new NewsBean(R.drawable.ic_1, "MackBook Pro 2017"));
        mDataList.add(new NewsBean(R.drawable.ic_2, "MackBook Pro 2017"));
        mDataList.add(new NewsBean(R.drawable.ic_3, "MackBook Pro 2017"));
        viewPager.setPages(mDataList, new ViewHolderCreator() {
            @Override
            public ViewPagerHolder create() {
                return holder;
            }
        });
    }

    private ViewPagerHolder<NewsBean> holder = new ViewPagerHolder<NewsBean>() {

        ImageView imageView;

        @Override
        public View onCreateView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.pager_item, null);
            imageView = (ImageView) view.findViewById(R.id.iv_image);
            return view;
        }

        @Override
        public void onBindViewHolder(Context context, NewsBean data, int position) {
            Log.i(TAG, "onBindViewHolder: data.getPicUrl() = " + data.getPicUrl());
            Glide.with(getApplicationContext()).load(data.getResId()).into(imageView);

        }
    };

}
