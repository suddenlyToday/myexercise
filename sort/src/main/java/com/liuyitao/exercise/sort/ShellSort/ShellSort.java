package com.liuyitao.exercise.sort.ShellSort;

import com.liuyitao.exercise.sort.AbstractSort;

import java.util.Objects;

/***
 *@Author: liuyitao
 *@CreateDate:10:33 AM 11/17/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class ShellSort extends AbstractSort {
    private final static int[] SHELL_GAP = {20007,5933,1777,803,307, 109, 41, 19, 5, 1};

    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        if (Objects.isNull(array)) {
            throw new IllegalArgumentException("wrong param array");
        }

        int k;
        for(int gap : SHELL_GAP){
//        for (int gap = array.length/2; gap >=1 ;gap/=2) {
            for (int j = gap; j < array.length; j++) {
                AnyType temp = array[j];
                for (k = j; k > gap-1; k -= gap) {
                    if (temp.compareTo(array[k - gap]) < 0) {
                        array[k] = array[k - gap];
                    } else {
                        break;
                    }
                }
                array[k] = temp;
            }
        }
    }

    @Override
    public void sort(int[] intArray) {
        super.sort(intArray);
        int j;
        for (int gap = intArray.length/2; gap >=1; gap/=2) {
            for (int i = gap; i < intArray.length; i++) {
                int temp = intArray[i];
                for (j = i; j > gap -1 && temp < intArray[j - gap]; j-=gap) {
                    intArray[j] = intArray[j - gap];
                }
                intArray[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        new ShellSort().test();
    }
}
