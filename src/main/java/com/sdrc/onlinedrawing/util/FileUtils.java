package com.sdrc.onlinedrawing.util;

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
}