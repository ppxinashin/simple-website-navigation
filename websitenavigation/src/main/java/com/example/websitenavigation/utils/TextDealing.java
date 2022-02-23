package com.example.websitenavigation.utils;

import org.springframework.util.DigestUtils;

public class TextDealing {

    private static final String slat = "&%5123***&&%%$$#@";

    /**
     * MD5生成器
     * @param str 想要转为MD5的文本
     * @return MD5码
     */

    public static String getTheMD5Code(String str){
        String base = str + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }


}
