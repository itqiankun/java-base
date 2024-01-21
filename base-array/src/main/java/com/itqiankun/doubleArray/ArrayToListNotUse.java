package com.itqiankun.doubleArray;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/11/30
 **/
public class ArrayToListNotUse {

    @Test
    public void  it_qk(){
        Integer [] arr={1,2,3};

        // 这里的list不能使用`add`方法，所以不要用
        List<Integer> list=  Arrays.asList(arr);
        System.out.println(list);
        list.add(10);
    }
}
