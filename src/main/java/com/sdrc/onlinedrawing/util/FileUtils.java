package com.sdrc.onlinedrawing.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public class FileUtils {

    /**
     * 获取文件后缀名
     * @return
     */
    public static String getFIleSuffix(String fileName){
        String[] strArray = fileName.split("\\.");
        int suffixIndex = strArray.length -1;
        return strArray[suffixIndex];
    }


    /**
     * 保存文件方法
     * @param multipartFile
     * @return
     */
    public static File saveFile(MultipartFile multipartFile){
        return null;
    }
}