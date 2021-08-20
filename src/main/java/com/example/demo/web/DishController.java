package com.example.demo.web;

import com.example.demo.entity.Dish;
import com.example.demo.entity.Shop;
import com.example.demo.service.impl.DishServiceImpl;
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
public class DishController {
    @Autowired
    DishServiceImpl dishService;

    @RequestMapping(
            value = {"listalldishes"},
            method = {RequestMethod.GET}
    )
    private Map<String, Object> queryAllDishes() {
        Map<String, Object> modelMap = new HashMap();
        List<Dish> list = this.dishService.queryAllDishes();
        modelMap.put("success", list);
        return modelMap;
    }

    @RequestMapping(
            value = {"listshopdishes"},
            method = {RequestMethod.GET}
    )
    private Map<String, Object> queryDihsesByShopId(Long account) {
        Map<String, Object> modelMap = new HashMap();
        List<Dish> dishes = this.dishService.queryDishesByShopId(account);
        modelMap.put("success",dishes);
        return modelMap;
    }
    @RequestMapping(
            value = {"listavaliabledishes"},
            method = {RequestMethod.GET}
    )
    private Map<String, Object> queryAvaliableDishes(Long account) {
        Map<String, Object> modelMap = new HashMap();
        List<Dish> dishes = this.dishService.queryAvaliableDishes(account);
        modelMap.put("success",dishes);
        return modelMap;
    }
    @RequestMapping(
            value = {"addDish"},
            method = {RequestMethod.POST},
            produces = {"application/json;charset=UTF-8"}
    )
    private Map<String, Object> addDish(@RequestBody(required = false) Dish dish) {
        Map<String, Object> data = new HashMap();
        data.put("success", this.dishService.addDish(dish));
        return data;
    }
}
