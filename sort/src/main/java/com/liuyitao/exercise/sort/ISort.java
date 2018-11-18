package com.liuyitao.exercise.sort;

/***
 *@author:  liuyitao
 *@CreateDate: 8:52 AM 11/16/2018
 *@DESC: 1
 *
 ***/
public interface ISort {

    /***
     * sort
     * @param array array to sort
     * @param <AnyType> t
     */
    <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array);

    /***
     * sort int
     * @param intArray
     */
    void sort(int[] intArray);
}
