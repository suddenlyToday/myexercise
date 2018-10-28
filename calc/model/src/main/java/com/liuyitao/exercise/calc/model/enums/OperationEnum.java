package com.liuyitao.exercise.calc.model.enums;

import java.util.Objects;

/***
 *@Author: liuyitao
 *@CreateDate:12:24 AM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public enum OperationEnum {

    /**
     * 加法
     */
    ADD('+',1),
    MINUS('-',1),
    TIMES('*',2),
    DIVIDE('/',2),
    POW('^',4);

    /**
     * 操作符
     */
    private final char operatorChar;
    /***
     * 优先级
     */
    private final int priority;

    OperationEnum(char c, int priority) {
        this.operatorChar = c;
        this.priority = priority;
    }

    /**
     * 返回字符对应的操作枚举
     *
     * @param c char
     * @return OperationEnum
     */
    public static OperationEnum forValue(char c) {
        for (OperationEnum value : OperationEnum.values()) {
            if (value.operatorChar == c) {
                return value;
            }
        }
        return null;
    }

    public boolean isPrirityBiggerThan(OperationEnum operationEnum) {
        return this.priority - operationEnum.priority > 0;
    }

    public boolean isPrirityEqualThan(OperationEnum operationEnum) {
        return this.priority == operationEnum.priority;
    }

    /***
     * 判断字符是不是操作符
     * @param c char
     * @return boolean
     */
    public static boolean isAnOperationChar(char c) {
        return Objects.nonNull(forValue(c));
    }

}
