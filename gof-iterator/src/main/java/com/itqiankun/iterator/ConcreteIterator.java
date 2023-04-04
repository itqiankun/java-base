package com.itqiankun.iterator;

/**
 * @author: ma_qiankun
 * @date: 2023/4/4
 **/
public class ConcreteIterator implements Iterator {

    private Object[] objects;
    public int cursor = 0;    //定义当前游标

    public ConcreteIterator(Object[] objects) {
        this.objects = objects;
    }

    @Override
    public Object next() {
        Object result = null;
        if (this.hasNext()) {
            result = this.objects[cursor++];
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != this.objects.length;
    }

}