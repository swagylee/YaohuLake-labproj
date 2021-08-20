package com.example.demo.service;

import com.example.demo.entity.DishImage;
import com.example.demo.entity.DishImageVO;

import java.util.List;

public interface DishImageService {
    DishImage queryImagesByDishId(Long dishId);
    List<DishImage> queryAllDishImages();
    List<DishImageVO> queryAllDishImagesOfShop(Long shopId);
    boolean insertDishImage(DishImage image);
}
