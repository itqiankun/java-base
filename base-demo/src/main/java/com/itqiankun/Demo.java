package com.itqiankun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
public class Demo<T> {

    public static void main(String[] args) {

        //限制T 为String 类型
        Demo<String> demo = new Demo<>();
        List<String> array = new ArrayList<>();
        array.add("test");
        array.add("doub");
        demo.getListFisrt(array);

        //获取Integer类型
        Demo<Integer> Demo = new Demo<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(12);
        nums.add(13);
        Demo.getListFisrt(nums);

        //获取Integer类型
        Demo<List<String>> Demo2 = new Demo<>();
        List<List<String>> listList = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("hello");
        listList.add(strings);
        Demo2.getListFisrt(listList);
    }

    /**
     * 这个只能传递T类型的数据
     * 返回值 就是Demo<T> 实例化传递的对象类型
     * @param data
     * @return
     */
    private T getListFisrt(List<T> data) {
        if (data == null || data.size() == 0) {
            return null;
        }
        T t = data.get(0);
        System.out.println(t.getClass()); // 打印T泛型类型
        return t;
    }
}
