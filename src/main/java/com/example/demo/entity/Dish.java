package com.example.demo.entity;

public class Dish {
        private Long dishId;
        private String dishName;
        private String dishPrice;
        private Boolean dishIsAvaliable;
        private Long ownedShop;

    public Long getDishId() {
        return dishId;
    }

    public Long getOwnedShop() {
        return ownedShop;
    }

    public void setOwnedShop(Long ownedShop) {
        this.ownedShop = ownedShop;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }

    public Boolean getDishIsAvaliable() {
        return dishIsAvaliable;
    }

    public void setDishIsAvaliable(Boolean dishIsAvaliable) {
        this.dishIsAvaliable = dishIsAvaliable;
    }


}
