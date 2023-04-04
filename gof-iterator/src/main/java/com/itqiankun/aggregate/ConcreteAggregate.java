package com.itqiankun.aggregate;

import com.itqiankun.iterator.ConcreteIterator;
import com.itqiankun.iterator.Iterator;

/**
 * @author: ma_qiankun
 * @date: 2023/4/4
 **/
public class ConcreteAggregate implements Aggregate {

    private Object[] objects = new Object[10];
    private int size=0;

    @Override
    public void add(Object object) {
        objects[size++] = object;
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this.objects);
    }

}