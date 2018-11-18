package com.liuyitao.exercise.sort.test;

import com.liuyitao.exercise.sort.insertsort.InsertSort;

/***
 *@Author: liuyitao
 *@CreateDate:11:13 PM 11/16/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class InsertSortTest extends AbstractSortTest {

    @Override
    protected void setSortorInSub() {
        setSortor(new InsertSort());
    }
}
