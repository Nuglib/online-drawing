package com.sdrc.onlinedrawing.service.Impl;

import com.sdrc.onlinedrawing.pojo.Image;
import com.sdrc.onlinedrawing.pojo.WrittenWord;
import com.sdrc.onlinedrawing.service.ImageService;
import com.sdrc.onlinedrawing.service.RandomImageWordService;
import com.sdrc.onlinedrawing.service.WrittenService;
import com.sdrc.onlinedrawing.util.InfoUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class RandomImageWordServiceImpl implements RandomImageWordService {

    @Resource
    public ImageService imageService;

    @Resource
    public WrittenService writtenService;

    /**
     * 获取随机图片和文字
     * @return
     */
    public InfoUtils getRandomImageWord() {
        Map objectObjectHashMap = new HashMap<>();
        InfoUtils infoUtils = new InfoUtils();
        Image image = this.imageService.getRandomImageInfo();
        WrittenWord writtenWord = this.writtenService.getRandomWrittenWord();
        if (!StringUtils.isEmpty(image)&&!StringUtils.isEmpty(writtenWord)){
            objectObjectHashMap.put("image",image);
            objectObjectHashMap.put("word",writtenWord);
            infoUtils.setObject(objectObjectHashMap);
            infoUtils.setaBoolean(true);
            infoUtils.setMessage("随机图文获取成功");
        }else{
            infoUtils.setMessage("随机图文获取失败");
            infoUtils.setaBoolean(false);
        }
        return infoUtils;
    }
}