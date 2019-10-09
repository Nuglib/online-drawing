package com.sdrc.onlinedrawing.service.Impl;

import com.sdrc.onlinedrawing.mapper.ImageMapper;
import com.sdrc.onlinedrawing.service.ImageService;
import com.sdrc.onlinedrawing.util.InfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
}