package com.itqiankun;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
public class Demo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("itqiankun.com");
        strings.add("itqiankun.com1");
        strings.add("itqiankun.com2");
        strings.add("itqiankun.com3");
        strings.add("itqiankun.com4");

        Iterator<String> iterator = strings.iterator();
        try {
            while (iterator.hasNext()){
                String string = iterator.next();
                if(Objects.equals("itqiankun.com", string)){
                    iterator.remove();
                }
                System.out.println(string);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
