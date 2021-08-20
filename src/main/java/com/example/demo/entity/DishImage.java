package com.example.demo.entity;

public class DishImage {
    private Long imageId;
    private String imageAddr;
    private Long dishId;
    private Long shopId;


    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public DishImage(String imageAddr , Long dishId , Long shopId){
        this.dishId = dishId;
        this.imageAddr = imageAddr;
        this.shopId = shopId;
    }
    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageAddr() {
        return imageAddr;
    }

    public void setImageAddr(String imageAddr) {
        this.imageAddr = imageAddr;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }
}
