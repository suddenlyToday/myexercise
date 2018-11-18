package com.liuyitao.exercise.sort.test;

import com.liuyitao.exercise.sort.ISort;
import org.junit.Assert;
import org.junit.Test;

/***
 *@Author: liuyitao
 *@CreateDate:10:59 PM 11/16/2018
 *@DESC:
 *
 *
 *@Modify:
 ***/
public abstract class AbstractSortTest {

    private ISort sortor;
    private int[] arrays1 = {7,4,6,2,5};
    private int[] arrays2 = {7};
    private int[] arrays3 = {};
    private int[] arrays4 = {2,1};

    @Test
    public void test()
    {
        setSortorInSub();
        sortor.sort(arrays1);
        Assert.assertArrayEquals(arrays1,new int[]{2,4,5,6,7});

        sortor.sort(arrays2);
        Assert.assertArrayEquals(arrays2,new int[]{7});

        sortor.sort(arrays3);
        Assert.assertArrayEquals(arrays3,new int[]{});

        sortor.sort(arrays4);
        Assert.assertArrayEquals(arrays4,new int[]{1,2});
    }

    protected void setSortor(ISort sortor)
    {
        this.sortor = sortor;
    }

    protected abstract void setSortorInSub();
}
