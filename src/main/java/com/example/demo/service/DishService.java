package com.example.demo.service;

import com.example.demo.entity.Dish;

import java.util.List;

public interface DishService {
    List<Dish> queryDishesByShopId(Long shopId);
    List<Dish> queryAllDishes();
    List<Dish> queryAvaliableDishes(Long shopId);
    Long addDish(Dish dish);
}
