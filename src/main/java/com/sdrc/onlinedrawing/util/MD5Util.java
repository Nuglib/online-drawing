package com.sdrc.onlinedrawing.util;

import java.security.MessageDigest;
import java.util.UUID;

public class MD5Util {

    /**
     * 生成随机数作为盐值
     * @return
     */
    public static String saltEncode(){
        return UUID.randomUUID().toString().substring(0,5);
    }

    /**
     * 对字符串进行加密
     * @param inStr
     * @return
     * @throws Exception
     */
    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}