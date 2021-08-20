package com.example.demo.web;

import com.example.demo.entity.Dish;
import com.example.demo.entity.Shop;
import com.example.demo.entity.User;
import com.example.demo.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/yhl"})
public class ShopController {
    @Autowired
    ShopServiceImpl shopService;

    public ShopController(){};
    @RequestMapping(
            value = {"listallshops"},
            method = {RequestMethod.GET}
    )
    private Map<String, Object> queryShops() {
        Map<String, Object> modelMap = new HashMap();
        List<Shop> list = this.shopService.queryAllShops();
        modelMap.put("success", list);
        return modelMap;
    }

    @RequestMapping(
            value = {"listoneshop"},
            method = {RequestMethod.GET}
    )
    private Shop queryUserByAccount(Long account) {
        Shop shop = this.shopService.queryshopById(account);
        return shop;
    }
    @RequestMapping(
            value = {"insertshop"},
            method = {RequestMethod.POST}
    )
    private Map<String, Object> addShop(@RequestBody(required = false) Shop shop) {
        Map<String, Object> data = new HashMap();
        data.put("success", this.shopService.addShop(shop));
        return data;
    }
}
