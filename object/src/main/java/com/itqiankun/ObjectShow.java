package com.itqiankun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/4/26
 **/
public class ObjectShow {
    public static void main(String[] args) {
        String str="hello";
        System.out.println(str.getClass());
        Integer num=111;
        System.out.println(num.getClass());
        List<List<String>> listList = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("hello");
        listList.add(strings);
        System.out.println(strings.getClass());
        System.out.println(listList.getClass());
    }
}
