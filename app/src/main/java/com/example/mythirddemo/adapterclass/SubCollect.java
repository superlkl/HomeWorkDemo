package com.example.mythirddemo.adapterclass;

public class SubCollect {
    private String name;
    private String imageId;
    public SubCollect(String name,String imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}
