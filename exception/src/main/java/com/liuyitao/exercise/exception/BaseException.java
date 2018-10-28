package com.liuyitao.exercise.exception;

/***
 *@Author: liuyitao
 *@CreateDate: 12:01 AM 10/28/2018
 *@DESC: 异常基类
 *
 *
 ***/
public abstract class BaseException extends RuntimeException {

    private String msg;

    public BaseException(String msg) {
        super();
        this.msg = msg;
    }

    public BaseException(Throwable e) {
        super(e);
        if (e instanceof BaseException) {
            this.msg = ((BaseException) e).getMsg();
        } else {
            this.msg = e.getMessage();
        }
    }

    public String getMsg() {
        return msg;
    }
}
