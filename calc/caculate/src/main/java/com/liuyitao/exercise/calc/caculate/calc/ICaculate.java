package com.liuyitao.exercise.calc.caculate.calc;

import com.liuyitao.exercise.calc.model.ExpressionCalcResult;
import com.liuyitao.exercise.calc.model.ExpressionModel;

/***
 *@Author: liuyitao
 *@CreateDate:12:46 AM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public interface ICaculate {
    /***
     * 计算表达式，获取结果
     * @param expressionModel
     * @return
     */
    ExpressionCalcResult caculate(ExpressionModel expressionModel);
}
