package com.liuyitao.exercise.calc.caculate.basecalc;

import com.liuyitao.exercise.calc.caculate.basecalc.impl.*;
import com.liuyitao.exercise.calc.model.enums.OperationEnum;
import com.liuyitao.exercise.exception.impl.IllegalOptionException;

import java.math.BigDecimal;

/***
 *@Author: liuyitao
 *@CreateDate:5:54 PM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class CalcHandler {

    public BigDecimal calc(BigDecimal num1, BigDecimal num2, OperationEnum operation) {
        BigDecimal res = null;
        switch (operation) {
            case ADD:
                res = new AddCalc(num1, num2).calc();
                break;
            case POW:
                res = new PowCalc(num1, num2).calc();
                break;
            case MINUS:
                res = new MinusCalc(num1,num2).calc();
                break;
            case TIMES:
                res = new TimesCalc(num1,num2).calc();
                break;
            case DIVIDE:
                res = new DivideCalc(num1,num2).calc();
                break;
            default:
                throw new IllegalOptionException("illegal option in OperationEnum!");

        }
        return res;
    }
}
