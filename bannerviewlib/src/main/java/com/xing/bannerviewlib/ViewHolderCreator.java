package com.xing.bannerviewlib;

/**
 * Created by Administrator on 2017/7/29.
 */

public interface ViewHolderCreator<VH extends ViewPagerHolder> {

    ViewPagerHolder create();
}
