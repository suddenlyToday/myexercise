package com.liuyitao.exercise.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/***
 *@Author: liuyitao
 *@CreateDate:10:08 AM 11/17/2018
 *@DESC:
 *
 *
 ***/
public final class FileUtils {

    private FileUtils(){}

    /***
     * 读取文件，获得所有行
     * @param path 文件路径
     * @return string list
     * @throws IOException e
     */
    public static List<String> readStringLinesFile(String path) throws IOException {
        try(FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){

            return bufferedReader.lines().filter(str->!str.isEmpty()).collect(Collectors.toList());
        }
    }

}
