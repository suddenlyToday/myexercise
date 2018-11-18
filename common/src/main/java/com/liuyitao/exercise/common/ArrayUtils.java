package com.liuyitao.exercise.common;

import java.util.Objects;
import java.util.Random;

/***
 *@Author: liuyitao
 *@CreateDate:3:47 PM 11/18/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public final class ArrayUtils {

    private final static int BYTE_SIZE = 8;

    private ArrayUtils() {
    }

    /***
     * 判断int数组中是否有重复
     * @param intArray int array
     * @return true is has duplicated value
     */
    public static boolean isAnyDuplicatedInIntArray(int[] intArray) {
        Objects.requireNonNull(intArray);
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /***
     * 在0-range中生成count个没有重复的随机数
     * @param range 生成随机数的范围 0-range
     * @param count 生成多少个随机数
     * @return int[]
     */
    public static int[] createIntArrayWithNotDuplicatedValue(int range, int count) {

        if (range < 0 || count < 0 || range < count) {
            throw new IllegalArgumentException("wrong param");
        }

        byte[] bytes = new byte[range % BYTE_SIZE == 0 ? range / BYTE_SIZE : range / BYTE_SIZE + 1];

        Random random = new Random();

        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            while (true) {
                int temp = random.nextInt(range);
                if (setIntValue2ByteBit(bytes, temp)) {
                    res[i] = temp;
                    break;
                }
            }
        }
        return res;
    }

    private static boolean setIntValue2ByteBit(byte[] byteArray, int value) {
        byte initByte = 0X01;

        int byteBit = value % BYTE_SIZE;
        int arrayIndex = value / BYTE_SIZE;
        int calcByteValue = initByte << (BYTE_SIZE - byteBit - 1);
        boolean notSetInbyteArrayBit = (byteArray[arrayIndex] & calcByteValue) == 0;
        if (notSetInbyteArrayBit) {
            byteArray[arrayIndex] ^= calcByteValue;
        }
        return notSetInbyteArrayBit;
    }

}
