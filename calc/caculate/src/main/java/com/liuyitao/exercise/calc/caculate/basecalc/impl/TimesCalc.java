package com.liuyitao.exercise.calc.caculate.basecalc.impl;

import com.liuyitao.exercise.calc.caculate.basecalc.AbstractCalc;

import java.math.BigDecimal;

/***
 *@Author: liuyitao
 *@CreateDate:5:15 PM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class TimesCalc extends AbstractCalc {
    public TimesCalc(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal calc() {
        return getNum1().multiply(getNum2());
    }
}
