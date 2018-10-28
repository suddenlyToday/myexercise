package com.liuyitao.exercise.exception.impl;

import com.liuyitao.exercise.exception.BaseException;

/***
 *@Author: liuyitao
 *@CreateDate:12:06 AM 10/28/2018
 *@DESC: 非法选项异常
 *
 *
 *@Modify:
 ***/
public class IllegalOptionException extends BaseException {
    public IllegalOptionException(String msg) {
        super(msg);
    }

    public IllegalOptionException(Throwable e) {
        super(e);
    }
}
