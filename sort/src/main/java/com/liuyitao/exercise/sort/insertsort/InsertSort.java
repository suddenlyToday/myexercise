package com.liuyitao.exercise.sort.insertsort;

import com.liuyitao.exercise.sort.AbstractSort;

import java.util.Objects;

/***
 *@Author: liuyitao
 *@CreateDate:8:55 AM 11/16/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class InsertSort extends AbstractSort {

    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        if (Objects.isNull(array)) {
            throw new IllegalArgumentException("wrong array param");
        }
        int j;
        for (int i = 0; i < array.length; i++) {
            AnyType temp = array[i];
            for (j = i; j > 0 && temp.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    @Override
    public void sort(int[] intArray) {
        super.sort(intArray);
        int j;
        for (int i = 0; i < intArray.length; i++) {
            int temp = intArray[i];
            for (j = i; j > 0 && temp < intArray[j - 1]; j--) {
                intArray[j] = intArray[j - 1];
            }
            intArray[j] = temp;
        }
    }

    public static void main(String[] args) {
        new InsertSort().test();
    }

}
