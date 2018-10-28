package com.liuyitao.exercise.calc.caculate.calc.impl;

import com.google.inject.Singleton;
import com.liuyitao.exercise.calc.caculate.basecalc.CalcHandler;
import com.liuyitao.exercise.calc.caculate.calc.ICaculate;
import com.liuyitao.exercise.calc.model.ExpressionCalcResult;
import com.liuyitao.exercise.calc.model.ExpressionModel;
import com.liuyitao.exercise.calc.model.enums.OperationEnum;
import com.liuyitao.exercise.common.StringUtils;
import com.liuyitao.exercise.exception.impl.IllegalOptionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Stack;

/***
 *@Author: liuyitao
 *@CreateDate:12:48 AM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
@Singleton
public class ExpressionCaculate implements ICaculate {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionCaculate.class);
    @Override
    public ExpressionCalcResult caculate(ExpressionModel expressionModel) {
        LOGGER.info("[ExpressionCaculate] caculate:{}",expressionModel);
        ExpressionCalcResult res = new ExpressionCalcResult();
        res.setExpressionModel(expressionModel);
        if (expressionModel.isValid()) {
            res.setRes(calc(expressionModel.getParsedExpression()));
            res.setCalcSuccess(true);
        } else {
            res.setCalcSuccess(false);
            res.setErrMsg("expression is invalid");
        }
        LOGGER.info("[ExpressionCaculate] caculate result:{}",res);
        return res;
    }

    private BigDecimal calc(String[] parsedExpression) {
        Stack<BigDecimal> stack = new Stack<>();

        for (int i = parsedExpression.length - 1; i >= 0; i--) {
            String s = parsedExpression[i];

            if (StringUtils.isAnNumStr(s)) {
                stack.push(new BigDecimal(s));
            } else if (s.length() == 1 && OperationEnum.isAnOperationChar(s.charAt(0))) {
                stack.push(calcNum(stack.pop(), stack.pop(), OperationEnum.forValue(s.charAt(0))));
            } else {
                throw new IllegalOptionException(String.format("invalid param %s in parsed expression!",s));
            }
        }

        return stack.pop();
    }

    private BigDecimal calcNum(BigDecimal num1, BigDecimal num2, OperationEnum operationEnum) {
        return new CalcHandler().calc(num1,num2,operationEnum);
    }
}
