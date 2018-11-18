package com.liuyitao.exercise.sort.bitvector;

import com.liuyitao.exercise.sort.AbstractSort;

import java.util.Objects;

/***
 *@Author: liuyitao
 *@CreateDate:11:33 PM 11/17/2018
 *@DESC: 通过位向量记整数数据\n\r 只适用于没有重复数据且知道数据范围的的情况
 *
 *
 *@Modify:
 ***/
public class BitVectorSort extends AbstractSort {

    private final int range;

    private final static int BYTE_SIZE = 8;

    public BitVectorSort(int range) {
        this.range = range;
    }

    @Override
    public void sort(int[] intArray) {
        super.sort(intArray);
        Objects.requireNonNull(intArray);
        byte[] bytes = intArray2ByteBitArray(intArray);
        int count = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = BYTE_SIZE - 1; j >= 0; j--) {
                if ((bytes[i] & (1 << j)) != 0) {
                    intArray[count] = (i + 1) * BYTE_SIZE - j-1;
                    count++;
                }
            }
        }
    }

    private byte[] intArray2ByteBitArray(int[] intArray) {
        byte[] res = new byte[range % BYTE_SIZE == 0 ? range / BYTE_SIZE : range / BYTE_SIZE + 1];

        byte initByte = 0X01;
        for (int anInt : intArray) {
            int byteBit = anInt % BYTE_SIZE;
            int index = anInt / BYTE_SIZE;
            res[index] ^= initByte << (BYTE_SIZE - byteBit - 1);
        }
        return res;
    }
    public static void main(String[] args) {
        new BitVectorSort(10000000).test();
    }

}
