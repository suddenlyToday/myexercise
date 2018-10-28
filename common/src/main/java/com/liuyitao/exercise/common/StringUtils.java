package com.liuyitao.exercise.common;

import java.util.Objects;

/***
 *@Author: liuyitao
 *@CreateDate:5:37 PM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public final class StringUtils {

    /****
     * 判断一个字符串是不是数字
     * @param str str
     * @return boolean
     */
    public static boolean isAnNumStr(String str){
        if (Objects.isNull(str) || str.trim().isEmpty())
        {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if(!CharUtils.isCharFloatNum(str.charAt(i)))
            {
                return false;
            }
        }
        return str.indexOf('.') == str.lastIndexOf('.');
    }
}
