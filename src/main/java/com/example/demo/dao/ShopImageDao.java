package com.example.demo.dao;

import com.example.demo.entity.ShopImage;

import java.util.List;

public interface ShopImageDao {
    List<ShopImage> queryAllShopImages();
    ShopImage queryImageByShopid(Long account);
    int insertShopImage(ShopImage shopImage);
}
