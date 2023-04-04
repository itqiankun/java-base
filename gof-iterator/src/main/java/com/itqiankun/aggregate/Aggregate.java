package com.itqiankun.aggregate;

import com.itqiankun.iterator.Iterator;

/**
 * @author: ma_qiankun
 * @date: 2023/4/4
 **/
public interface Aggregate {

    void add(Object object);

    Iterator iterator();

}
