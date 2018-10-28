package com.liuyitao.exercise.calc.caculate.basecalc;

import java.math.BigDecimal;

/***
 *@Author: liuyitao
 *@CreateDate:12:49 AM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public abstract class AbstractCalc implements ICalc {

    private BigDecimal num1;

    private BigDecimal num2;

    public AbstractCalc(BigDecimal num1, BigDecimal num2) {
        this.num1 = num1;
        this.num2 = num2;
    }


    /***
     * 计算
2
     * @return
     */
    @Override
    public abstract BigDecimal calc();

    public BigDecimal getNum1() {
        return num1;
    }

    public void setNum1(BigDecimal num1) {
        this.num1 = num1;
    }

    public BigDecimal getNum2() {
        return num2;
    }

    public void setNum2(BigDecimal num2) {
        this.num2 = num2;
    }
}
