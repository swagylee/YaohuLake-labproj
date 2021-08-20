package com.example.demo.service;

import com.example.demo.entity.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> queryAllShops();

    Shop queryshopById(Long shopId);
    Long addShop(Shop shop);
}
