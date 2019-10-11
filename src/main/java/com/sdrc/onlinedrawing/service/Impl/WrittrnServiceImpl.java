package com.sdrc.onlinedrawing.service.Impl;

import com.sdrc.onlinedrawing.mapper.WrittenMapper;
import com.sdrc.onlinedrawing.service.WrittenService;
import com.sdrc.onlinedrawing.util.InfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

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
}