package com.sdrc.onlinedrawing.controller;

import com.sdrc.onlinedrawing.util.InfoUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("uploadimageController")
@Api(value = "上传图片Controller")
public class UploadImagesController {

   /* @Resource
    private UploadImageService uploadImageService;*/

    @RequestMapping(value = "customerUpload",method = RequestMethod.POST)
    @ApiOperation(value = "客户上传图片进行自定义")
    public InfoUtils customerUploadImages(@RequestParam(value = "images",required = false) MultipartFile[] files,
                                          @RequestParam(value = "userId",required = false) String userId){
        //this.uploadImageService.uploadCustomerImage(files)
        return null;
    }
}