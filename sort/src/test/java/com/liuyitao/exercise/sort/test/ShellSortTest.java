package com.liuyitao.exercise.sort.test;

import com.liuyitao.exercise.sort.ShellSort.ShellSort;

/***
 *@Author: liuyitao
 *@CreateDate:12:06 PM 11/17/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class ShellSortTest extends AbstractSortTest {
    @Override
    protected void setSortorInSub() {
        setSortor(new ShellSort());
    }
}
