package com.liuyitao.exercise.sort;

import com.liuyitao.exercise.common.ArrayUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

/***
 *@Author: liuyitao
 *@CreateDate:12:24 PM 11/17/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public class AbstractSort implements ISort {
    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        throw new NotImplementedException();
    }

    @Override
    public void sort(int[] intArray) {
        System.out.println("sort int array");
    }

    protected void test() {

        for (int i = 0; i < 10; i++) {
            int[] intArray = ArrayUtils.createIntArrayWithNotDuplicatedValue(10000000, 2000000);
            System.out.println("sort "+ i +" times");
            long start = System.currentTimeMillis();
            this.sort(intArray);
            System.out.println("spend "+ (System.currentTimeMillis() - start) +" ms");
        }


    }

    private static Integer[] strList2Array(List<String> strs) {
        return strs.parallelStream().map(Integer::parseInt)
                .collect(Collectors.toList())
                .toArray(new Integer[strs.size()]);
    }
}
