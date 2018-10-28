package com.liuyitao.exercise.calc.caculate.basecalc.impl;

import com.liuyitao.exercise.calc.caculate.basecalc.AbstractCalc;
import com.liuyitao.exercise.exception.impl.ValidatorException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/***
 *@Author: liuyitao
 *@CreateDate:5:13 PM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class DivideCalc extends AbstractCalc {

    private static final int SAVE_COUNT_NUMBER_AFTER_DOT = 10;

    public DivideCalc(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal calc() {
        if (Objects.equals(getNum2(), (new BigDecimal(0))))
        {
            throw new ValidatorException("can't divide zero!");
        }
        return getNum1().divide(getNum2(), SAVE_COUNT_NUMBER_AFTER_DOT, RoundingMode.HALF_UP);
    }
}
