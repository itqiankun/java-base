package com.itqiankun.doubleArray;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: ma_qiankun
 * @date: 2023/11/30
 **/
public class ArrayToList {

    @Test
    public void  it_qk(){
        Integer [] arr={1,2,3};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println("List elements: " + list);
        list.add(10);
        System.out.println(list);
    }


}
