package com.sdrc.onlinedrawing.util;

/**
 * 图片操作Utils
 */
public class ImageUtils {

    //校验上传文件格式是否是图片
    public static Boolean checkImageFormat(String fileName){
        Boolean aBoolean = false;
        String subSuffix = FileUtils.getFIleSuffix(fileName);
        String[] imageSuffix = {"jpg","png","jpeg","bmp","gif","tiff"};
        for (int i = 0; i < imageSuffix.length; i++) {
            if (subSuffix.equals(imageSuffix[i])){
                aBoolean = true;
            }
        }
        return aBoolean;
    }
}