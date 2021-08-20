package com.example.demo.dao;

import com.example.demo.entity.Shop;


import java.util.List;

public interface ShopDao {
    List<Shop> queryAllShops();

    Shop queryshopById(Long shopId);
    int addShop(Shop shop);
}
