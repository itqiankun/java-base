package com.itqiankun;

import com.itqiankun.aggregate.Aggregate;
import com.itqiankun.aggregate.ConcreteAggregate;
import com.itqiankun.iterator.Iterator;

/**
 * @author: ma_qiankun
 * @date: 2023/4/4
 **/
public class Client {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("itqiankun.com");
        aggregate.add("itqiankun");
        aggregate.add("maqiankun");

        //遍历
        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}