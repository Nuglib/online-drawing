package com.sdrc.onlinedrawing.controller;

import com.sdrc.onlinedrawing.service.RandomImageWordService;
import com.sdrc.onlinedrawing.util.InfoUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("randomController")
@Api(value = "随机生成Controller")
public class RandomImageWord {


    @Resource
    public RandomImageWordService randomImageWordService;

    @RequestMapping(value = "getrandomimageword",method = RequestMethod.GET)
    @ApiOperation(value = "随机生成")
    public InfoUtils RandomImageWord(){
        return this.randomImageWordService.getRandomImageWord();
    }
}
