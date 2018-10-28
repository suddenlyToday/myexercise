package com.liuyitao.exercise.calc.model;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;

/***
 *@Author: liuyitao
 *@CreateDate:12:23 AM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class ExpressionCalcResult {
    private ExpressionModel expressionModel;

    private boolean calcSuccess;

    private BigDecimal res;

    private String errMsg;

    public ExpressionModel getExpressionModel() {
        return expressionModel;
    }

    public void setExpressionModel(ExpressionModel expressionModel) {
        this.expressionModel = expressionModel;
    }

    public boolean isCalcSuccess() {
        return calcSuccess;
    }

    public void setCalcSuccess(boolean calcSuccess) {
        this.calcSuccess = calcSuccess;
    }

    public BigDecimal getRes() {
        return res;
    }

    public void setRes(BigDecimal res) {
        this.res = res;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
