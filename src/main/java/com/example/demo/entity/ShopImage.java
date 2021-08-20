package com.example.demo.entity;

public class ShopImage {
    private Long imageId;
    private String imageAddr;
    private Long ownedShop;
    public ShopImage(){

    }
    public ShopImage(String imageAddr , Long ownedShop){
        this.imageAddr = imageAddr;
        this.ownedShop = ownedShop;
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

    public Long getOwnedShop() {
        return ownedShop;
    }

    public void setOwnedShop(Long ownedShop) {
        this.ownedShop = ownedShop;
    }
}
