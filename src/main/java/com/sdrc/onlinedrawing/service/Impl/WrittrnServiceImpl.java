package com.sdrc.onlinedrawing.service.Impl;

import com.sdrc.onlinedrawing.mapper.WrittenMapper;
import com.sdrc.onlinedrawing.pojo.WrittenWord;
import com.sdrc.onlinedrawing.service.WrittenService;
import com.sdrc.onlinedrawing.util.InfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class WrittrnServiceImpl implements WrittenService {
    private static final Logger logger = LoggerFactory.getLogger(WrittrnServiceImpl.class);
    @Resource
    private WrittenMapper writtenMapper;

    /**
     * 获取最新文字
     * @return
     */
    public InfoUtils getNewWrittenWord() {
        InfoUtils infoUtils = new InfoUtils();
        try {
            infoUtils.setObject(this.writtenMapper.selectNewWrittenWord());
        } catch (Exception e) {
            logger.error("获取最新文字失败");
            e.printStackTrace();
        }
        if (!StringUtils.isEmpty(infoUtils.getObject())){
            infoUtils.setaBoolean(true);
            infoUtils.setMessage("获取最新文字成功");
        }else{
            infoUtils.setaBoolean(false);
            infoUtils.setMessage("服务器内部错误");
        }
        return infoUtils;
    }

    /**
     * 获取最热文字
     * @return
     */
    public InfoUtils getHotWrittenWord() {
        InfoUtils infoUtils = new InfoUtils();
        try {
            infoUtils.setObject(this.writtenMapper.selectHotWrittenWord());
        } catch (Exception e) {
            logger.error("获取最热文字出错");
            e.printStackTrace();
        }
        if (!StringUtils.isEmpty(infoUtils.getObject())){
            infoUtils.setaBoolean(true);
            infoUtils.setMessage("获取最热文字成功");
        }else{
            infoUtils.setaBoolean(false);
            infoUtils.setMessage("服务器内部错误");
        }
        return infoUtils;
    }

    /**
     * 获取随机文字
     * @return
     */
    public WrittenWord getRandomWrittenWord() {
        WrittenWord writtenWord = null;

        try {
            writtenWord = this.writtenMapper.selectRandomWrittenWord();
        } catch (Exception e) {
            logger.error("查询随机文字报错");
            e.printStackTrace();
        }
        return writtenWord;
    }

    /**
     * 获取文字风格元素
     * @return
     */
    public InfoUtils getWrittenWordStyleElement() {
        InfoUtils infoUtils = new InfoUtils();
        HashMap hashMap = new HashMap();
        WrittenWord[] writtenWordsSs=null;
        WrittenWord[] writtenWordsYm=null;
        WrittenWord[] writtenWordsFj=null;
        WrittenWord[] writtenWordsSy=null;
        Boolean aBoolean = true;
        try {
            writtenWordsSs = this.writtenMapper.selectWrittenWordStyleElementBylabel("ss");
            writtenWordsYm = this.writtenMapper.selectWrittenWordStyleElementBylabel("ym");
            writtenWordsFj = this.writtenMapper.selectWrittenWordStyleElementBylabel("fj");
            writtenWordsSy = this.writtenMapper.selectWrittenWordStyleElementBylabel("sy");
        } catch (Exception e) {
            logger.error("获取文字风格元素失败");
            infoUtils.setMessage("获取文字风格元素失败");
            infoUtils.setaBoolean(true);
            aBoolean = false;
            e.printStackTrace();
        }

        if (aBoolean){
            if (writtenWordsSs.length != 0 && !StringUtils.isEmpty(writtenWordsSs)){
                hashMap.put("ss",writtenWordsSs);
            }
            if (writtenWordsYm.length != 0 && !StringUtils.isEmpty(writtenWordsYm)){
                hashMap.put("ym",writtenWordsYm);
            }
            if (writtenWordsFj.length != 0 && !StringUtils.isEmpty(writtenWordsFj)){
                hashMap.put("fj",writtenWordsFj);
            }
            if (writtenWordsSy.length != 0 && !StringUtils.isEmpty(writtenWordsSy)){
                hashMap.put("sy",writtenWordsSy);
            }
            infoUtils.setaBoolean(true);
            infoUtils.setMessage("文字风格获取成功");
            infoUtils.setObject(hashMap);
        }
        return infoUtils;
    }
}