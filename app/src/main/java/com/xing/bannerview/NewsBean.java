package com.xing.bannerview;

/**
 * Created by Administrator on 2017/7/29.
 */

public class NewsBean {

    private int resId;

    private String picUrl;

    private String title;

    public NewsBean(String picUrl, String title) {
        this.picUrl = picUrl;
        this.title = title;
    }

    public NewsBean() {
    }

    public NewsBean(int resId, String title) {
        this.title = title;
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "picUrl='" + picUrl + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
