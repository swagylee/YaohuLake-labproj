package com.example.demo.service.impl;

import com.example.demo.dao.ShopDao;
import com.example.demo.entity.Shop;
import com.example.demo.service.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopDao shopDao;
    public ShopServiceImpl(){

    }
    @Override
    public List<Shop> queryAllShops() {
        return this.shopDao.queryAllShops();
    }

    @Override
    public Shop queryshopById(Long shopId) {
        Shop shop = shopDao.queryshopById(shopId);
        if(shop == null){
            throw new RuntimeException("检索不到当前商店，请检查商店码是否正确。");
        }else {
            return shop;
        }
    }

    @Transactional
    public Long addShop(Shop shop) {
        int effectedNum = this.shopDao.addShop(shop);
        if (effectedNum > 0) {
            return shop.getShopId();
        } else {
            throw new RuntimeException("加入商品信息失败");
        }
    }
}
