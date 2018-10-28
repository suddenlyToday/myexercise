package com.liuyitao.exercise.calc.calccmd;

import com.google.inject.Guice;
import com.liuyitao.exercise.calc.calccmd.handler.IHandler;

/***
 *@Author: liuyitao
 *@CreateDate:10:27 PM 10/28/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class CalcCmdMain {

    public static void main(String[] args) {
        IHandler handler = Guice.createInjector(new GuiceModule()).getInstance(IHandler.class);

        handler.handle(args);
    }
}
