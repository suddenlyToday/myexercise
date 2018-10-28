package com.liuyitao.exercise.calc.caculate.basecalc.impl;

import com.liuyitao.exercise.calc.caculate.basecalc.AbstractCalc;

import java.math.BigDecimal;

/***
 *@Author: liuyitao
 *@CreateDate:5:17 PM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class MinusCalc extends AbstractCalc {
    public MinusCalc(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal calc() {
        return getNum1().subtract(getNum2());
    }
}
