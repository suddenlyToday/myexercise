package com.liuyitao.exercise.calc.model;

import com.alibaba.fastjson.JSON;

/***
 *@Author: liuyitao
 *@CreateDate:12:19 AM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class ExpressionModel {
    private String originExpression;

    private String[] parsedExpression;

    private boolean valid;

    private String source;

    public String getOriginExpression() {
        return originExpression;
    }

    public void setOriginExpression(String originExpression) {
        this.originExpression = originExpression;
    }

    public String[] getParsedExpression() {
        return parsedExpression;
    }

    public void setParsedExpression(String[] parsedExpression) {
        this.parsedExpression = parsedExpression;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
