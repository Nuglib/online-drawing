package com.sdrc.onlinedrawing.controller;

import com.sdrc.onlinedrawing.service.ImageService;
import com.sdrc.onlinedrawing.util.InfoUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("imageController")
@Api(value = "图片接口文档")
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Resource
    private ImageService imageService;

    @RequestMapping(value = "getimagebanner",method = RequestMethod.GET)
    @ApiOperation(value = "获取banner轮播图片")
    public InfoUtils image(){
        return this.imageService.getBannerImage();
    }

    @RequestMapping(value = "getnewestimage",method = RequestMethod.GET)
    @ApiOperation(value = "获取最新轮播图")
    public InfoUtils newestImage(){
        return this.imageService.getNewEstImage();
    }

    @RequestMapping(value = "getnewhotimages",method = RequestMethod.GET)
    @ApiOperation(value = "获取最热轮播图")
    public InfoUtils newHotImage(){
        return this.imageService.getHotImageInfo();
    }

    @RequestMapping(value = "getimagestyleelement",method = RequestMethod.GET)
    @ApiOperation(value = "获取风格元素")
    public InfoUtils getStyleElementsGroupBy(){
        return this.imageService.getStyleElementsGroup();
    }
}