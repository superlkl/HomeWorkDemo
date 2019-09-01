package com.example.mythirddemo.adapterclass;

public class MyTop {
    private String name;
    private int imageId;
    public MyTop(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName() {
        return name;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public void setName(String name) {
        this.name = name;
    }
}
