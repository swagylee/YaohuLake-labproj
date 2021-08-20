package com.example.demo.dao;

import com.example.demo.entity.DishImage;
import com.example.demo.entity.DishImageVO;

import java.util.List;

public interface DishImageDao {
    DishImage queryImagesByDishId(Long dishId);
    List<DishImage> queryAllDishImages();
//    List<DishImage> queryAllDishImagesOfShop1(Long shopId);
    List<DishImageVO> queryAllDishImagesOfShop(Long shopId);
    int insertDishImage(DishImage image);
}
