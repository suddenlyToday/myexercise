package com.liuyitao.exercise.sort.test;

import com.liuyitao.exercise.sort.bitvector.BitVectorSort;

/***
 *@Author: liuyitao
 *@CreateDate:10:01 PM 11/18/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class BitSortTest extends AbstractSortTest {
    @Override
    protected void setSortorInSub() {
        setSortor(new BitVectorSort(100));
    }
}