package com.itqiankun.doubleArray;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class ArrayToListDemo {

    @Test
    public void  it_qk(){
        Integer [] arr={1,2,3};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println("List elements: " + list);
        list.add(10);
        System.out.println(list);
    }
    @Test
    public void  guava_array_to_list(){
        Integer [] arr={1,2,3};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println("List elements: " + list);
        list.add(10);
        System.out.println(list);
    }

}
