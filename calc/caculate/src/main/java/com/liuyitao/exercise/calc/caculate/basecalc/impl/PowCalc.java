package com.liuyitao.exercise.calc.caculate.basecalc.impl;

import com.liuyitao.exercise.calc.caculate.basecalc.AbstractCalc;
import com.liuyitao.exercise.exception.impl.ValidatorException;

import java.math.BigDecimal;
import java.util.Objects;

/***
 *@Author: liuyitao
 *@CreateDate:5:06 PM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class PowCalc extends AbstractCalc {
    public PowCalc(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal calc() {
        if (!Objects.equals( new BigDecimal(getNum2().intValue()), getNum2()))
        {
            throw new ValidatorException("second number should be integer!");
        }
        return getNum1().pow(getNum2().intValue());
    }
}
