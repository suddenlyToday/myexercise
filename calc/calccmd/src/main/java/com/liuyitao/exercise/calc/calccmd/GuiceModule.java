package com.liuyitao.exercise.calc.calccmd;

import com.google.inject.AbstractModule;
import com.liuyitao.exercise.calc.ExpressionParse;
import com.liuyitao.exercise.calc.caculate.calc.ICaculate;
import com.liuyitao.exercise.calc.caculate.calc.impl.ExpressionCaculate;
import com.liuyitao.exercise.calc.calccmd.handler.ExpressionsHandler;
import com.liuyitao.exercise.calc.calccmd.handler.IHandler;
import com.liuyitao.exercise.calc.impl.ArithmeticExpressionParse;

/***
 *@Author: liuyitao
 *@CreateDate:11:13 PM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ICaculate.class).to(ExpressionCaculate.class);
        bind(ExpressionParse.class).to(ArithmeticExpressionParse.class);
        bind(IHandler.class).to(ExpressionsHandler.class);
    }
}
