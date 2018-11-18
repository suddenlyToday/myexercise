package com.liuyitao.exercise.sort.test;

import com.liuyitao.exercise.common.ArrayUtils;
import com.liuyitao.exercise.sort.ShellSort.ShellSort;
import com.liuyitao.exercise.sort.bitvector.BitVectorSort;
import com.liuyitao.exercise.sort.insertsort.InsertSort;
import org.junit.Before;
import org.junit.Test;

/***
 *@Author: liuyitao
 *@CreateDate:10:11 PM 11/18/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class SortTest {
    private final static int RANGE = 10000000;
    private ClacTimeSort clacTimeInsertSort;
    private ClacTimeSort clacTimeShelltSort;
    private ClacTimeSort clacTimeBitSort;
    private int[] intArray;

    @Test
    public void test() throws InterruptedException {
        int[] array1 = new int[intArray.length];
        int[] array2 = new int[intArray.length];
        int[] array3 = new int[intArray.length];

        System.arraycopy(intArray, 0 , array1, 0 ,intArray.length);
        System.arraycopy(intArray, 0 , array2, 0 ,intArray.length);
        System.arraycopy(intArray, 0 , array3, 0 ,intArray.length);

        new Thread(()->clacTimeBitSort.sort(array1),"bit").start();
        new Thread(()->clacTimeInsertSort.sort(array2),"insert").start();
        new Thread(()->clacTimeShelltSort.sort(array3),"shell").start();
        Thread.sleep(1000000);
    }

    @Before
    public void init()
    {
        clacTimeBitSort= new ClacTimeSort(new BitVectorSort(RANGE));
        clacTimeInsertSort = new ClacTimeSort(new InsertSort());
        clacTimeShelltSort = new ClacTimeSort(new ShellSort());
        intArray = ArrayUtils.createIntArrayWithNotDuplicatedValue(RANGE, 5000000);
    }
}
