package com.itqiankun;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: ma_qiankun
 * @date: 2023/4/4
 **/
public class ForEach {

    public static void main(String args[])
    {
        List<String> strings = new ArrayList<>();
        strings.add("itqiankun.com");
        strings.add("itqiankun.com1");
        strings.add("itqiankun.com2");

        for (String string : strings) {
            if(Objects.equals("itqiankun.com1", string)){
                strings.remove(string);
            }
            System.out.println(string);
        }
    }
}
