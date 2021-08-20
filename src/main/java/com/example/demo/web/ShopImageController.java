package com.example.demo.web;

import com.example.demo.entity.DishImage;
import com.example.demo.entity.Shop;
import com.example.demo.entity.ShopImage;
import com.example.demo.service.impl.ShopImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping({"/yhl"})
public class ShopImageController {
    @Autowired
    ShopImageServiceImpl service;
    @RequestMapping(
            value = {"listallshopimages"},
            method = {RequestMethod.GET}
    )
    private Map<String, Object> queryShops() {
        Map<String, Object> modelMap = new HashMap();
        List<ShopImage> list = this.service.queryAllShopImages();
        modelMap.put("success", list);
        return modelMap;
    }

    @RequestMapping(
            value = {"listoneshopimage"},
            method = {RequestMethod.GET}
    )
    private ShopImage queryUserByAccount(Long id) {
        ShopImage shop = this.service.queryImageByShopid(id);
        return shop;
    }
    @RequestMapping(
            value = {"/updateShopImg"},
            method = {RequestMethod.POST}
    )
    private Map<String, Object> upload(MultipartFile image,Long shopId) throws IOException {
        String UPLOAD_FOLDER = "/root/home/shopPics/";
        Map<String, Object> modelMap = new HashMap();
        if (image.isEmpty()) {
            String fail = "fail";
            modelMap.put(fail, "文件为空，请重新上传。");
            return modelMap;
        } else {
            try {
                byte[] bytes = image.getBytes();
                Path path = Paths.get(UPLOAD_FOLDER + "/");
                if (!Files.isWritable(path)) {
                    Files.createDirectories(path);
                }

                String originalFileName = image.getOriginalFilename();
                String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
                UUID uuid = UUID.randomUUID();
                String str = uuid.toString();
                String var10000 = str.substring(0, 8);
                String picname = var10000 + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
                String relativeAddr = path + "/" + picname + extension;
                OutputStream out = new FileOutputStream(relativeAddr);
                out.write(bytes);
                out.flush();
                out.close();
                String success = "success";
                String flag = "flag";
                String realAddr = "http://101.200.158.165:8080/shopImages/" + relativeAddr.substring(20);
                modelMap.put(success, relativeAddr);
                modelMap.put(flag, realAddr);
            } catch (Exception var17) {
                System.out.println(var17);
            }

            ShopImage image1 = new ShopImage((String)modelMap.get("flag"),shopId);
            this.service.insertShopImage(image1);
            modelMap.put("databaseSuccess", "true");
            return modelMap;
        }
    }
}
