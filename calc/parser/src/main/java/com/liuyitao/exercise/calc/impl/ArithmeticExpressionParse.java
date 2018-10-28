package com.liuyitao.exercise.calc.impl;

import com.google.inject.Singleton;
import com.liuyitao.exercise.calc.ExpressionParse;
import com.liuyitao.exercise.calc.model.enums.OperationEnum;
import com.liuyitao.exercise.common.CharUtils;
import com.liuyitao.exercise.exception.impl.ValidatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

/***
 *@author : liuyitao
 *@createDate: 12:42 AM 10/28/2018
 *@desc:
 *初始化两个栈:运算符栈s1，储存中间结果的栈s2
 * 从右至左扫描中缀表达式
 * 遇到操作数时，将其压入s2
 * 遇到运算符时，比较其与s1栈顶运算符的优先级
 * 如果s1为空，或栈顶运算符为右括号“)”，则直接将此运算符入栈
 * 否则，若优先级比栈顶运算符的较高或相等，也将运算符压入s1
 * 否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较
 * 遇到括号时
 * 如果是右括号“)”，则直接压入s1
 * 如果是左括号“(”，则依次弹出S1栈顶的运算符，并压入S2，直到遇到右括号为止，此时将这一对括号丢弃
 * 重复步骤2至5，直到表达式的最左边
 * 将s1中剩余的运算符依次弹出并压入s2
 * 依次弹出s2中的元素并输出，结果即为中缀表达式对应的前缀表达式
 *
 ***/
@Singleton
public class ArithmeticExpressionParse implements ExpressionParse {
    private static final char LEFT_BRA = '(';
    private static final char RIGHT_BRA = ')';
    private static final Logger LOGGER = LoggerFactory.getLogger(ArithmeticExpressionParse.class);

    @Override
    public String[] parse(String expression) {

        LOGGER.info("[ArithmeticExpressionParse] parse expression:{}", expression);
        expression = preHandle(expression);
        validateExpression(expression);
        return parseExpression(expression);
    }

    private String[] parseExpression(String expression) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for (int i = expression.length()-1; i >=0; i--) {
            char c = expression.charAt(i);
            if (CharUtils.isCharFloatNum(c))
            {
                StringBuilder sb = new StringBuilder(c+"");
                while(i-1>=0&&CharUtils.isCharFloatNum(expression.charAt(i-1)))
                {
                    i--;
                    sb.append(expression.charAt(i));
                }
                stack2.push(sb.toString());
            }
            else if(c == LEFT_BRA)
            {
                while (!stack1.isEmpty())
                {
                    if(Objects.equals(stack1.peek(),RIGHT_BRA+""))
                    {
                        stack1.pop();
                    }
                    else
                        {
                        stack2.push(stack1.pop());
                    }
                }
            }
            else if(c == RIGHT_BRA)
            {
                stack1.push(c+"");
            }
            else if(OperationEnum.isAnOperationChar(c))
            {
                while(true) {
                    if (stack1.isEmpty() || Objects.equals(stack1.peek(), RIGHT_BRA + "")) {
                        stack1.push(c + "");
                        break;
                    } else if (OperationEnum.forValue(c).isPrirityBiggerThan(OperationEnum.forValue(stack1.peek().charAt(0)))
                            || OperationEnum.forValue(c).isPrirityEqualThan(OperationEnum.forValue(stack1.peek().charAt(0)))) {
                        stack1.push(c + "");
                        break;
                    }else {
                        stack2.push(stack1.pop());
                    }
                }
            }
            else
            {
                throw new ValidatorException(String.format("invalid char %s in expression!", c));
            }
        }
        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
        String[] res = new String[stack2.size()];
        int i=0;
        while(!stack2.isEmpty())
        {
            res[i] = stack2.pop();
            i++;
        }
        LOGGER.info("[ArithmeticExpressionParse]parse result:{}",Arrays.toString(res));
        return res;
    }

    private String preHandle(String expression) {
        if(Objects.isNull(expression)||expression.trim().isEmpty())
        {
            throw new ValidatorException("expression can not be null");
        }
        return expression.replace(" ","");
    }

    private void validateExpression(String expression) {
        for (char c : expression.toCharArray()) {
            if ((!CharUtils.isCharFloatNum(c))
                    && (!Arrays.asList(LEFT_BRA, RIGHT_BRA).contains(c))
                    && !OperationEnum.isAnOperationChar(c)) {
                throw new ValidatorException("inlvalid char in expression!");
            }
        }
    }
}
