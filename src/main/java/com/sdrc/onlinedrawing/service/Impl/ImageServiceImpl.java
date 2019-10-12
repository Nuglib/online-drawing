package com.sdrc.onlinedrawing.service.Impl;

import com.sdrc.onlinedrawing.mapper.ImageMapper;
import com.sdrc.onlinedrawing.pojo.Image;
import com.sdrc.onlinedrawing.service.ImageService;
import com.sdrc.onlinedrawing.util.InfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {


    private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageMapper imageMapper;

    //获取轮播图片
    @Override
    public InfoUtils getBannerImage() {
        InfoUtils infoUtils = new InfoUtils();
        try {
            infoUtils.setObject(this.imageMapper.selectBannerImage());
        } catch (Exception e) {
            logger.error("获取轮播图片报错");
            e.printStackTrace();
        }
        if (!StringUtils.isEmpty(infoUtils.getObject())){
            infoUtils.setaBoolean(true);
            infoUtils.setMessage("正常返回");
            return infoUtils;
        }else{
            infoUtils.setaBoolean(false);
            return infoUtils;
        }
    }

    /**
     * 获取最新轮播图
     * @return
     */
    @Override
    public InfoUtils getNewEstImage() {
        InfoUtils infoUtils = new InfoUtils();
        try {
            infoUtils.setObject(this.imageMapper.selectNewEstImage());
        } catch (Exception e) {
            logger.error("查询最新图片错误");
            e.printStackTrace();
        }
        if (!StringUtils.isEmpty(infoUtils.getObject())){
            infoUtils.setaBoolean(true);
            infoUtils.setMessage("最新图片获取成功!");
        }else{
            infoUtils.setMessage("最新图片获取失败");
            infoUtils.setaBoolean(false);
        }
        return infoUtils;
    }

    /**
     * 获取最热轮播图
     * @return
     */
    public InfoUtils getHotImageInfo() {
        InfoUtils infoUtils = new InfoUtils();
        try {
            infoUtils.setObject(this.imageMapper.selectHotImageInfo());
        } catch (Exception e) {
            logger.error("查询最热轮播图报错");
            e.printStackTrace();
        }
        if (!StringUtils.isEmpty(infoUtils.getObject())){
            infoUtils.setaBoolean(true);
            infoUtils.setMessage("获取最热轮播图成功");
        }else{
            infoUtils.setaBoolean(false);
            infoUtils.setMessage("获取最热轮播图失败");
        }
        return infoUtils;
    }

    /**
     * 随机获取图片
     * @return
     */
    public Image getRandomImageInfo() {
        Image image = null;
        try {
             image = this.imageMapper.selectRandomImage();
        } catch (Exception e) {
            logger.error("获取随机图片错误");
            e.printStackTrace();
        }
        return image;
    }

    /**
     * 获取风格元素
     * @return
     */
    public InfoUtils getStyleElementsGroup() {
        InfoUtils infoUtils = new InfoUtils();
        Boolean aBoolean = true;
        HashMap hashMap = new HashMap();
        Image[] imagesSs = null;
        Image[] imagesYm = null;
        Image[] imagesFj = null;
        Image[] imagesSy = null;

        try {
            imagesSs = this.imageMapper.selectStyleElementGroup("ss");
            imagesYm =this.imageMapper.selectStyleElementGroup("ym");
            imagesFj = this.imageMapper.selectStyleElementGroup("fj");
            imagesSy = this.imageMapper.selectStyleElementGroup("sy");
        } catch (Exception e) {
            aBoolean = false;
            infoUtils.setMessage("获取风格图片失败");
            infoUtils.setaBoolean(false);
            logger.error("获取风格图片失败");
            e.printStackTrace();
        }

       if (aBoolean){
           if (imagesSs.length!=0&&!StringUtils.isEmpty(imagesSs)){
               hashMap.put("ss",imagesSs);
           }
           if (imagesYm.length!=0&&!StringUtils.isEmpty(imagesYm)){
               hashMap.put("ym",imagesYm);
           }

           if (imagesFj.length != 0 && !StringUtils.isEmpty(imagesFj)){
               hashMap.put("fj",imagesFj);
           }

           if (imagesSy.length!=0 && !StringUtils.isEmpty(imagesSy)){
               hashMap.put("sy",imagesSy);
           }
           infoUtils.setaBoolean(true);
           infoUtils.setMessage("获取成功");
           infoUtils.setObject(hashMap);
       }
        return infoUtils;
    }
}