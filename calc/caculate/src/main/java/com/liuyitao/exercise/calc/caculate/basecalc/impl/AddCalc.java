package com.liuyitao.exercise.calc.caculate.basecalc.impl;

import com.liuyitao.exercise.calc.caculate.basecalc.AbstractCalc;

import java.math.BigDecimal;

/***
 *@Author: liuyitao
 *@CreateDate:12:53 AM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class AddCalc extends AbstractCalc {
    public AddCalc(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal calc() {
        return getNum1().add(getNum2());
    }
}
