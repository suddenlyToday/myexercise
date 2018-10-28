package com.liuyitao.exercise.common;

/***
 *@Author: liuyitao
 *@CreateDate:12:09 AM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public final class CharUtils {

    private CharUtils() {
    }

    public static boolean isCharNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isCharFloatNum(char c) {
        return isCharNum(c) || c == '.';
    }
}
