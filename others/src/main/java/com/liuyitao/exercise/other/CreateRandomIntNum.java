package com.liuyitao.exercise.other;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/***
 *@Author: liuyitao
 *@CreateDate:11:22 PM 11/16/2018
 *@DESC:
 *
 ***/
public class CreateRandomIntNum {
    public static void main(String[] args) throws IOException {
        int count = 500000;
        String path = "d:\\1.txt";
        Random random = new Random();
        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (int i = 0; i < count; i++) {
                int temp = random.nextInt(count - count / 10) + count / 10 - 1;
                bufferedWriter.write(temp+"");
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }
    }
}
