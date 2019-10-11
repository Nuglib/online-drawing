package com.sdrc.onlinedrawing.controller;

import com.sdrc.onlinedrawing.service.WrittenService;
import com.sdrc.onlinedrawing.util.InfoUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("writtController")
@Api(value = "文字接口文档")
public class WrittenController {

    @Resource
    private WrittenService writtenService;

    @RequestMapping(value = "getnewword",method = RequestMethod.GET)
    @ApiOperation(value = "获取最新文字")
    public InfoUtils getNewWrittenWord(){
        return this.writtenService.getNewWrittenWord();
    }

    @RequestMapping(value = "gethotword",method = RequestMethod.GET)
    @ApiOperation(value = "获取最热文字")
    public InfoUtils getHotWrittenWord(){
        return this.writtenService.getHotWrittenWord();
    }
}