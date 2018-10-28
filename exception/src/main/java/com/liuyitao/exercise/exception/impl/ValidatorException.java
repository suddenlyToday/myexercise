package com.liuyitao.exercise.exception.impl;

import com.liuyitao.exercise.exception.BaseException;

/***
 *@Author: liuyitao
 *@CreateDate:12:04 AM 10/28/2018
 *@DESC: 校验数据异常类
 *
 *
 ***/
public class ValidatorException extends BaseException {
    public ValidatorException(String msg) {
        super(msg);
    }

    public ValidatorException(Throwable e) {
        super(e);
    }
}
