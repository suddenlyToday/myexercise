package com.liuyitao.exercise.calc.calccmd.handler;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.liuyitao.exercise.calc.ExpressionParse;
import com.liuyitao.exercise.calc.caculate.calc.ICaculate;
import com.liuyitao.exercise.calc.model.ExpressionCalcResult;
import com.liuyitao.exercise.calc.model.ExpressionModel;
import com.liuyitao.exercise.exception.BaseException;

/***
 *@Author: liuyitao
 *@CreateDate:10:29 PM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
@Singleton
public class ExpressionsHandler implements IHandler{

    @Inject
    private ICaculate caculater;

    @Inject
    private ExpressionParse expressionParser;

    @Override
    public void handle(String[] args) {
        for (String arg : args) {
            try {
                ExpressionModel model = createExpressionModel(arg);
                ExpressionCalcResult res = caculater.caculate(model);
                if (res.isCalcSuccess()) {
                    System.out.printf("%s = %s\n", res.getExpressionModel().getOriginExpression(), res.getRes());
                } else {
                    System.out.printf("%s = %s\n", res.getExpressionModel().getOriginExpression(), res.getErrMsg());
                }
            }catch (BaseException e)
            {
                System.out.printf("%s error: %s\n",arg,e.getMsg());
            }catch (Exception e)
            {
                System.out.printf("%s error: %s\n",arg,e.getMessage());
            }
        }
    }

    private ExpressionModel createExpressionModel(String arg) {
        ExpressionModel model = new ExpressionModel();
        model.setOriginExpression(arg);
        try {
            model.setParsedExpression(expressionParser.parse(arg));
            model.setValid(true);
        }catch (Exception e)
        {
            model.setValid(false);
        }
        model.setSource("cmd");
        return model;
    }
}
