package com.example.demo.dao;

import com.example.demo.entity.Dish;

import java.util.List;

public interface DishDao {
    List<Dish> queryDishesByShopId(Long shopId);
    List<Dish> queryAllDishes();
    List<Dish> queryAvaliableDishes(Long shopId);
    int addDish(Dish dish);

}
