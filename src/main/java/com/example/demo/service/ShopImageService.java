package com.example.demo.service;

import com.example.demo.entity.ShopImage;

import java.util.List;

public interface ShopImageService {
    List<ShopImage> queryAllShopImages();
    ShopImage queryImageByShopid(Long account);
    boolean insertShopImage(ShopImage shopImage);
}
