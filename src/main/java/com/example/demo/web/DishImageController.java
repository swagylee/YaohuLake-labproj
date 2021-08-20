package com.example.demo.web;


import com.example.demo.entity.DishImage;
import com.example.demo.entity.DishImageVO;
import com.example.demo.entity.ShopImage;
import com.example.demo.service.impl.DishImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class DishImageController {
    @Autowired(required = false)
    DishImageServiceImpl service;
    @RequestMapping(
            value = {"listalldishimages"},
            method = {RequestMethod.GET}
    )
    private Map<String, Object> queryShops() {
        Map<String, Object> modelMap = new HashMap();
        List<DishImage> list = this.service.queryAllDishImages();
        modelMap.put("success", list);
        return modelMap;
    }

    @RequestMapping(
            value = {"listonedishimage"},
            method = {RequestMethod.GET}
    )
    private DishImage queryUserByAccount(Long id) {
        DishImage dish = this.service.queryImagesByDishId(id);
        return dish;
    }
    @RequestMapping(
            value = {"listalldishimagesofshop"},
            method = {RequestMethod.GET}
    )
    private Map<String, Object> queryImagesByShopId(Long id) {
        Map<String, Object> modelMap = new HashMap();
        List<DishImageVO> list = this.service.queryAllDishImagesOfShop(id);
        modelMap.put("success", list);
        return modelMap;
    }
    @RequestMapping(
            value = {"/updateImg"},
            method = {RequestMethod.POST}
    )
    private Map<String, Object> upload(MultipartFile image, Long dishId , Long shopId) throws IOException {
        String UPLOAD_FOLDER = "/root/home/dishPics/";
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
                String realAddr = "http://101.200.158.165:8080/dishImages/" + relativeAddr.substring(20);
                modelMap.put(success, relativeAddr);
                modelMap.put(flag, realAddr);
            } catch (Exception var17) {
                System.out.println(var17);
            }

            DishImage image1 = new DishImage((String)modelMap.get("flag"), dishId ,shopId);
            this.service.insertDishImage(image1);
            modelMap.put("databaseSuccess", "true");
            return modelMap;
        }
    }
}
