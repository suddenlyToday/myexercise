package com.liuyitao.exercise.sort.test;

import com.liuyitao.exercise.sort.ISort;

/***
 *@Author: liuyitao
 *@CreateDate:10:08 PM 11/18/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class ClacTimeSort implements ISort {

    private final ISort iSort;

    public ClacTimeSort(ISort iSort)
    {
        if (iSort instanceof ClacTimeSort)
        {
            throw new IllegalArgumentException("invalid iSort!");
        }
        this.iSort = iSort;
    }

    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {

        long start = System.currentTimeMillis();
        iSort.sort(array);
        System.out.println("spend time " + (System.currentTimeMillis() - start) +" ms");

    }

    @Override
    public void sort(int[] intArray) {
        long start = System.currentTimeMillis();
        iSort.sort(intArray);
        System.out.println(Thread.currentThread().getName()+": spend time " + (System.currentTimeMillis() - start) +" ms");
    }
}
