package com.example.demo.service.impl;


import com.example.demo.dao.DishImageDao;
import com.example.demo.entity.Dish;
import com.example.demo.entity.DishImage;
import com.example.demo.entity.DishImageVO;
import com.example.demo.service.DishImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DishImageServiceImpl implements DishImageService {

    @Autowired
    DishImageDao dishImageDao;
    @Override
    public DishImage queryImagesByDishId(Long dishId) {
        DishImage dishImage = dishImageDao.queryImagesByDishId(dishId);
        if(dishImage == null){
            throw new RuntimeException("无法找到此菜品的图片");
        }
        return dishImage;
    }

    @Transactional
    public boolean insertDishImage(DishImage image) {
        if (image.getImageAddr() != null && !"".equals(image.getImageAddr())) {
            try {
                int effectedNum = dishImageDao.insertDishImage(image);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("加入商品照片失败!");
                }
            } catch (Exception var3) {
                throw new RuntimeException("加入商品照片失败" + var3.getMessage());
            }
        } else {
            throw new RuntimeException("商品照片不能为空");
        }
    }

    @Override
    public List<DishImage> queryAllDishImages() {
        return dishImageDao.queryAllDishImages();
    }

    @Override
    public List<DishImageVO> queryAllDishImagesOfShop(Long shopId) {
        List<DishImageVO> dishImages = dishImageDao.queryAllDishImagesOfShop(shopId);
        if(dishImages.size() == 0 ){
            throw new RuntimeException("找不到该商店的菜品图片");
        }
        return dishImages;
    }
}
