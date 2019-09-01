package com.example.mythirddemo.adapter;

import com.example.mythirddemo.my.RecommendSings;

//每日推荐歌单类
public class RecommendSingsClass {
    private String imageId;
    private String singName;
    private String singerName;

    public RecommendSingsClass(){

    }
    public RecommendSingsClass(String imageId, String singName, String singerName){
        this.imageId=imageId;
        this.singName=singName;
        this.singerName=singerName;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getSingName() {
        return singName;
    }

    public void setSingName(String singName) {
        this.singName = singName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }


}
