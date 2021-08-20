package com.example.demo.service.impl;

import com.example.demo.dao.ShopImageDao;
import com.example.demo.entity.ShopImage;
import com.example.demo.service.ShopImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShopImageServiceImpl implements ShopImageService {
    @Autowired
    ShopImageDao imageDao;
    @Override
    public List<ShopImage> queryAllShopImages() {
        return imageDao.queryAllShopImages();
    }

    @Override
    public ShopImage queryImageByShopid(Long account) {
        ShopImage shopImage;
        shopImage = imageDao.queryImageByShopid(account);
        if(shopImage == null) {
            throw new RuntimeException("无法找到该商店的封面图片！！");
        }else {
            return shopImage;
        }
    }

    @Transactional
    public boolean insertShopImage(ShopImage shopImage) {
        if (shopImage.getImageAddr() != null && !"".equals(shopImage.getImageAddr())) {
            try {
                int effectedNum = imageDao.insertShopImage(shopImage);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("加入店铺照片失败!");
                }
            } catch (Exception var3) {
                throw new RuntimeException("加入店铺照片失败" + var3.getMessage());
            }
        } else {
            throw new RuntimeException("店铺照片不能为空");
        }
    }
}
