package com.example.demo.service.impl;

import com.example.demo.dao.DishDao;
import com.example.demo.entity.Dish;
import com.example.demo.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DishServiceImpl implements DishService {
    @Autowired
    DishDao dishDao;

    @Override
    public List<Dish> queryDishesByShopId(Long shopId) {
        List<Dish> dishes = dishDao.queryDishesByShopId(shopId);
        if(dishes.size() == 0) {
            throw new RuntimeException("没查找到该店铺的菜品!");
        }
        else{
            return dishes;
        }

    }

    @Override
    public List<Dish> queryAllDishes() {
        return dishDao.queryAllDishes();
    }

    @Override
    public List<Dish> queryAvaliableDishes(Long shopId) {
        return dishDao.queryAvaliableDishes(shopId);
    }

    @Transactional
    public Long addDish(Dish dish) {
        int effectedNum = this.dishDao.addDish(dish);
        if (effectedNum > 0) {
            return dish.getDishId();
        } else {
            throw new RuntimeException("加入菜品信息失败");
        }
    }
}
