package com.liuyitao.exercise.other;

import com.liuyitao.exercise.sort.ShellSort.ShellSort;

import java.util.Arrays;
import java.util.Random;

/***
 *@Author: liuyitao
 *@CreateDate:11:35 PM 11/17/2018
 *@DESC: 在0-n之间获取k个随机数，不能有重复
 *
 *
 *@Modify:
 ***/
public class CreateRandomIntWithoutDuplicated{

    /****
     *
     * @param n 0-n之间生成随机数
     * @param k 生成k个不重复的随机数
     * @return int[]
     */
    public int[] getNotDuplicatedInts(int n, int k) {
        if (n < 0) {
            throw new IllegalArgumentException("wron param n");
        }
        byte[] temp = new byte[n];
        Random random = new Random();
        int count = k;

        int[] res = new int[count];

        while (count > 0) {
            while (true) {
                int randomInt = random.nextInt(n);
                if (temp[randomInt] == 0) {
                    temp[randomInt] = 1;
                    count--;
                    res[count] = randomInt;
                    break;
                }
            }
        }

        return res;
    }

    /****
     * 使用位向量来表示已经生成的随机数，e.g 如果生成2，将第二位设为1，如果下次再生成2，发现第二位为1，即为重复
     * @param n n
     * @param k k
     * @return int[]
     */
    public int[] getNotDuplicatedIntsWithBit(int n, int k) {
        if (n < 0) {
            throw new IllegalArgumentException("wron param n");
        }
        int byteSize = 8;
        byte[] temp = new byte[n % byteSize == 0 ? n / byteSize : n / byteSize + 1];
        Random random = new Random();
        int count = k;

        int[] res = new int[count];

        byte initByte = 0X01;
        while (count > 0) {
            while (true) {
                int randomInt = random.nextInt(n);

                int bitCount = randomInt % byteSize == 0 ? byteSize : randomInt % byteSize;
                int byteIndex = (bitCount == byteSize ? randomInt / byteSize - 1 : randomInt / byteSize) - 1;

                if ((temp[byteIndex] & (initByte << (byteSize - bitCount))) == 0) {
                    temp[byteIndex] += initByte << (byteSize - bitCount);
                    count--;
                    res[count] = randomInt;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = new CreateRandomIntWithoutDuplicated().getNotDuplicatedIntsWithBit(10000000, 10000);
        new CountTimeShellSort().sort(res);
        System.out.println(Arrays.toString(res));
        System.out.println(res.length);
    }


}

class CountTimeShellSort extends ShellSort {
    @Override
    public void sort(int[] intArray) {
        long startDate = System.currentTimeMillis();
        super.sort(intArray);
        System.out.println("shell sort spend : " + (System.currentTimeMillis() - startDate) + " ms");
    }
}
