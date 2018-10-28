package com.liuyitao.exercise.calc;

/***
 *@Author: liuyitao
 *@CreateDate:12:38 AM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public interface ExpressionParse {
    /**
     * 算术表达式解析成波兰表达式
     * @param expression 表达式
     * @return 波兰表达式
     */
    String[] parse(String expression);
}
